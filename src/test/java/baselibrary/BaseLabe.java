package baselibrary;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class BaseLabe {
	public static RequestSpecification httprequest;
	public static Response responce;
	public static String empId="51838";
//	public static  Logger logger;
//	@BeforeClass
//	public void setup() {
//		 logger=Logger.getLogger("employeesRestApi");
//		PropertyConfigurator.configure("Log4j.properties");
//		logger.setLevel(Level.DEBUG);
//	}
	public void demo() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/employees";
	    httprequest=RestAssured.given();
		
	    responce=httprequest.request(Method.GET);
		String responcebody=responce.getBody().asString();
		System.out.println("response body is :"+responcebody);;
	}
	public static void main(String[] args) {
		BaseLabe ob= new BaseLabe();
		ob.demo();
	}

}
