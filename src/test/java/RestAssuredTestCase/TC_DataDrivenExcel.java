package RestAssuredTestCase;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RestAssuredUtility.XLUtils;
import RestAssured_Base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC_DataDrivenExcel extends BaseClass {
	
	

	 
	@Test (dataProvider="empData")
	public void postemp(String name, String Lastnm, String User,String pass, String email)throws InterruptedException
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
	
	Response response =httpRequest.request(Method.POST,"/register");
	
	String bodyresponse=response.getBody().asString();
	System.out.println("The body response is "  +  bodyresponse);
	}

	
		
	
	@DataProvider(name="empData")
	String [][] getEmpData() throws IOException 
	{
	
		
		String path=System.getProperty("user.dir")+"/src/test/java/ExcelData/MyEmp.xlsx";
		
		int rownum =XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String empdata1 [][]=new String [rownum][colcount];
		
		for(int i=1; i<= rownum; i++)
		{
			for(int j=0;j < colcount;j++)
			{
			
			  empdata1 [i - 1][j]=XLUtils.getCellData(path, "Sheet1", i, j);//1 0
			  
			  
			}
		}
		return empdata1;
		}
}
		
			
		
		
		
		
		
		
		  	
		
		

		

	
       

