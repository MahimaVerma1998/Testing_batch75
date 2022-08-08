package Post_PAC;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class Post_TC03 {
	@Test
	public void post_test3() {
		JSONObject request = new JSONObject();
		request.put("email", "eve.holt@reqres.in");
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("https://reqres.in/api/register").then().statusCode(400);
	}
}
