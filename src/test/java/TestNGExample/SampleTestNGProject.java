package TestNGExample;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.json.simple.JSONObject;
public class SampleTestNGProject {
	
  @Test(priority=0)
  public void Get_Listusers () throws IOException {
		Properties prob = new Properties();
		InputStream input = new FileInputStream("C:\\JavaProgram\\workspace\\Testing_batch75\\src\\test\\java\\TestNGExample\\SampleTestNGProject.java");
		prob.load(input);
	  given()
		.when()
		.get(prob.getProperty("url1"))
		.then()
		.statusCode(200)
		.log().all()
		.assertThat()
				.body("data[1].id", equalTo(8))
				.body("data[1].email", equalTo("lindsay.ferguson@reqres.in"))
				.body("data[1].first_name", equalTo("Lindsay"))
				.body("data[1].last_name", equalTo("Ferguson"));
	  
	  
  }


@Test(priority=1)
public void Get_SingleUser() throws IOException {
	Properties prob = new Properties();
	InputStream input = new FileInputStream("C:\\JavaProgram\\workspace\\Testing_batch75\\src\\test\\java\\TestNGExample\\SampleTestNGProject.java");
	prob.load(input);
	given()
	.when()
	.get(prob.getProperty("url2"))
	.then()
	.statusCode(200)
	.log().all()
	.assertThat()
	.body("data.id", equalTo(2))
	.body("data.email", equalTo("janet.weaver@reqres.in"))
	.body("data.first_name", equalTo("Janet"))
	.body("data.last_name", equalTo("Weaver"));
	
	  
}
	@Test(priority=2)
	public void Get_SingleUserNotFound() throws IOException {
		Properties prob = new Properties();
		InputStream input = new FileInputStream("C:\\JavaProgram\\workspace\\Testing_batch75\\src\\test\\java\\TestNGExample\\SampleTestNGProject.java");
		prob.load(input);
		given()
		.when()
		.get(prob.getProperty("url3"))
		.then()
		.statusCode(404)
		.log().all()
		.assertThat()
		.body("data.page",equalTo(null));

	}

@Test(priority=3)
		public void Get_ListResource() throws IOException {
	Properties prob = new Properties();
	InputStream input = new FileInputStream("C:\\JavaProgram\\workspace\\Testing_batch75\\src\\test\\java\\TestNGExample\\SampleTestNGProject.java");
	prob.load(input);
			given()
			.when()
			.get(prob.getProperty("url4"))
			.then()
			.statusCode(200)
			.log().all()
			.assertThat()
					.body("data[0].id", equalTo(1))
					.body("data[0].name", equalTo("cerulean"))
					.body("data[0].year", equalTo(2000))
					.body("data[0].color", equalTo("#98B2D1"))
					.body("data[0].pantone_value", equalTo("15-4020"));



	}
	@Test(priority=4)
	public void Get_SingleResource () throws IOException {
		Properties prob = new Properties();
		InputStream input = new FileInputStream("C:\\JavaProgram\\workspace\\Testing_batch75\\src\\test\\java\\TestNGExample\\SampleTestNGProject.java");
		prob.load(input);
		given()
		.when()
		.get(prob.getProperty("url5"))
		.then()
		.statusCode(200)
		.log().all()
		.assertThat()
				.body("data.id", equalTo(2))
				.body("data.name", equalTo("fuchsia rose"))
				.body("data.year", equalTo(2001))
				.body("data.color", equalTo("#C74375"))
				.body("data.pantone_value", equalTo("17-2031"));

	}
	@Test(priority=5)
	public void Get_SingleResourceNotFound() throws IOException {
		Properties prob = new Properties();
		InputStream input = new FileInputStream("C:\\JavaProgram\\workspace\\Testing_batch75\\src\\test\\java\\TestNGExample\\SampleTestNGProject.java");
		prob.load(input);
		given()
		.when()
		.get(prob.getProperty("url6"))
		.then()
		.statusCode(404)
		.log().all()
		.assertThat()
		.body("data.page",equalTo(null));
	
}
	@Test(priority=6)
	public void Get_DelayedResponse () throws IOException {
		Properties prob = new Properties();
		InputStream input = new FileInputStream("C:\\JavaProgram\\workspace\\Testing_batch75\\src\\test\\java\\TestNGExample\\SampleTestNGProject.java");
		prob.load(input);
		given()
		.when()
		.get(prob.getProperty("url7"))
		.then()
		.statusCode(200)
		.log().all()
		.assertThat()
				.body("data[1].id", equalTo(2))
				.body("data[1].email", equalTo("janet.weaver@reqres.in"))
				.body("data[1].first_name", equalTo("Janet"))
				.body("data[1].last_name", equalTo("Weaver"));
	  
}
	
