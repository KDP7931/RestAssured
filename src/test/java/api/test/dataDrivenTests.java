package api.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.pages.BaseClass;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.Utilites;
import io.restassured.response.Response;

public class dataDrivenTests  extends BaseClass
{
    @Test(dataProvider="getAllData", dataProviderClass=Utilites.class)
    public void testUser(String UserID, String UserName, String FirstName, String LastName, String Email, String Password, String Phone)
    {
    	test = reports.createTest("TC_001:Verify the User Post Request via DataDriven");
    	User userpayload=new User();
    	
    	 int userIdInt = (int) Double.parseDouble(UserID);
    	userpayload.setId(userIdInt);
		userpayload.setEmail(Email);
		userpayload.setFirstName(FirstName);
		userpayload.setUsername(UserName);
		userpayload.setLastName(LastName);
		userpayload.setPassword(Password);
		 int userPhInt = (int) Double.parseDouble(Phone);
         userpayload.setPhone(userPhInt);
		
		
		Response response=UserEndPoints.createUser(userpayload);
		Assert.assertEquals(response.getStatusCode(), 200);
    }
}
