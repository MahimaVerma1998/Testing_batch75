package GET_PAC;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get_TC04 {
	@Test
	public void TC03() {
		given().when().get("https://reqres.in/api/users/2").then().statusCode(200).assertThat()
				.body("data.id", equalTo(2)).assertThat().body("data.email", equalTo("janet.weaver@reqres.in"))
				.assertThat().body("data.first_name", equalTo("Janet")).assertThat()
				.body("data.last_name", equalTo("Weaver")).assertThat()
				.body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"));

	}
}
