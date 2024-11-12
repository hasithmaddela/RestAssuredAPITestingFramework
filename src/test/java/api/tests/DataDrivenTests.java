package api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndpoints;
import api.payload.User;
import api.utilities.*;
import io.restassured.response.Response;

public class DataDrivenTests {
	
	User Payload=new User();
	
	@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
	public void testPostUser(String userid,String username,String firstname,String lastname,String email,String password,String phone)
	{
		Payload.setId(Integer.parseInt(userid));
		Payload.setUserName(username);
		Payload.setFirstName(firstname);
		Payload.setLastName(lastname);
		Payload.setEmail(email);
		Payload.setPassword(password);
		Payload.setPhone(phone);
		Response response=UserEndpoints.createUser(this.Payload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
		
	}
	
	@Test(priority=2,dataProvider="Usernamedata",dataProviderClass=DataProviders.class)
	public void deleteUsernames(String username) 
	{
		Response response=UserEndpoints.DeleteUser(username);
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 405);
		
	}

}
