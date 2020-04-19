package RestAssuredTestCase;



import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import RestAssured_Base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class TC_VerifyJasonBodyResponse extends BaseClass{

	
	
	@BeforeClass
	public void VerifyJasonResponse()
	{
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		httpRequest=RestAssured.given();
		
	    response=httpRequest.request(Method.GET,"/utilities/weather/city/Auckland");
	}
	
	@Test
	public void ResponseBody()
	{
		String Responsebody=response.getBody().asString();
		logger.info("The response body is  "  +  Responsebody);
		logger.info("Verifying the response body");
		Assert.assertEquals(Responsebody.contains("clear sky"), true);
	
	}
}
