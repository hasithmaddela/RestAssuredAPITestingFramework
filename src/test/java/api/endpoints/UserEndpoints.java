package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//This can be used to perform crud operations -Create,Retrieve,Update and Delete

@SuppressWarnings("unused")
public class UserEndpoints {
	
	public static Response createUser(User Payload)
	{
	Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(Payload)
		
		.when()
		.post(Routes.CreateUserUrl);
	
	return response;
		
	}

	public static Response getUserDetails(String userName){
		
		Response response=given()
		    .pathParam("username",userName)
		
		.when()
		   .get(Routes.GetUserUrl);
		
		return response;
		
	}

	public static Response UpdateUser(User Payload,String userName){
		
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", userName)
		.body(Payload)
		
		.when()
		.post(Routes.UpdateUserUrl);
		return response;
		
	}
public static Response DeleteUser(String userName){
		
		Response response=given()
		.pathParam("username", userName)
		
		.when()
		.post(Routes.DeleteUserUrl);
		return response;
	}

}

