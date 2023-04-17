package test;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Validatingjson_responce {
	@Test
	public void getstatuscode() {
		RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employees";

	RequestSpecification httprequest=RestAssured.given();
	
	Response responceobject=httprequest.request(Method.GET);
	String responcebody=responceobject.getBody().asString();
	System.out.println("response body is :"+responcebody);
	Assert.assertEquals(responcebody.contains("Airi Satou"), true);
	
	}

}
