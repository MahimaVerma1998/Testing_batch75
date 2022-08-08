package My_API;

//import static org.hamcrest.Matchers.equalTo;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
//import static org.hamcrest.Matchers.*;

public class Post_TC0001 {
	@Test
	public void post_test() {
		JSONObject request = new JSONObject();
		request.put("Employee_Name", "Mahi");
		request.put("Employee_Salary", "30875");
		request.put("Employee_Age", "24");
		request.put("Profile_Image", "");
		given().header("Content-Type", "application/json").contentType(ContentType.JSON).accept(ContentType.JSON)
				.body(request.toJSONString()).when().post("http://localhost:3000/data").then().statusCode(201).log()
				.all();
	}
}
