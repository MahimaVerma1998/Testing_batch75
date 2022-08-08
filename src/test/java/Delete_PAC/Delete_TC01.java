package Delete_PAC;

import org.testng.annotations.Test;

public class Delete_TC01 {
	@Test
	public void delete_test() {
		given()
		.when()
		.delete("https://reqres.in/api/users/2").then().statusCode(204).log().all();

	}
}