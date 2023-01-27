import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Demo3_PrintAllHeaders {
	
		// Get all headres value
		@Test
		void getbookingDetails() {
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
			
			Headers allheaders = response.headers(); // capture all the headers value from response
			
			//create variable header and store all headers value into it
			for(Header header:allheaders)
			{
				System.out.println(header.getName() +"  " + header.getValue());
			}
	}
	}
