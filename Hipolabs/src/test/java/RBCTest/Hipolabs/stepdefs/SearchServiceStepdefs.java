package RBCTest.Hipolabs.stepdefs;

import RBCTest.Hipolabs.common.CommonUtil;
import RBCTest.Hipolabs.common.EndPoints;
import io.cucumber.core.exception.CucumberException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.springframework.http.HttpStatus;

import java.net.MalformedURLException;
import java.net.URL;

public class SearchServiceStepdefs extends CommonUtil {

    @Given("Search Service Endpoint is setup")
    public void searchServiceEndpointIsSetup() {
        try {
            endpointObj = new URL(EndPoints.SEARCH_ENDPOINT);
        } catch (MalformedURLException e) {
            throw new CucumberException(e);
        }

    }

    @And("I add parameter {} as {}")
    public void iAddParameterParameterNameAsParamValue(String paramName, String paramValue) {
        queryParams.put(paramName, paramValue);
    }

    @When("I hit the Search Service Endpoint")
    public void iHitTheSearchServiceEndpoint() {

        response = invokeGetService();
    }

    @Then("success response should be returned")
    public void successResponseShouldBeReturned() {

        String failMessage = "Service call to " + endpointObj.toString() + " failed";
        Assert.assertEquals(failMessage, HttpStatus.OK.value(), response.getStatus());

        failMessage = "Service call to " + endpointObj.toString() + " gave empty response.";
        Assert.assertTrue(failMessage, response.getBody().getArray().length() > 0);

    }

    @And("response should have value {} in field {}")
    public void responseShouldHaveValueParamValueInFieldParameterName(String paramValue, String paramName) throws Exception {
        JSONArray searchResultArray = response.getBody().getArray();

        for (int i = 0; i < searchResultArray.length(); i++) {
            JSONObject universityObj = searchResultArray.getJSONObject(i);
            String actParamValue = universityObj.get(paramName).toString();

            String failMessage = "Service response  " + endpointObj.toString() + " with parameter " + paramValue + "dont have value " + paramValue;
            Assert.assertEquals(failMessage, paramValue, actParamValue);

        }

    }

    @And("response should contain value {} in field {}")
    public void responseShouldContainValueParamValueInFieldParameterName(String paramValue, String paramName) throws JSONException {

        JSONArray searchResultArray = response.getBody().getArray();

        for (int i = 0; i < searchResultArray.length(); i++) {
            JSONObject universityObj = searchResultArray.getJSONObject(i);
            String actParamValue = universityObj.get(paramName).toString();

            String failMessage = "Service response  " + endpointObj.toString() + " with parameter " + paramValue + ", dont contain value " + paramValue + " in response.";
            Assert.assertTrue(failMessage, actParamValue.toLowerCase().contains(paramValue.toLowerCase()));
            //Assert.assertTrue(failMessage, actParamValue.contains(paramValue));

        }
    }
}
