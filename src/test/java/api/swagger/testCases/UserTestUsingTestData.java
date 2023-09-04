package api.swagger.testCases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import api.swagger.dataprovider.DataProviders;
import api.swagger.endPoints.userEndpoints;
import api.swagger.payload.UserPayload;
import io.restassured.response.Response;

public class UserTestUsingTestData extends LoggerInfo {
	// public static org.apache.logging.log4j.Logger logger;
	@Test(priority = 1, dataProvider = "CreateUser_Data", dataProviderClass = DataProviders.class)
	public void testCreateUser(String UserId, String username, String firstName, String lastName, String email,
			String Password, String phone) {

		UserPayload userpayload = new UserPayload();
		userpayload.setId(Integer.parseInt(UserId));
		userpayload.setUsername(username);
		userpayload.setFirstName(firstName);
		userpayload.setLastName(lastName);
		userpayload.setEmail(email);
		userpayload.setPassword(Password);
		userpayload.setPhone(phone);

		Response response = userEndpoints.createUser(userpayload);
		System.out.println(userpayload);
		System.out.println("Crete User Data");
		// Log Response
		int statusCode = response.getStatusCode();
		System.out.println("Status Code : " + response.getStatusCode());
		response.then().log().all();

		// Validate
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(statusCode, 200);
		asserts.assertAll();
		// obtain Logger
		// logger = LogManager.getLogger("RestAssuredAutomationFramework");
		logger.info("create User exected");
	}

	@Test(priority = 2, dataProvider = "GetUser_Data", dataProviderClass = DataProviders.class)
	public void testGetUser(String username) {

		UserPayload userpayload = new UserPayload();
		userpayload.setUsername(username);

		Response response = userEndpoints.getUser(username);
		System.out.println("Get User Data");
		// Log Response
		response.then().log().all();
		// Validate
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(response.getStatusCode(), 200);
		asserts.assertAll();
		logger.info("Get User exected");

	}

	@Test(priority = 3, dataProvider = "UpdateUser_Data", dataProviderClass = DataProviders.class)
	public void testUpdateUser(String username) {

		UserPayload userpayload = new UserPayload();
		userpayload.setUsername(username);

		Response response = userEndpoints.upadteUser(username, userpayload);
		System.out.println("Update User Data");
		// Log Response
		response.then().log().all();
		// Validate
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(response.getStatusCode(), 200);
		asserts.assertAll();
		logger.info("Update User exected");

	}

	@Test(priority = 4, dataProvider = "LoginUser_Data", dataProviderClass = DataProviders.class)
	public void testLoginUser(String username, String password) {

		UserPayload userpayload = new UserPayload();
		userpayload.setUsername(username);
		userpayload.setUsername(password);

		Response response = userEndpoints.loginUser(username, password);
		System.out.println("Login User");
		// Log Response
		response.then().log().all();
		// Validate
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(response.getStatusCode(), 200);
		asserts.assertAll();
		logger.info("Login User exected");
	}

	@Test(priority = 5, dataProvider = "DeleteUser_Data", dataProviderClass = DataProviders.class)
	public void testDeleteUser(String username) {

		UserPayload userpayload = new UserPayload();
		userpayload.setUsername(username);

		Response response = userEndpoints.deleteUser(username);
		System.out.println("Delete User Data");
		// Log Response
		response.then().log().all();
		// Validate
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(response.getStatusCode(), 200);
		asserts.assertAll();
		logger.info("Delete User exected");

	}

	@Test(priority = 6)
	public void logoutUser() {

		Response response = userEndpoints.logoutUser();
		System.out.println("Logout User");
		// Log Response
		response.then().log().all();
		// Validate
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(response.getStatusCode(), 200);
		asserts.assertAll();
		logger.info("Logout User exected");
	}
}
