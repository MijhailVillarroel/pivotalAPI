package com.fundacionjala.pivotalapi.cucumber.stepdefinition;

import com.fundacionjala.pivotalapi.RequestManager;
import com.jayway.restassured.response.Response;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mijhailvillarroel on 7/1/2016.
 */
public class Hook {
    private Response response;

    private RequestStepdefs projectsStepdefs;

    public Hook (RequestStepdefs projectsStepdefs) {
        this.projectsStepdefs = projectsStepdefs;
    }
    public void setUp() {
        Map<String, Object> values = new HashMap<String, Object>();
        values.put("name","projectPut");
        values.put("public",true);
        response = RequestManager.postRequest("/projects", values);
    }

    @After("@deleteProject")
    public void cleanUp() {
        final String idDelete = "projects"+"/"+projectsStepdefs.getResponse().jsonPath().get("id");
        response = RequestManager.deleteRequest(idDelete, null);
    }
}
