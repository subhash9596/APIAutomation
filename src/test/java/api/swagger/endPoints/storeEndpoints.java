package api.swagger.endPoints;

import static io.restassured.RestAssured.given;

import api.swagger.payload.StorePayload;
import api.swagger.payload.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class storeEndpoints {

	//Place an order for pet
	public static  Response storeOrder(StorePayload payLoad) {
		Response response =given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payLoad)
				.when()
				.post(Routes.store_post_url);
		return response;

	}

	//Place an order for pet
	public static  Response placeOrder(int orderId) {
		Response response =given()
				.accept(ContentType.JSON)
				.pathParam("orderId", orderId)
				.when()
				.get(Routes.store_get_order_url);
		return response;

	}

	//pet  invotaries
	public static  Response invotaries() {
		Response response =given()
				.accept(ContentType.JSON)
				.when()
				.get(Routes.store_get_returns_url);
		return response;

	}
	//Delete 
	public static  Response delteOrder(int orderid) {
		Response response =given()
				.accept(ContentType.JSON)
				.pathParam("orderId", orderid)
				.when()
				.delete(Routes.store_delete_order_url);
		return response;

	}
}
