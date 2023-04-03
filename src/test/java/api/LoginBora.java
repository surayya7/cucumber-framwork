package api;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequestBody;
import pojo.LoginResponseBody;
import utilities.StatusCodes;

public class LoginBora {
	public static void main(String[]arg) {
		
		String endpoint ="api/auth";
		RestAssured.baseURI="https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();
		request.header("content-type","application/json");
		
//		request body as map
//		Map<String, String>body = new HashMap<>();
//		
//		body.put("email","surayya117@gmail.com");
//		body.put("password", "emsb92921S");
		
		//jesonobject
		JsonObject body = new JsonObject();
		body.addProperty("email", "surayya117@gmail.com");
		body.addProperty("password", "emsb92921S");
		
		
		
		
		
		// request body as a pojo
	//	 LoginRequestBody body = new LoginRequestBody( "surayya117@gmail.com", "emsb92921S");
	
		 
		request.body(body);
	Response response =	request.post(endpoint);
	int actualStatusCode = response.statusCode();
	String responseBody = response.getBody().asPrettyString();
	
	System.out.println(responseBody);
	 
	if(actualStatusCode ==StatusCodes.OK.value()) {
		System.out.println("Test Passed");
	}else{
		System.out.println("Test Failed");
		
	}
	//using JsonPath
//	JsonPath jp = response.jsonPath();
//	String token = jp.get("token");
//	System.out.println(token);
	
	//using pojo
	LoginResponseBody loginResponsBody = response.as(LoginResponseBody.class);
	System.out.println(loginResponsBody.getToken());

	

	}

}
