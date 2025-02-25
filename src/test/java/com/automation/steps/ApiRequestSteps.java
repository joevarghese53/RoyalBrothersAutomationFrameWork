package com.automation.steps;

import com.automation.pojo.CreateUserRequestPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.FileNotFoundException;
import java.lang.reflect.Field;

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


    @When("user makes get request")
    public void userMakesGetRequest() {
        RestAssuredUtils.get();
    }

    @When("user makes put request")
    public void userMakesPutRequest() {
        RestAssuredUtils.put();
    }

    @And("user makes delete request")
    public void userMakesDeleteRequest() {
        RestAssuredUtils.delete();
    }

    @And("user set request body from file {string} using pojo with {string} value {string}")
    public void userSetRequestBodyFromFileUsingPojoWithValue(String filename, String fieldname, String value) throws Exception {
        String body = RestAssuredUtils.getJsonDataFromFile(filename);
        ObjectMapper objectMapper = new ObjectMapper();
        CreateUserRequestPojo requestPojo = objectMapper.readValue(body, CreateUserRequestPojo.class);
        Field field=CreateUserRequestPojo.class.getDeclaredField(fieldname);
        field.setAccessible(true);
        field.set(requestPojo,value);
        RestAssuredUtils.setRequestBody(requestPojo);
        ConfigReader.setObject("request.pojo", requestPojo);
    }

    @And("user set request body from file {string} setting {string} value {string}")
    public void userSetRequestBodyFromFileSettingValue(String arg0, String arg1, String arg2) {
    }
}
