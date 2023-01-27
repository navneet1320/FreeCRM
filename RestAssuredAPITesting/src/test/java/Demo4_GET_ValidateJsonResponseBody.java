import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo4_GET_ValidateJsonResponseBody {

	// Validate json response body
	@Test
	public void validateJsonBody() {
		// specify base URI
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";

		// request object
		RequestSpecification httpRequest = RestAssured.given();

		// response object
		Response response = httpRequest.request(Method.GET, "booking/1");

		// print response in console window
		// response in json format-will convert into string
		String responseBody = response.getBody().asString();
		System.out.println("Response body is" + responseBody);

		Assert.assertEquals(responseBody.contains("Susan"), true);// it will change name after sometime go test got fail so put value whatever u get in console
		Assert.assertEquals(responseBody.contains("Wilson"), true);// it will change name after sometime go test got fail so put value whatever u get in console

	}
}
