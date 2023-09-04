package api.swagger.endPoints;

public class Routes {

	public static String base_URL = "https://petstore.swagger.io/v2";
	
	//User Modules url's : Operations about Users
	public static String post_url = base_URL+"/user";
	public static String get_url = base_URL+"/user/{username}";
	public static String put_url = base_URL+"/user/{username}";
	public static String delete_url = base_URL+"/user/{username}";
	public static String login_url = base_URL+"/user/login";
	public static String logout_url = base_URL+"/user/logout";
	
	//Store Modules url's :Access to Petstore orders
	public static String store_post_url = base_URL+"/store/order";//Place an order for pet
	public static String store_get_order_url = base_URL+"/store/order/{orderId}";//Find Purches order by Id
	public static String store_get_returns_url = base_URL+"/store/inventory";//Returns a map of status codes to quantities
	public static String store_delete_order_url = base_URL+"/store/order/{orderId}";
	
	//Pet Moduels - Everything about your Pets
	
	
}
