package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestA {
	@Test
	public void getstatuscode() {
		RestAssured.baseURI = "https://reqres.in/api/users/2";

	RequestSpecification httprequest=RestAssured.given();
	
	Response responceobject=httprequest.request(Method.GET);
	String responcebody=responceobject.getBody().asString();
	System.out.println("response body is :"+responcebody);
	
	int statuscode=responceobject.getStatusCode();
	System.out.println("responcecode :"+statuscode);
		
	String statusline=responceobject.getStatusLine();
	System.out.println("status line :"+statusline);
	//success code validation
	String data=responceobject.jsonPath().getString("data");
	System.out.println("Data :"+data);
	//validatinh header
	String ReportTo=responceobject.header("Report-To");
	System.out.println("support :"+ReportTo);
	}


}
