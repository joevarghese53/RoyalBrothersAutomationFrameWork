package com.automation.steps;

import com.automation.pojo.CreateUserRequestPojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.Constants;
import com.automation.utils.RestAssuredUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import java.io.FileNotFoundException;
import java.lang.reflect.Field;

public class ApiRequestSteps {
    @Given("user calls {string} endpoint")
    public void userCallsEndpoint(String endPoint) {
        RestAssuredUtils.setEndpoint(endPoint);
    }

    @And("sets path param for {string} as {string}")
    public void setsPathParamForAs(String key, String value) {
        RestAssuredUtils.setPathParam(key, value);
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

    @And("user set request body from file {string} using pojo with {string} value {string}")
    public void userSetRequestBodyFromFileUsingPojoWithValue(String fileName, String fieldName, String value) throws Exception {
        String body = RestAssuredUtils.getJsonDataFromFile(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        CreateUserRequestPojo requestPojo = objectMapper.readValue(body, CreateUserRequestPojo.class);
        Field field = CreateUserRequestPojo.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        if (Constants.createBookingIntFields.contains(fieldName)) {
            field.set(requestPojo, Integer.valueOf(value));
        } else {
            field.set(requestPojo, value);
        }
        RestAssuredUtils.setRequestBody(requestPojo);
        ConfigReader.setObject("request.pojo", requestPojo);
    }

    @And("user set request body from file {string}")
    public void userSetRequestBodyFromFile(String filename) throws FileNotFoundException {
        RestAssuredUtils.setRequestBody(filename);
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
}
