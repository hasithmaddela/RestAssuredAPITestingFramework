package api.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndpoints;
import api.payload.User;
import io.restassured.response.Response;

public class Usertests {

	Faker faker;
	User payload;
	
	@BeforeClass
	public User setupData() {
		faker=new Faker();
		payload=new User();
		
		payload.setId(faker.idNumber().hashCode());
		payload.setUserName(faker.name().username());
		payload.setFirstName(faker.name().firstName());
		payload.setLastName(faker.name().lastName());
		payload.setEmail(faker.internet().emailAddress());
		payload.setPassword(faker.internet().password(5,10));
		payload.setPhone(faker.phoneNumber().cellPhone());
		payload.setUserStatus(faker.idNumber().hashCode());
		
		return payload;
	}
	
	@Test(priority=1)
	public void testPostUser() {
		
		Response response=UserEndpoints.createUser(payload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
				
	}
	
	@Test(priority=2)
	public void testGetUser() throws InterruptedException {
		
		Thread.sleep(5);	
		Response response=UserEndpoints.getUserDetails(this.payload.getUserName());
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
				
	}
	@Test(priority=3)
	public void testPutUser() {
		
		Response response=UserEndpoints.UpdateUser(this.payload,this.payload.getUserName());
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
				
	}
	
	@Test(priority=4)
	public void testDeleteUser() {
		
		Response response=UserEndpoints.DeleteUser(this.payload.getUserName());
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
				
	}
	
	
	
}
