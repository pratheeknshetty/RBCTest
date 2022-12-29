package RBCTest.Hipolabs.common;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import io.cucumber.core.exception.CucumberException;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class CommonUtil {

    protected static Map<String, Object> queryParams = new HashMap<>();
    protected static URL endpointObj;
    protected static HttpResponse<JsonNode> response;

    protected HttpResponse<JsonNode> invokeGetService() {
        try {
            HttpRequest getRequestObj = Unirest.get(endpointObj.toString())
                    .queryString(queryParams);

            return getRequestObj.asJson();

        } catch (UnirestException e) {
            throw new CucumberException(e);
        }
    }

}
