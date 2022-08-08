package My_API;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

//import static org.hamcrest.Matchers.*;
public class Delete_TC0001 {
	@Test
	public void delete_data() {
		given().when().delete("http://localhost:3000/data/6").then().statusCode(200);

	}
}