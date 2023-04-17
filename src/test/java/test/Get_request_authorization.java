package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_request_authorization {
	@Test
	public void getstatuscode() {
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employees";
		//basic authentication
		PreemptiveBasicAuthScheme AuthScheme=new PreemptiveBasicAuthScheme();
		AuthScheme.setUserName("abc");
		AuthScheme.setPassword("123");
		RestAssured.authentication=AuthScheme;
	RequestSpecification httprequest=RestAssured.given();
	
	Response responceobject=httprequest.request(Method.GET);
	String responcebody=responceobject.getBody().asString();
	System.out.println("response body is :"+responcebody);
	
	JsonPath jsonpath=responceobject.jsonPath();
	System.out.println(jsonpath.get("data"));
	
	
}
}
