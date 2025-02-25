package com.automation.steps;

import com.automation.pojo.CreateUserRequestPojo;
import com.automation.pojo.CreateUserResponsePojo;
import com.automation.utils.ConfigReader;
import com.automation.utils.RestAssuredUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.junit.Assert;

public class ApiResponseSteps {
    @And("verify response has body same as request")
    public void verifyResponseHasBodySameAsRequest() {
        Response response = RestAssuredUtils.getResponse();
        CreateUserRequestPojo requestPojo = (CreateUserRequestPojo) ConfigReader.getObject("request_pojo");
        CreateUserResponsePojo response_pojo = response.as(CreateUserResponsePojo.class);
        Assert.assertEquals(requestPojo.getName(), response_pojo.getName());
        Assert.assertEquals(requestPojo.getEmail(), response_pojo.getEmail());
        Assert.assertEquals(requestPojo.getAge(), response_pojo.getAge());
        Assert.assertEquals(requestPojo.getSalary(), response_pojo.getSalary(), 0);
    }

    @And("verify response has schema same as {string}")
    public void verifyResponseHasSchemaSameAs(String fileName) {
        Response response = RestAssuredUtils.getResponse();
        response.then().assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("data/"+fileName));
    }

    @And("store the {string} from response into {string}")
    public void storeTheFromResponseInto(String jsonPath, String key) {
        String value = RestAssuredUtils.getResponseFieldValue(jsonPath);
        ConfigReader.setConfigValue(key, value);
    }

    @Then("verify status code is {int}")
    public void verifyStatusCodeIs(int statusCode) {
        Assert.assertEquals(statusCode, RestAssuredUtils.getStatusCode());
    }

    @And("verify response body has a field {string} as {string}")
    public void verifyResponseBodyHasAFieldAs(String jsonPath, String fieldValue) {
        Assert.assertEquals(fieldValue, RestAssuredUtils.getResponseFieldValue(jsonPath));
    }
}
