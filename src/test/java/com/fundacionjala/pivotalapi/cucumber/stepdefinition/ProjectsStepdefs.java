package com.fundacionjala.pivotalapi.cucumber.stepdefinition;

import com.fundacionjala.pivotalapi.ManagerRequest;
import com.jayway.restassured.response.Response;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

/**
 * Created by mijhailvillarroel on 6/30/2016.
 */
public class ProjectsStepdefs {
    private Response response;
    private ManagerRequest managerRequest;



    @Given("^I have set a connection (.*) to pivotal_tracker API service$")
    public void iHaveSetAConnectionProjectToPivotal_trackerAPIService(String endPoint) {
        managerRequest = new ManagerRequest();
    }

    @When("^I send a GET request the projects to (\\/projects)$")
    public void iSendAGETRequestTheProjectsToProjects(String endPoint) {
        // Write code here that turns the phrase above into concrete actions
        response = managerRequest.getRequest(endPoint);
    }

    @And("^I have have  least one project create in /projects/$")
    public void iHaveHaveLeastOneProjectCreateInProjects() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I a Delete the project  in request the projects to /projects/$")
    public void iADeleteTheProjectInRequestTheProjectsToProjects() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^I send a POST request to (\\/projects) with name project (.*)$")
    public void iSendAPOSTRequestToProjectsWithNameProjectNameProject(String endpoint, String nameProject) {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    public Response getResponse(){
        return response;
    }

}
