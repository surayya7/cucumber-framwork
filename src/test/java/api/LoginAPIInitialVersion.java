package api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.LoginRequestBody;
import pojo.LoginResponseBody;
import utilities.StatusCodes;

public class LoginAPIInitialVersion {

	public static void main(String[] args) {
		String endpoint = "/api/auth";
		RestAssured.baseURI = "https://boratech-practice-app.onrender.com";
		RequestSpecification request = RestAssured.given();

		request.header("Content-Type", "application/json");

		// Request body as Map
//		Map<String, String> body = new HashMap<>();
//		body.put("email", "muradil.erkin@boratechschool.com");
//		body.put("password", "Boratech");

		// Request body as JsonObject
//		JsonObject body = new JsonObject();
//		body.addProperty("email", "muradil.erkin@boratechschool.com");
//		body.addProperty("password", "Boratech");

		// Request body as a POJO
		LoginRequestBody body = new LoginRequestBody("surayya117@gmail.com", "emsb92921S");

		request.body(body);

		Response response = request.post(endpoint);
		int actualStatusCode = response.statusCode();

		if (actualStatusCode == StatusCodes.OK.value()) {
			System.out.println("Test Passed");
		} else {
			System.out.println("Test Failed");
		}

		// Using JsonPath
//		JsonPath jp = response.jsonPath();
//		String token = jp.get("token");
//		System.out.println(token);

		// Using Pojo
		LoginResponseBody loginResponseBody = response.as(LoginResponseBody.class);
		System.out.println(loginResponseBody.getToken());

	}


	

}
