package GET_PAC;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get_TC07 {
	@Test
	public void TC07() {
		given().when().get("https://reqres.in/api/unknown").then().statusCode(200).assertThat()
				.body("data[0].id", equalTo(1)).body("data[0].name", equalTo("cerulean"))
				.body("data.data[0].year", equalTo(2000)).body("data[0].color", equalTo("#98B2D1"))
				.body("data[0].pantone_value", equalTo("15-4020"));

	}
}
