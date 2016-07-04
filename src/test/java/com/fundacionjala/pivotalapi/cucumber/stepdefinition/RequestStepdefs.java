package com.fundacionjala.pivotalapi.cucumber.stepdefinition;

import com.fundacionjala.pivotalapi.DataBase;
import com.fundacionjala.pivotalapi.RequestManager;
import com.jayway.restassured.response.Response;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java.it.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mijhailvillarroel on 6/30/2016.
 */
public class RequestStepdefs {
    private Response response;
    private Map<String, Response> project = new HashMap<String, Response>();
    private String urlEndPoint;

    @When("^I send a post request (.*) with:$")
    public void iSendAGETRequestTheProjectsToProjects(String endPoint, Map<String, Object> values) {
        urlEndPoint = DataBase.endPoint(endPoint, project);
        response = RequestManager.postRequest(urlEndPoint, values);
    }

    @When("^I send a put request (.*) with:$")
    public void iSendAPUTRequestTheProjectsToProjects(String endPoint, Map<String, Object> values) {
        urlEndPoint = DataBase.endPoint(endPoint, project);
        response = RequestManager.putRequest(urlEndPoint, values);
    }

    @Given("^I has be create a one (.*) whit:$")
    public void iHasBeCreateAOneProjectsWhit(String endPoint, Map<String, Object> values) {
        response = RequestManager.postRequest(endPoint, values);
    }

    @Given("^I send a delete request (.*)$")
    public void iSendAPutRequestDeleteOneProjects(String endPoint) {
        urlEndPoint = DataBase.endPoint(endPoint, project);
        response = RequestManager.deleteRequest(DataBase.endPoint(urlEndPoint, project));
    }

    @And("^I has be create story a one /stories whit:$")
    public void iHasBeCreateStoryAOneStoriesWhit(String endPoint, Map<String, Object> values) {
        String project = "/projects/" + response.jsonPath().get("id") + "/stories";
        response = RequestManager.postRequest(project, values);
    }

    @Then("^store (.*)$")
    public void storeProject(String nameProject) throws Throwable {
        project.put(nameProject, response);
    }

    public String getUrlEndPoint() {

        final String [] values = urlEndPoint.split("/");
        return "/"+values[1]+"/"+values[2];
    }

    public Response getResponse() {
        return response;
    }
}
