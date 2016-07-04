package com.fundacionjala.pivotalapi;

import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.specification.RequestSpecification;

import static com.jayway.restassured.RestAssured.baseURI;
import static com.jayway.restassured.RestAssured.given;

public class Authentication {

    private static Authentication instance;

    private RequestSpecification requestSpecification;
    private Authentication() {
        initApi();
    }

    public static Authentication getInstance() {
        if (instance == null) {
            instance = new Authentication();
        }
        return instance;
    }

    private void initApi() {
        baseURI = PropertiesInfo.getInstance().getBaseUrl();
        requestSpecification = given().relaxedHTTPSValidation()
                .proxy(PropertiesInfo.getInstance().getProxy())
                .header(PropertiesInfo.getInstance().getHeaderToken(), PropertiesInfo.getInstance().getToken())
                .contentType(ContentType.JSON);
    }

    public RequestSpecification getRequestSpecification() {
        return requestSpecification;
    }
}
