package Patch_PAC;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class Patch_TC01 {
	@Test
	public void patch_test() {
		JSONObject request = new JSONObject();
		request.put("name", "Mahima");
		request.put("job", "Engineer");
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().patch("https://reqres.in/api/users/2").then().statusCode(200).log()
				.all();

	}
}
