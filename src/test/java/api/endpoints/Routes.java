package api.endpoints;

public class Routes {
	
	public static String base_Url="https://petstore.swagger.io/v2";
	
	//User Model
	
	public static String post_url=base_Url+"/user";
	public static String get_url=base_Url+"/user/{username}";
	public static String update_url=base_Url+"/user/{username}";
	public static String delete_url=base_Url+"/user/{username}";
	
	
	//Store Model
	
	
	public static String s_post_url=base_Url+"/store/order";
	public static String s_get_url=base_Url+"/store/order/{orderId}";
	public static String s_update_url=base_Url+"/store/order/{orderId}";
	public static String s_delete_url=base_Url+"/store/order/{orderId}";

}
