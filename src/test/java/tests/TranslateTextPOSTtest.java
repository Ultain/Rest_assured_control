package tests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static logic.common.AuthData.BASIC_USER;
import static logic.common.EndPoints.TRANSLATE_TEXT;
import static logic.constants.HeadersLabels.*;
import static logic.constants.TranslateTextParams.*;

public class TranslateTextPOSTtest {

    @Test
    public void test01withValidData(){

        // С набором валидных данных
        Map<String, String> headers = new HashMap<>();
        headers.put(RAPIDAPI_HOST.getLabel(), BASIC_USER.getHost());
        headers.put(RAPIDAPI_KEY.getLabel(), BASIC_USER.getKey());
        headers.put(CONTENT_TYPE.getLabel(), BASIC_USER.getContentType());

        Map<String, String> formParams = new HashMap<>();
        formParams.put(TEXT_LABEL.getParam(), ENGLISH_TEXT.getParam());
        formParams.put(TARGET_LANG.getParam(), UKRAINIAN.getParam());
        formParams.put(SOURCE_LANG.getParam(), ENGLISH.getParam());

        Response response = given()
                .headers(headers)
                .formParams(formParams)
                .log().all()
                .when()
                .post(TRANSLATE_TEXT.getURI())
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
        headers.put(CONTENT_TYPE.getLabel(), BASIC_USER.getContentType());

        Map<String, String> formParams = new HashMap<>();
        formParams.put(TEXT_LABEL.getParam(), DEUTSCH_TEXT.getParam());
        formParams.put(TARGET_LANG.getParam(), UKRAINIAN.getParam());
        formParams.put(SOURCE_LANG.getParam(), ENGLISH.getParam());

        Response response = given()
                .headers(headers)
                .formParams(formParams)
                .log().all()
                .when()
                .post(TRANSLATE_TEXT.getURI())
                .then()
                .log().all()
                .extract().response();

    }

    @Test
    public void test03ValidDataWithoutAuth(){

        // С валидными данными, но без авторизации (хоста и ключа) - "message": "Invalid API key. Go to https://docs.rapidapi.com/docs/keys for more info."

        Map<String, String> formParams = new HashMap<>();
        formParams.put(TEXT_LABEL.getParam(), ENGLISH_TEXT.getParam());
        formParams.put(TARGET_LANG.getParam(), UKRAINIAN.getParam());
        formParams.put(SOURCE_LANG.getParam(), ENGLISH.getParam());

        Response response = given()
                .formParams(formParams)
                .log().all()
                .when()
                .post(TRANSLATE_TEXT.getURI())
                .then()
                .log().all()
                .extract().response();

    }

}
