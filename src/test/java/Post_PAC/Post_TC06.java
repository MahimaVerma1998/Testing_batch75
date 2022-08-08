package Post_PAC;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class Post_TC06 {
	@Test
	public void post_test6() {
		JSONObject request = new JSONObject();
		request.put("email", "eve.holt@reqres.in");
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("https://reqres.in/api/login").then().statusCode(400).log()
				.all();
	}
}
