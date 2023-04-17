package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_extractvalueofeachnodeinjson {
	@Test
	public void getstatuscode() throws InterruptedException {
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1";

	RequestSpecification httprequest=RestAssured.given();
	Thread.sleep(2000);
	Response responceobject=httprequest.request(Method.GET,"/employees");
	
	String responcebody=responceobject.getBody().asString();
	System.out.println("response body is :"+responcebody);
	
	Thread.sleep(2000);
	JsonPath jsonpath=responceobject.jsonPath();
	System.out.println(jsonpath.get("data"));
	
	Thread.sleep(2000);
	System.out.println(jsonpath.get("status"));
	System.out.println(jsonpath.get("message"));
	System.out.println(jsonpath.get("employee_age"));
	
}
}