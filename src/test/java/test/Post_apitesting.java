package test;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;



import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Post_apitesting {
	@Test
	public void getstatuscode() {
    RestAssured.baseURI = "https://reqres.in/api/users";

	RequestSpecification httprequest=RestAssured.given();
	
	//request payload sending along with request
	JSONObject request = new JSONObject();
	request.put("name", "chaya");
	request.put("job", "BA");
	
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
	//statusline validation	
	String statusline=responceobject.getStatusLine();
	System.out.println("status line :"+statusline);
	//success code validation
	String successcode=responceobject.jsonPath().getString("job");
	System.out.println("successcode :"+successcode);
	JsonPath jsonpath=responceobject.jsonPath();
	System.out.println(jsonpath.get("job"));
	}
}
