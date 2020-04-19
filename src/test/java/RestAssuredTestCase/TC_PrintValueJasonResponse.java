package RestAssuredTestCase;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import RestAssured_Base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_PrintValueJasonResponse extends BaseClass {
	
	
	@BeforeClass
	public void printValueJasonResponse()
	{
	   RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	
	   httpRequest=RestAssured.given();
	
       response=httpRequest.request(Method.GET,"/utilities/weather/city/Auckland");
	
	   JsonPath json=response.jsonPath();
	   logger.info(json.get("City"));
	   logger.info(json.get("Temperature"));
	   logger.info(json.get("Humidity"));
	   logger.info(json.get("WeatherDescription"));
	   logger.info(json.get("WindSpeed"));
	   logger.info(json.get("WindDirectionDegree"));
	
	
		
	   logger.info("Verifying the name of the city");
	   Assert.assertEquals(json.get("City"),"Wellington"); 
	}
}
	
	
	

