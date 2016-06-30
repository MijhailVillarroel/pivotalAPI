package com.fundacionjala.pivotalapi;

import java.util.Map;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.codehaus.groovy.runtime.powerassert.SourceText;
import org.json.simple.JSONObject;


public class ManagerRequest {

    private RequestSpecification response;

    public ManagerRequest(){
        response = Authentication.getInstance().getRequestSpecification();
    }

    public Response getRequest(String endpoint){
        System.out.println(endpoint);
        return response.when().get(endpoint);
    }

    public Response postRequest(String endpoint, Map<String,Object> parameters ){
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);
        return response.contentType("application/json").and().body(parametersJson).when().post(endpoint);
    }

    public Response putRequest(String endpoint, Map<String,Object> parameters ){
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);

        return response.contentType("application/json").and().body(parametersJson).when().put(endpoint);
    }

    public Response deleteRequest(String endpoint, Map<String,String> parameters ){
        JSONObject parametersJson = new JSONObject();
        parametersJson.putAll(parameters);

        return response.contentType("application/json").and().body(parametersJson).when().delete(endpoint);
    }
}

