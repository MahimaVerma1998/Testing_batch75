package GET_PAC;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get_TC05 {
	@Test
	public void TC03() {
		given().when().get("https://reqres.in/api/users/23").then().statusCode(404).assertThat().body("data.page",
				equalTo(null));

	}
}
