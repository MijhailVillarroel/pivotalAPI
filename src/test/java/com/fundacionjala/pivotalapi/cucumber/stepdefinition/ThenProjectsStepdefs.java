package com.fundacionjala.pivotalapi.cucumber.stepdefinition;

import com.jayway.restassured.response.Response;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.junit.Assert;

/**
 * Created by mijhailvillarroel on 6/30/2016.
 */
public class ThenProjectsStepdefs {

    private ProjectsStepdefs projectsStepdefs;

    public ThenProjectsStepdefs(ProjectsStepdefs projectsStepdefs) {
        this.projectsStepdefs = projectsStepdefs;
    }
    @And("^I expect validate the values of the projects return by request$")
    public void iExpectValidateTheValuesOfTheProjectsReturnByRequest() {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I expect Status the projects code (\\d+)$")
    public void iExpectStatusTheProjectsCode(int status) {
        Assert.assertEquals(status,projectsStepdefs.getResponse().getStatusCode());
    }


}
