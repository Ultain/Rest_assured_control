package tests;

import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static logic.common.AuthData.BASIC_USER;
import static logic.common.EndPoints.TRANSLATE_TEXT;
import static logic.constants.HeadersLabels.RAPIDAPI_HOST;
import static logic.constants.HeadersLabels.RAPIDAPI_KEY;
import static logic.constants.TranslateTextParams.*;

public class TranslateTextTest {

    @BeforeClass
    public void install(){

    }

    @AfterClass
    public void clean(){

    }

    @Test
    public void test01withValidData(){

        // С набором валидных данных
        Map<String, String> headers = new HashMap<>();
        headers.put(RAPIDAPI_HOST.getLabel(), BASIC_USER.getHost());
        headers.put(RAPIDAPI_KEY.getLabel(), BASIC_USER.getKey());

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

    }

    @Test
    public void test02withInvalidText(){

        // С не валидным текстом (возвращает не переведенный текст)
        Map<String, String> headers = new HashMap<>();
        headers.put(RAPIDAPI_HOST.getLabel(), BASIC_USER.getHost());
        headers.put(RAPIDAPI_KEY.getLabel(), BASIC_USER.getKey());

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
        Map<String, String> headers = new HashMap<>();
        headers.put(RAPIDAPI_HOST.getLabel(), BASIC_USER.getHost());
        headers.put(RAPIDAPI_KEY.getLabel(), BASIC_USER.getKey());

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
        Map<String, String> headers = new HashMap<>();
        headers.put(RAPIDAPI_HOST.getLabel(), BASIC_USER.getHost());
        headers.put(RAPIDAPI_KEY.getLabel(), BASIC_USER.getKey());

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