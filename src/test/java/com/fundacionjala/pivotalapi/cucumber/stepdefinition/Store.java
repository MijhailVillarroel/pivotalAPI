package com.fundacionjala.pivotalapi.cucumber.stepdefinition;

import com.jayway.restassured.response.Response;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;

/**
 * Created by mijhailvillarroel on 7/1/2016.
 */
public class Store {
    private Response response;
    public Store(Response response){
        this.response = response;
    }

    public String getId(){
        return response.jsonPath().get("id");
    }
}
