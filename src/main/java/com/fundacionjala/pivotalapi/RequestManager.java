package com.fundacionjala.pivotalapi;

import java.util.Map;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;

import static com.jayway.restassured.RestAssured.given;


public final class RequestManager {

    private static final Logger LOGGER = Logger.getLogger(PropertiesInfo.class);

    private static final RequestSpecification REQUEST_SPECIFICATION = Authentication.getInstance().getRequestSpecification();

    private RequestManager() {
    }

    public static Response getRequest(String endpoint) {
        //    System.out.println(endpoint);
        LOGGER.info("GET :" + endpoint);
        return REQUEST_SPECIFICATION.when().get(endpoint);
    }

    public static Response postRequest(String endpoint, Map<String, Object> parameters) {
        LOGGER.info("POST :" + endpoint);
        JsonElement jsonObject = new JsonParser().parse(parameters.toString());
        LOGGER.info("BODY POST JSON :" + jsonObject);
        return given().spec(REQUEST_SPECIFICATION.contentType(ContentType.JSON))
                .body(jsonObject)
                .when().post(endpoint);
    }

    public static Response putRequest(String endpoint, Map<String, Object> parameters) {
        LOGGER.info("PUT :" + endpoint);
        JsonElement jsonObject = new JsonParser().parse(parameters.toString());
        LOGGER.info("BODY PUT JSON :" + jsonObject);
        // System.out.println(jsonParser.parse(parameters.toString()));
        //System.out.println(endpoint);
        return given().spec(REQUEST_SPECIFICATION.contentType(ContentType.JSON))
                .body(jsonObject)
                .when().put(endpoint);
    }

    public static Response deleteRequest(String endpoint) {
      //  System.out.println(endpoint);
        LOGGER.info("DELETE :" + endpoint);
        return given().spec(REQUEST_SPECIFICATION)
                .when().delete(endpoint);

    }
}

