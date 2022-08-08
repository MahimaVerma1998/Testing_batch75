package GET_PAC;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class Get_TC03 {
	@Test
	public void TC03() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.assertThat()
				.body("data[1].id", equalTo(8))
				.body("data[1].email", equalTo("lindsay.ferguson@reqres.in"))
				.body("data[1].first_name", equalTo("Lindsay"))
				.body("data[1].last_name", equalTo("Ferguson"));
	}
}