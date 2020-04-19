package RestAssuredTestCase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import RestAssured_Base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import junit.framework.Assert;

public class TC_PrintVerifyAllHeaders extends BaseClass{

	
	
	@BeforeClass
	public void printHeadrs()
	{
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		httpRequest= RestAssured.given();
		
		response=httpRequest.request(Method.GET,"/utilities/weather/city/Auckland");
	}
		
		
	@Test
	public void CapturingResponsebody()
	{
		
		String responsebody=response.getBody().asString();
		logger.info("The responsebody is "  + responsebody);
		
		//To Print all the header
		Headers allheaders=response.headers();
		
		for(Header header: allheaders)
		{
			
			logger.info(header.getName()+"           "+header.getValue());
			
			logger.info("Verifying the Date of the test ");
			
			String date=response.header("Date");
			logger.info("The date of the test is   "    +  date);
			Assert.assertEquals(date.contains("Sat, 18 Apr 2020"), true);
		}
		
	}
}
