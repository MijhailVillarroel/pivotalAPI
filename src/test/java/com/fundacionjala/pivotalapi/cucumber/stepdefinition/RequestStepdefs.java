package com.fundacionjala.pivotalapi.cucumber.stepdefinition;

import com.fundacionjala.pivotalapi.RequestManager;
import com.jayway.restassured.response.Response;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mijhailvillarroel on 6/30/2016.
 */
public class RequestStepdefs {
    private Response response;
    private Map<String, Object> project;

    public String endpoint(String endPoint) {
        if(endPoint.contains("[")) {
            String [] string = endPoint.split("/");
            for (int i =0;i>string.length;i++){
                if(endPoint.contains("[")) {
                    
                }
            }

        }
        return endPoint;
    }

    @When("^I send a post request (.*) with:$")
    public void iSendAGETRequestTheProjectsToProjects(String endPoint, Map<String, Object> values) {

        if ("/stories".equalsIgnoreCase(endPoint)){
            StringBuilder url = new StringBuilder();
            url.append("/projects");
            url.append("/");
            url.append(response.jsonPath().get("id"));
            url.append(endPoint);
            System.out.println(url);
            response = RequestManager.postRequest(url.toString(), values);
        }else{

            response = RequestManager.postRequest(endPoint, values);
        }
    }

    @When("^I send a put request (.*) with:$")
    public void iSendAPUTRequestTheProjectsToProjects(String endPoint, Map<String, Object> values) {
        final String idDelete = endPoint+"/"+response.jsonPath().get("id");
        response = RequestManager.putRequest(idDelete, values);
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

    @Given("^I has be create a one (.*) whit:$")
    public void iHasBeCreateAOneProjectsWhit(String endPoint, Map<String, Object> values) {
        response = RequestManager.postRequest(endPoint, values);
    }

    @Given("^I send a delete request delete one (.*)$")
    public void iSendAPutRequestDeleteOneProjects(String endPoint) {
        final String idDelete = endPoint+"/"+response.jsonPath().get("id");
        System.out.println(idDelete);
        response = RequestManager.deleteRequest(idDelete, null);
    }

    @And("^I has be create story a one /stories whit:$")
    public void iHasBeCreateStoryAOneStoriesWhit(String endPoint, Map<String, Object> values) {
        String project = "/projects/"+response.jsonPath().get("id")+"/stories";
        response = RequestManager.postRequest(project, values);
    }

    @Then("^store (.*)$")
    public void storeProject(String nameProject) throws Throwable {
        project = new HashMap<String, Object>();
        project.put(nameProject, response);
    }
}
