package GET_PAC;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_TC01 {
	@Test

	public void Get_API() {
		Response res = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.print(res.getStatusCode());
	}
}
