package api.swagger.endPoints;
import static io.restassured.RestAssured.given;

import api.swagger.payload.UserPayload;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class userEndpoints {
  //Create User Name
	public static  Response createUser(UserPayload payload) {
		Response response =given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.body(payload)

				.when()
				.post(Routes.post_url);
		return response;

	}
	
	//Get User by User Name 
	public static  Response getUser(String userName) {
		Response response =given()
				.accept(ContentType.JSON)
				.pathParam("username", userName)

				.when()
				.get(Routes.get_url);

		return response;

	}
	//Update User Data
	public static  Response upadteUser(String userName,UserPayload payload) {
		Response response =given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", userName)
				.body(payload)

				.when()
				.put(Routes.put_url);

		return response;

	}
	public static  Response deleteUser(String userName) {
		Response response =given()
				.accept(ContentType.JSON)
				.contentType(ContentType.JSON)
				.pathParam("username", userName)

				.when()
				.delete(Routes.delete_url);

		return response;

	}
	//Login User Info Into the System
	public static  Response loginUser(String userName,String Passwrod) {
		Response response =given()
				.accept(ContentType.JSON)
				.queryParam(userName, Passwrod)
			

				.when()
				.get(Routes.login_url);

		return response;

	}

	//Logout current logged in user secession 
		public static  Response logoutUser() {
			Response response =given()
					.accept(ContentType.JSON)
					
					.when()
					.get(Routes.login_url);

			return response;

		}
		
	


}