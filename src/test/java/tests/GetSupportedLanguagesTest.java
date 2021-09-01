package tests;

import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static logic.common.AuthData.BASIC_USER;
import static logic.common.EndPoints.GET_SUPPORTED_LANGUAGES;
import static logic.constants.HeadersLabels.RAPIDAPI_HOST;
import static logic.constants.HeadersLabels.RAPIDAPI_KEY;

public class GetSupportedLanguagesTest {

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

        Response response = given()
                .headers(headers)
                .log().all()
                .when()
                .get(GET_SUPPORTED_LANGUAGES.getURI())
                .then()
                .log().all()
                .extract().response();
    }

    @Test
    public void test02WithoutAuth(){

        // Без авторизации - "message": "Invalid API key. Go to https://docs.rapidapi.com/docs/keys for more info."

        Response response = given()
                .log().all()
                .when()
                .get(GET_SUPPORTED_LANGUAGES.getURI())
                .then()
                .log().all()
                .extract().response();
    }

}
