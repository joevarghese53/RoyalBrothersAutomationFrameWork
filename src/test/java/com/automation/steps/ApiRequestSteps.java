package com.automation.steps;

import com.automation.pojo.CreateUserRequestPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.FileNotFoundException;

public class ApiRequestSteps {
    @Given("user calls {string} endpoint")
    public void userCallsEndpoint(String endPoint) {
        RestAssuredUtils.setEndpoint(endPoint);
    }

    @And("set header {string} to {string}")
    public void setHeaderTo(String key, String value) {
        RestAssuredUtils.setHeader(key, value);
    }

    @And("set request body from file {string} using pojo")
    public void setRequestBodyFromFileUsingPojo(String fileName) throws Exception {
        String content = RestAssuredUtils.getJsonDataFromFile(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        CreateUserRequestPojo request_pojo = objectMapper.readValue(content, CreateUserRequestPojo.class);
        RestAssuredUtils.setRequestBody(request_pojo);
        ConfigReader.setObject("request_pojo", request_pojo);
    }

    @When("user makes post request")
    public void userMakesPostRequest() {
        RestAssuredUtils.post();
    }

    @Then("verify status code is {int}")
    public void verifyStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());
    }

    @When("user makes get request")
    public void userMakesGetRequest() {
        RestAssuredUtils.get();
    }

    @When("user makes put request")
    public void userMakesPutRequest() {
        RestAssuredUtils.put();
    }

    @And("verify json value of {string} is {string}")
    public void verifyJsonValueOfIs(String jsonField, String JsonValue) {
        Assert.assertTrue(RestAssuredUtils.getResponseFieldValue(jsonField).equalsIgnoreCase(JsonValue));
    }
}
