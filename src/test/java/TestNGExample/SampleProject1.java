package TestNGExample;

import org.testng.annotations.Test;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SampleProject1 {

  	@Test
  	  public void user() {
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
