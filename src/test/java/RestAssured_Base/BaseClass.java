package RestAssured_Base;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	
	public static RequestSpecification httpRequest;
	public static Response response;
    public Logger logger;
	
	@BeforeClass
	public void setup(){
		
		logger=Logger.getLogger("EmpRestAPI");
		PropertyConfigurator.configure("Log4j.properties"); 
		logger.setLevel(Level.DEBUG);
		
	}
	
	@AfterClass
	public void teardown()
	{
		logger.info("The test is finished");
	}

}
