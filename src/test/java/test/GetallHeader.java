package test;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GetallHeader {
	@Test
	public void getstatuscode() {
		RestAssured.baseURI = "https://reqres.in/api/users/2";

	RequestSpecification httprequest=RestAssured.given();
	
	Response responceobject=httprequest.request(Method.GET);
	String responcebody=responceobject.getBody().asString();
	System.out.println("response body is :"+responcebody);
	
	
	//all header
	Headers allheaders=responceobject.headers();
	for(Header header:allheaders) {
		System.out.println("Headers :"+header.getName()+"  "+"Value :"+header.getValue());
	
	}
	
	
	}
}
