package My_API;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class Get_TC0001 {
	@Test
	public void get_data() {
		given().when().get("http://localhost:3000/data").then().statusCode(200).assertThat().body("id[1]", equalTo(2))
				.body("Employee_Name[1]", equalTo("Manish")).body("Employee_Salary[1]", equalTo(200000))
				.body("Employee_Age[1]", equalTo(24)).body("Profile_Image[1]", equalTo(""));

	}
}