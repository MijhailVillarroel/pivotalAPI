package com.fundacionjala.pivotalapi;

import com.google.gson.JsonParser;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import java.util.Map;


public final class RequestManager {


    public static final RequestSpecification REQUEST_SPECIFICATION = Authentication.getInstance().getRequestSpecification();

    private RequestManager(){
    }

    public static Response getRequest(String endpoint){
    //    System.out.println(endpoint);
        return REQUEST_SPECIFICATION.when().get(endpoint);
    }

    public static Response postRequest(String endpoint, Map<String,Object> parameters ) {
        JsonParser par =new JsonParser();
        return REQUEST_SPECIFICATION.body(par.parse(parameters.toString())).when().post(endpoint);
    }

    public static Response putRequest(String endpoint, Map<String,Object> parameters ) {
        JsonParser jsonParser =new JsonParser();
       // System.out.println(jsonParser.parse(parameters.toString()));
        //System.out.println(endpoint);
        return REQUEST_SPECIFICATION.body(jsonParser.parse(parameters.toString())).when().put(endpoint);
    }

    public static Response deleteRequest(String endpoint, Map<String, Object> parameters ) {
        JsonParser jsonParser =new JsonParser();
       // System.out.println(endpoint);
        return REQUEST_SPECIFICATION.body("").when().delete(endpoint);
    }
}

