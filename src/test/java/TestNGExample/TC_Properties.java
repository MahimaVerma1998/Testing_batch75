package TestNGExample;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TC_Properties {
	@Test

	public void f() throws IOException {
		Properties prob = new Properties();
		InputStream input = new FileInputStream(
				"C:\\JavaProgram\\workspace\\Testing_batch75\\src\\test\\java\\TestNGExample\\input.properties");
		prob.load(input);
		given().when().get(prob.getProperty("url")).then().statusCode(200).assertThat().body("data[1].id", equalTo(8))
				.assertThat().body("data[1].email", equalTo("lindsay.ferguson@reqres.in")).assertThat()
				.body("data[1].first_name", equalTo("Lindsay")).assertThat()
				.body("data[1].last_name", equalTo("Ferguson")).assertThat()
				.body("data[1].avatar", equalTo("https://reqres.in/img/faces/8-image.jpg"));
	}
}
