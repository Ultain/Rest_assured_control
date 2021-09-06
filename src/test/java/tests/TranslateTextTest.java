package tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.restassured.response.Response;
import logic.responses.ResponceTranslate;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static logic.common.AuthData.BASIC_USER;
import static logic.common.EndPoints.TRANSLATE_TEXT;
import static logic.constants.HeadersLabels.RAPIDAPI_HOST;
import static logic.constants.HeadersLabels.RAPIDAPI_KEY;
import static logic.constants.TranslateTextParams.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TranslateTextTest {

    Map<String, String> headers = new HashMap<>();

    @BeforeClass
    public void install(){
        headers.put(RAPIDAPI_HOST.getLabel(), BASIC_USER.getHost());
        headers.put(RAPIDAPI_KEY.getLabel(), BASIC_USER.getKey());
    }

    @AfterClass
    public void clean(){
    }

    @Test
    public void test01withValidData(){

        // С набором валидных данных
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put(TEXT_LABEL.getParam(), ENGLISH_TEXT.getParam());
        queryParams.put(TARGET_LANG.getParam(), UKRAINIAN.getParam());
        queryParams.put(SOURCE_LANG.getParam(), ENGLISH.getParam());

        Response response = given()
                .headers(headers)
                .queryParams(queryParams)
                .log().all()
                .when()
                .get(TRANSLATE_TEXT.getURI())
                .then()
                .log().all()
                .extract().response();

        // GSON
/*        ResponceTranslate responceTranslate = GsonHandler.getResponce(response.getBody().asString(), ResponceTranslate.class);

        assertThat(responceTranslate.getMessage().contains(""), is(true));
        */
/*        List<ResponceTranslate> list =
                Arrays.asList(GsonHandler.getResponce(response.getBody().asString(), ResponceTranslate.class));

        assertThat(list.stream().anyMatch(o->o.getMessage().contains("")), is(true));
        */

        // Jackson
        Map<String, Object> translateInfo = null;
        try {
            translateInfo = new ObjectMapper().readValue(response.getBody().asString(), HashMap.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        assertThat(Integer.parseInt(translateInfo.get("code").toString()), is(200));

        // Gson

        // typing response to file "data.json"
        try(FileWriter writer = new FileWriter("src/test/resources/data.json", false))
        {
            writer.write(response.getBody().asString());
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        // making assertion with getTranslation method using Gson parser
        File input = new File("src/test/resources/data.json");
        try {
            JsonElement fileElement = JsonParser.parseReader(new FileReader(input));
            JsonObject fileObject = fileElement.getAsJsonObject();

            //Integer code = fileObject.get("code").getAsInt();
            //String data = fileObject.get("data").toString();

            ResponceTranslate responceTranslate1 = new Gson().fromJson(fileElement, ResponceTranslate.class);

            System.out.println("Translation Gson'a: " + responceTranslate1.getData().getTranslation().toString());

            assertThat(responceTranslate1.getData().getTranslation().contains("HMS Royal Oak"), is(true));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test02withInvalidText(){

        // С не валидным текстом (возвращает не переведенный текст)
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put(TEXT_LABEL.getParam(), DEUTSCH_TEXT.getParam());
        queryParams.put(TARGET_LANG.getParam(), UKRAINIAN.getParam());
        queryParams.put(SOURCE_LANG.getParam(), ENGLISH.getParam());

        Response response = given()
                .headers(headers)
                .queryParams(queryParams)
                .log().all()
                .when()
                .get(TRANSLATE_TEXT.getURI())
                .then()
                .log().all()
                .extract().response();

    }

    @Test
    public void test03withInvalidText(){

        // С английским текстом перевод прокатывает
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put(TEXT_LABEL.getParam(), ENGLISH_TEXT.getParam());
        queryParams.put(TARGET_LANG.getParam(), UKRAINIAN.getParam());
        queryParams.put(SOURCE_LANG.getParam(), ARABIC.getParam());

        Response response = given()
                .headers(headers)
                .queryParams(queryParams)
                .log().all()
                .when()
                .get(TRANSLATE_TEXT.getURI())
                .then()
                .log().all()
                .extract().response();

    }

    @Test
    public void test04withInvalidSourceLang(){

        // С неправильным параметром исходного языка - "message": "The language 'mur' is not supported"
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put(TEXT_LABEL.getParam(), ENGLISH_TEXT.getParam());
        queryParams.put(TARGET_LANG.getParam(), UKRAINIAN.getParam());
        queryParams.put(SOURCE_LANG.getParam(), "mur");

        Response response = given()
                .headers(headers)
                .queryParams(queryParams)
                .log().all()
                .when()
                .get(TRANSLATE_TEXT.getURI())
                .then()
                .log().all()
                .extract().response();

    }

    @Test
    public void test05ValidDataWithoutAuth(){

        // С валидными данными, но без авторизации (хоста и ключа) - "message": "Invalid API key. Go to https://docs.rapidapi.com/docs/keys for more info."
        Map<String, String> queryParams = new HashMap<>();
        queryParams.put(TEXT_LABEL.getParam(), ENGLISH_TEXT.getParam());
        queryParams.put(TARGET_LANG.getParam(), UKRAINIAN.getParam());
        queryParams.put(SOURCE_LANG.getParam(), ARABIC.getParam());

        Response response = given()
                .queryParams(queryParams)
                .log().all()
                .when()
                .get(TRANSLATE_TEXT.getURI())
                .then()
                .log().all()
                .extract().response();

    }

}
