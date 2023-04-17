package test;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import page1.datadriven;

public class Datadriven extends datadriven{
	static String path="C:\\Users\\winni\\eclipse-workspace\\ApiRestAssured\\excelutility\\emplyeedata.xlsx";
	@Test(dataProvider="create")

	public void getstatuscode(String Name,String Age,String Salary,String Job) {
    RestAssured.baseURI = "https://reqres.in/api/users";

	RequestSpecification httprequest=RestAssured.given();
	
	//request payload sending along with request
	JSONObject request = new JSONObject();
	request.put("name", Name);
	request.put("job", Age);
	request.put("age",  Salary);
	request.put("salary", Job);
	httprequest.header("content-Type","application/json");
	httprequest.body(request.toJSONString());//attach above data to the request
	//responce object
	Response responceobject=httprequest.request(Method.POST);
	//print responce in console window
	String responcebody=responceobject.getBody().asString();
	System.out.println("response body is :"+responcebody);
	//status code validation
	int statuscode=responceobject.getStatusCode();
	System.out.println("responcecode :"+statuscode);
    Assert.assertEquals(responcebody.contains(Name), true ,"Name not found");
    Assert.assertEquals(responcebody.contains(Age), true);
    Assert.assertEquals(responcebody.contains(Salary), true);
    Assert.assertEquals(responcebody.contains(Job), true);
	
	}
@DataProvider(name="create")
	
	public static Object[][] getData() throws IOException {
		Object data [][] = excelDataReader(path,"Sheet1");

		return data;
	}
}
