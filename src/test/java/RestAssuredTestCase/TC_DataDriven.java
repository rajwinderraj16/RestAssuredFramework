package RestAssuredTestCase;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RestAssured_Base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_DataDriven extends BaseClass{
	
	@Test (dataProvider="MyEmpData")
	public void DDT(  String name, String Lastnm, String User, String pass , String email)
	{
	
	RestAssured.baseURI="http://restapi.demoqa.com/customer";
	
	httpRequest=RestAssured.given();
	
	//Create Body
	
	JSONObject requestparams=new JSONObject();
	
	requestparams.put("FirstName", name);
	requestparams.put("LastName", Lastnm);
	requestparams.put("UserName", User);
	requestparams.put("Password", pass);
	requestparams.put("Email", email);
		
	httpRequest.header("Content-Type","application/json");
	
	httpRequest.body(requestparams.toJSONString());
	
	response =httpRequest.request(Method.POST,"/register");
	
	String bodyresponse=response.getBody().asString();
	System.out.println("The body response is "  +  bodyresponse);
	}
	
	@DataProvider(name="MyEmpData")
	String [][] getEmployeeData()
	{
		String emp_data[][]= {{"Chris", "Parish", "Parry", "parry@gmail.com" , "3434"},{"Parish", "Chris", "Cchris", "chris12@gmail.com" , "3435"}};
		return (emp_data);
	}
}

    

