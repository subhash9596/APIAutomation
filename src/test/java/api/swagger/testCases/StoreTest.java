package api.swagger.testCases;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.github.javafaker.Faker;

import api.swagger.endPoints.storeEndpoints;
import api.swagger.payload.StorePayload;
import io.restassured.response.Response;

public class StoreTest {

	Faker faker ;
	StorePayload storePayload;

	@BeforeClass
	public void generateTestData() {
		faker=new Faker();
		storePayload=new StorePayload();
		storePayload.setId(faker.number().numberBetween(1, 9));
		storePayload.setPetId(faker.number().hashCode());
		storePayload.setQuantity(faker.number().hashCode());
		storePayload.setShipDate("2023-08-21T11:21:16.806Z");
		storePayload.setStatus("completed");
		storePayload.setComplete(true);

	}
	//order placed for purchasing the pet
	@Test(priority = 1)
	public void testOrderPlaced() {

		Response response =storeEndpoints.storeOrder(storePayload);
		System.out.println("order placed for purchasing the pet");
		//Log Response
		response.then().log().all();
		//Validate
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(response.getStatusCode(), 200);

	}
	//purches order by id 
	@Test(priority = 2)
	public void testgetOrder() {

		Response response =storeEndpoints.placeOrder(this.storePayload.getId());
		System.out.println("Purches order by Id");
		//Log Response
		response.then().log().all();
		//Validate
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(response.getStatusCode(), 200);

	}
	//pet Invotiries
	@Test(priority = 3)
	public void testInvotries() {

		Response response =storeEndpoints.invotaries();
		System.out.println("Pet Invotries");
		//Log Response
		response.then().log().all();
		//Validate
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(response.getStatusCode(), 200);

	}
	//Delete 
	@Test(priority = 4)
	public void testDelete() {
		Response response =storeEndpoints.delteOrder(this.storePayload.getId());
		System.out.println("Delete");
		//Log Response
		response.then().log().all();
		//Validate
		SoftAssert asserts = new SoftAssert();
		asserts.assertEquals(response.getStatusCode(), 200);

	}

}
