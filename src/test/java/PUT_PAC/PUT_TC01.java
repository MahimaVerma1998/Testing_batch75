package PUT_PAC;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class PUT_TC01 {
	@Test
	public void put_test() {
		JSONObject request = new JSONObject();
		request.put("name", "Mahima");
		request.put("job", "Engineer");
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log()
				.all();

	}
}
