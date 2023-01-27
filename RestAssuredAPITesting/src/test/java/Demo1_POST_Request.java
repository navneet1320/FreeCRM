import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1_POST_Request {

	@Test
	void createToken() {
		// specify base URI
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";

		// request object
		RequestSpecification httpRequest = RestAssured.given();
		
		//Request sending with post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("username", "admin");
		requestParams.put("password", "password123");
		
		httpRequest.header("Content-Type", "application/json");
		httpRequest.body(requestParams.toJSONString());// attach above data to the request

		// response object
		Response response = httpRequest.request(Method.POST, "/auth");

		// print response in console window
		// response in json format-will convert into string
		String responseBody = response.getBody().asString();
		System.out.println("Response body is" + responseBody);

		// Status Code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is " + statusCode);
		Assert.assertEquals(statusCode, 200);

		// Status line verification(string format)
		String successLine = response.getStatusLine();
		System.out.println("Status line is " + successLine);
		Assert.assertEquals(successLine, "HTTP/1.1 200 OK");
}
}
