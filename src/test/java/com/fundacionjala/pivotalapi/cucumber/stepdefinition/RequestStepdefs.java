package com.fundacionjala.pivotalapi.cucumber.stepdefinition;

import com.fundacionjala.pivotalapi.RequestManager;
import com.jayway.restassured.response.Response;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.Map;

/**
 * Created by mijhailvillarroel on 6/30/2016.
 */
public class RequestStepdefs {
    private Response response;

    @When("^I send a post request (.*) with:$")
    public void iSendAGETRequestTheProjectsToProjects(String endPoint, Map<String, Object> values) {
        System.out.println(values);

        response = RequestManager.postRequest(endPoint, values);
        System.out.println(response.prettyPrint());
    }
//
//    @When("^I send a GET request the projects to (\\/projects)$")
//    public void iSendAGETRequestTheProjectsToProjects(String endPoint) {
//        // Write code here that turns the phrase above into concrete actions
//        response = RequestManager.getRequest(endPoint);
//    }
//
//    @And("^I have have  least one project create in /projects/$")
//    public void iHaveHaveLeastOneProjectCreateInProjects() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^I a Delete the project  in request the projects to /projects/$")
//    public void iADeleteTheProjectInRequestTheProjectsToProjects() {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }
//
//    @When("^I send a POST request to (\\/projects) with name project (.*)$")
//    public void iSendAPOSTRequestToProjectsWithNameProjectNameProject(String endpoint, String nameProject) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
//    }

    public Response getResponse(){
        return response;
    }

}
