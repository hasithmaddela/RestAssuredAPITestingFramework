package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//This can be used to perform crud operations -Create,Retrieve,Update and Delete

@SuppressWarnings("unused")
public class UserEndpoints2 {
	
	 static ResourceBundle getURL() {
		ResourceBundle rb=ResourceBundle.getBundle("Routes");// used to read and load the properties file
		return rb;
	}
	
	public static Response createUser(User Payload)
	{
		String Post_url=getURL().getString("Post_Url");
		
	Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.body(Payload)
		
		.when()
		.post(Post_url);
	
	return response;
		
	}

	public static Response getUserDetails(String userName){
		
		String Get_url=getURL().getString("Get_Url");
		
		Response response=given()
		    .pathParam("username",userName)
		
		.when()
		   .get(Get_url);
		
		return response;
		
	}

	public static Response UpdateUser(User Payload,String userName){
		
		String Update_url=getURL().getString("Update_Url");
		
		Response response=given()
		.accept(ContentType.JSON)
		.contentType(ContentType.JSON)
		.pathParam("username", userName)
		.body(Payload)
		
		.when()
		.post(Update_url);
		return response;
		
	}
public static Response DeleteUser(String userName){
		
	String Delete_Url=getURL().getString("Delete_Url");
	
		Response response=given()
		.pathParam("username", userName)
		
		.when()
		.post(Delete_Url);
		return response;
	}

}

