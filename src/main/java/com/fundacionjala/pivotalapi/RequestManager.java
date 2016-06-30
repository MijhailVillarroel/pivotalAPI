package com.fundacionjala.pivotalapi;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.Reader;
import java.util.Map;


public final class RequestManager {


    public static final RequestSpecification REQUEST_SPECIFICATION = Authentication.getInstance().getRequestSpecification();

    private RequestManager(){
    }

    public static Response getRequest(String endpoint){
        System.out.println(endpoint);
        return REQUEST_SPECIFICATION.when().get(endpoint);
    }

    public static Response postRequest(String endpoint, Map<String,Object> parameters ){

        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);
        System.out.println(parametersJson);
        parametersJson.put("public",true);
        return REQUEST_SPECIFICATION.body(parameters).when().post(endpoint);
    }

    public static Response putRequest(String endpoint, Map<String,Object> parameters ){
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);

        return REQUEST_SPECIFICATION.contentType("application/json").and().body(parametersJson).when().put(endpoint);
    }

    public static Response deleteRequest(String endpoint, Map<String,String> parameters ){
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);

        return REQUEST_SPECIFICATION.contentType("application/json").and().body(parametersJson).when().delete(endpoint);
    }
}

