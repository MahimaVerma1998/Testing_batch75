package GET_PAC;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Get_TC02 {
	@Test
	public void get_TC02() {
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification httprequest = RestAssured.given();
		Response res = httprequest.request(Method.GET);
		System.out.println("Status code:" + res.getStatusCode());
		System.out.println("Response Body:" + res);
	}
}
