package datadriventesting;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.Method;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DataDrivenTest {

	// POST request(single set of data)- create data into database
	@Test(dataProvider = "empdataprovider")
	void addNewEmployees(String ename,String esal,String eage) {
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

		RequestSpecification httpRequest = RestAssured.given();

		// create data which we can send along with post request
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", ename);
		requestParams.put("salary", esal);
		requestParams.put("age", eage);

		// Add header
		httpRequest.header("Content-Type", "application/json");

		// add Json to body request
		httpRequest.body(requestParams.toJSONString());

		// Post Request
		Response response = httpRequest.request(Method.POST, "/create");
		String responsebody = response.getBody().asString();
		
		System.out.println(responsebody);

		Assert.assertEquals(responsebody.contains(ename), true);
		Assert.assertEquals(responsebody.contains(esal), true);
		Assert.assertEquals(responsebody.contains(eage), true);

	//	int statuscode = response.getStatusCode();
	//	Assert.assertEquals(statuscode, 200);

	}
	
	@DataProvider(name="empdataprovider")
	String[][] getEmpData()
	{
		String path =System.getProperty("user.dir")+"/src/test/java/datadriventesting/empdata.xlsx";
		Xls_Reader xls_reader = new Xls_Reader(path);
		int rowCount = xls_reader.getRowCount("Sheet1");
		int columnCount = xls_reader.getColumnCount("Sheet1");
		String empdata[][]= new String[rowCount-1][columnCount];
		for(int i=1; i<rowCount; i++)
		{
			for(int j=0; j<columnCount; j++)
			{
				empdata[i-1][j]=  xls_reader.getCellData("Sheet1",j,i+1);
			}
		}
		return(empdata);
	}
	

}
