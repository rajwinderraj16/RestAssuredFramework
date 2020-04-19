package RestAssuredTestCase;

import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import RestAssured_Base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC_PostRequest extends BaseClass {
	
	
	
	@BeforeClass
	public void registerCustomer()
	{
		
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		httpRequest=RestAssured.given();
		
		//Create Body
		
		JSONObject requestparams=new JSONObject();
		
		requestparams.put("FirstName", "Bill");
		requestparams.put("LastName", "Chris");
		requestparams.put("UserName", "Bill12");
		requestparams.put("Password", "12bill");
		requestparams.put("Email", "bill12@gmail.com");
			
		httpRequest.header("Content-Type","application/json");
		
		httpRequest.body(requestparams.toJSONString());
		
	    response =httpRequest.request(Method.POST,"/register");
		
		String bodyresponse=response.getBody().asString();
		System.out.println("The body response is "  +  bodyresponse);
		
	}
	
	    @Test 
		public void VerifyStatusCode()
		{
		
		
		int code=response.getStatusCode();
		logger.info("The valid status code is "  + code);
		Assert.assertEquals(201, code);
		
		}
		
		@Test
		public void VerifyStausValue()
		{
	    String actualsuccesscode=response.jsonPath().get("SuccessCode");
		logger.info("The success code is "  + actualsuccesscode);
		Assert.assertEquals(actualsuccesscode, "OPERATION_SUCCESS");
		
		}
		
		
		
		
	}


