import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo1_GET_Request {

	@Test
	void getbookingDetails() {
		// specify base URI
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";

		// request object
		RequestSpecification httpRequest = RestAssured.given();

		// response object
		Response response = httpRequest.request(Method.GET, "booking");

		// print response in console window
		// response in json format-will convert into string
		String responseBody = response.getBody().asString();
		System.out.println("Response body is" + responseBody);

		// Status Code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is " + statusCode);
		Assert.assertEquals(statusCode, 200);

		// Status line verification(string format)
		String statusLine = response.getStatusLine();
		System.out.println("Status line is " + statusLine);
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

	}

}
