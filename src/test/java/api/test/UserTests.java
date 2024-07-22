package api.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.pages.BaseClass;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests extends BaseClass {
	
	
	Faker faker;
	User userpayload;
	
	public Logger logger;
	
	@BeforeClass
	public void setUpData()
	{
		faker=new Faker();
		userpayload=new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setUsername(faker.name().username());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setPassword(faker.internet().password(5,10));
	//	userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		logger=LogManager.getLogger(this.getClass());
	}
	
	@Test(priority=1)
	public void testPostUser()
	{
		test = reports.createTest("TC_001:Verify the User Post Request");
		logger.info("Logging information for 1st Test Case");
		Response response=UserEndPoints.createUser(userpayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority=2)
	public void testGetUser()
	{
		test = reports.createTest("TC_002:Verify the User Get Request");
		Response response=UserEndPoints.readUser(this.userpayload.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