		@Test(priority=7)
		public void Post_Create() throws IOException {
			Properties prob = new Properties();
			InputStream input = new FileInputStream("C:\\JavaProgram\\workspace\\Testing_batch75\\src\\test\\java\\TestNGExample\\SampleTestNGProject.java");
			prob.load(input);
			JSONObject request = new JSONObject();
			request.put("name", "Mahima");
			request.put("job", "Engineer");
			given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(request.toJSONString())
			.when()
			.post(prob.getProperty("url8"))
			.then()
			.statusCode(201)
			.log().all();
		}
		@Test(priority=8)
		public void Post_RegisterSucessfull() throws IOException {
			Properties prob = new Properties();
			InputStream input = new FileInputStream("C:\\JavaProgram\\workspace\\Testing_batch75\\src\\test\\java\\TestNGExample\\SampleTestNGProject.java");
			prob.load(input);
			JSONObject request = new JSONObject();
			request.put("email", "eve.holt@reqres.in");
			request.put("password", "pistol");
			given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
					.body(request.toJSONString())
					.when()
					.post(prob.getProperty("url9"))
					.then()
					.statusCode(200)
					.log().all();
		}
		@Test(priority=9)
		public void Post_RegisterUnsucessfull () throws IOException {
			Properties prob = new Properties();
			InputStream input = new FileInputStream("C:\\JavaProgram\\workspace\\Testing_batch75\\src\\test\\java\\TestNGExample\\SampleTestNGProject.java");
			prob.load(input);
			JSONObject request = new JSONObject();
			request.put("email", "eve.holt@reqres.in");
			given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON).accept(ContentType.JSON)
					.body(request.toJSONString())
					.when()
					.post(prob.getProperty("url10"))
					.then()
					.statusCode(400)
					.log().all();
			
		}
		@Test(priority=10)
		public void Post_LoginSucessfully() throws IOException {
			Properties prob = new Properties();
			InputStream input = new FileInputStream("C:\\JavaProgram\\workspace\\Testing_batch75\\src\\test\\java\\TestNGExample\\SampleTestNGProject.java");
			prob.load(input);
			JSONObject request = new JSONObject();
			request.put("email", "eve.holt@reqres.in");
			request.put("password", "pistol");
			given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON).accept(ContentType.JSON)
					.body(request.toJSONString())
					.when()
					.post(prob.getProperty("url11"))
					.then()
					.statusCode(200)
					.log().all();
			
		}
		@Test(priority=11)
		public void Post_LoginUnsucessfully() throws IOException {
			Properties prob = new Properties();
			InputStream input = new FileInputStream("C:\\JavaProgram\\workspace\\Testing_batch75\\src\\test\\java\\TestNGExample\\SampleTestNGProject.java");
			prob.load(input);
			JSONObject request = new JSONObject();
			request.put("email", "eve.holt@reqres.in");
			given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
					.body(request.toJSONString())
					.when()
					.post(prob.getProperty("url12"))
					.then()
					.statusCode(400)
					.log().all();
		
}
		@Test(priority=12)
		public void Patch_Update() throws IOException {
			Properties prob = new Properties();
			InputStream input = new FileInputStream("C:\\JavaProgram\\workspace\\Testing_batch75\\src\\test\\java\\TestNGExample\\SampleTestNGProject.java");
			prob.load(input);
			JSONObject request = new JSONObject();
			request.put("name", "Mahima");
			request.put("job", "Engineer");
			given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
					.body(request.toJSONString())
					.when()
					.patch(prob.getProperty("url13"))
					.then()
					.statusCode(200)
					.log().all();

		}
		@Test(priority=13)
		public void PUT_Update_() throws IOException {
			Properties prob = new Properties();
			InputStream input = new FileInputStream("C:\\JavaProgram\\workspace\\Testing_batch75\\src\\test\\java\\TestNGExample\\SampleTestNGProject.java");
			prob.load(input);
			JSONObject request = new JSONObject();
			request.put("name", "Mahima");
			request.put("job", "Engineer");
			given()
			.header("Content-Type", "application/json")
			.contentType(ContentType.JSON).accept(ContentType.JSON)
					.body(request.toJSONString())
					.when()
					.put(prob.getProperty("url14"))
					.then()
					.statusCode(200)
					.log().all();

		}
		@Test(priority=14)
		public void delete_test()throws IOException {
			Properties prob = new Properties();
			InputStream input = new FileInputStream("C:\\JavaProgram\\workspace\\Testing_batch75\\src\\test\\java\\TestNGExample\\SampleTestNGProject.java");
			prob.load(input);
			given()
			.when()
			.delete(prob.getProperty("url5"))
			.then()
			.statusCode(204)
			.log().all();

		}	
}
