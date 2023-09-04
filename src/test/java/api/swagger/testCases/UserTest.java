package api.swagger.testCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.github.javafaker.Faker;

import api.swagger.dataprovider.DataProviders;
import api.swagger.endPoints.userEndpoints;
import api.swagger.payload.UserPayload;
import io.restassured.response.Response;

public class UserTest {
	Faker faker ;
	UserPayload userpayload;
	
   @BeforeClass
	public void generateTestData() {

		faker=new Faker();
		userpayload=new UserPayload();
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5, 10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
	}
    @Test(priority = 1)
    public void testCreateUser () {
    	Response response =userEndpoints.createUser(userpayload);
    	System.out.println("Crete User Data");
    	//Log Response
    	response.then().log().all();
    	//Validate
    	SoftAssert asserts = new SoftAssert();
    	asserts.assertEquals(response.getStatusCode(), 200);
    	
    }
    @Test(priority = 2)
    public void testGetUser() {
    	
    	Response response =userEndpoints.getUser(this.userpayload.getUsername());
    	System.out.println("Get User Data");
    	//Log Response
    	response.then().log().all();
    	//Validate
    	SoftAssert asserts = new SoftAssert();
    	asserts.assertEquals(response.getStatusCode(), 200);
    	
    }
    
    @Test(priority = 3)
    public void testUpdateUser() {
    	userpayload.setFirstName(faker.name().firstName());
    	Response response =userEndpoints.upadteUser(this.userpayload.getUsername(), userpayload);
    	System.out.println("Update User Data");
    	//Log Response
    	response.then().log().all();
    	//Validate
    	SoftAssert asserts = new SoftAssert();
    	asserts.assertEquals(response.getStatusCode(), 200);
    	
    }
    @Test(priority = 4)
    public void testLoginUser() {
 
    	Response response =userEndpoints.loginUser(this.userpayload.getUsername(),this.userpayload.getPassword());
    	System.out.println("Login User");
    	//Log Response
    	response.then().log().all();
    	//Validate
    	SoftAssert asserts = new SoftAssert();
    	asserts.assertEquals(response.getStatusCode(), 200);
    	
    }
    @Test(priority = 5)
    public void testDeleteUser() {

    	Response response =userEndpoints.deleteUser(this.userpayload.getUsername());
    	System.out.println("Delete User Data");
    	//Log Response
    	response.then().log().all();
    	//Validate
    	SoftAssert asserts = new SoftAssert();
    	asserts.assertEquals(response.getStatusCode(), 200);
    	
    }
    @Test(priority = 6)
    public void logoutUser() {
    	
    	Response response =userEndpoints.logoutUser();
    	System.out.println("Logout User");
    	//Log Response
    	response.then().log().all();
    	//Validate
    	SoftAssert asserts = new SoftAssert();
    	asserts.assertEquals(response.getStatusCode(), 200);
    	
    }
   
    
    
    
}
