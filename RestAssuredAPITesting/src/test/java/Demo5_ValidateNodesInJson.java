import org.testng.Assert;
import org.testng.annotations.Test;

import groovy.json.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo5_ValidateNodesInJson {
	
	@Test
	public void validateJsonNode() {
		// specify base URI
		RestAssured.baseURI = "https://restful-booker.herokuapp.com/";

		// request object
		RequestSpecification httpRequest = RestAssured.given();

		// response object
		Response response = httpRequest.request(Method.GET, "booking/1");

		//jsonpath is predefined class for fetching different nodes value
		JsonPath jsonpath = response.jsonPath();
		
		System.out.println(jsonpath.get("firstname"));//This info keep changing test might fail
		System.out.println(jsonpath.get("lastname"));
		System.out.println(jsonpath.get("totalprice"));
		System.out.println(jsonpath.get("depositpaid"));
		System.out.println(jsonpath.get("bookingdates"));
		
		Assert.assertEquals(jsonpath.get("firstname"), "Eric");// name is keep on changing
		



}
}
