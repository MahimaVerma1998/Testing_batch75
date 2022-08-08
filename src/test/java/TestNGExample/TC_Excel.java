package TestNGExample;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TC_Excel {
	@Test
	public void f() throws IOException {
		String projectpath = System.getProperty("user.dir");
		System.out.println("projectpath:" +projectpath);
		String Excelpath = "C:\\JavaProgram\\workspace\\Testing_batch75\\ExcelData.xlsx";
		FileInputStream input = new FileInputStream(Excelpath);
		XSSFWorkbook workbook = new XSSFWorkbook(input);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int rowcount = sheet.getPhysicalNumberOfRows();
		System.out.println("Row count:" + rowcount);
		String url = sheet.getRow(0).getCell(0).getStringCellValue();
		System.out.println("URL is" + url);
		given()
		.when()
		.get(url)
		.then()
		.statusCode(200)
		 .assertThat()
		 .body("data[1].id", equalTo(8))
		 .body("data[1].email", equalTo("lindsay.ferguson@reqres.in"))
		 .body("data[1].first_name", equalTo("Lindsay"))
		 .body("data[1].last_name", equalTo("Ferguson"));
	}

}
