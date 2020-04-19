package RestAssuredTestCase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import RestAssured_Base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC_GetRequest extends BaseClass {
	
	
	@BeforeClass
	public void getCityWeather()
	{
		
		//BaseURI
	    RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	
	    //Request Object
	    httpRequest= RestAssured.given();
	
	    //Response Object
	    response=httpRequest.request(Method.GET, "/Auckland");
	}
	
	 @Test
	 public void VerfiyResposeBody()
	 {
	    logger.info("verify response body");
	    
	    String responsebody=response.getBody().asString();
	    logger.info("Response Body"   +    responsebody);
		Assert.assertTrue(responsebody!=null);
	    
	 }
	 
	 @Test
	 public void VerifyStatuCode()
	 {
	    logger.info("Verifying status code");
	    int code=response.getStatusCode();
	    logger.info("The status code is "   + code);
	    Assert.assertEquals(200, code);
	   
	}

}
