package pom;
import static io.restassured.RestAssured.given;
import java.util.HashMap;
import java.util.Map;
import org.testng.annotations.Test;

public class APIAlbumsTest {
	@Test
	void getAlbums() {
		given()
		.when()
			.get("https://jsonplaceholder.typicode.com/albums")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	void createAlbum() {
		Map<String, Object> data = new HashMap<>(); 
		data.put("userId", "1");
		data.put("id", "1");
		data.put("title", "quidem molestiae enim");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://jsonplaceholder.typicode.com/albums")
		.then()
			.statusCode(201)
			.log().all();
	}
	
	@Test
	void updateAlbum() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("userId", "1");
		data.put("id", "1");
		data.put("title", "quidem molestiae enim");

		given()
		.contentType("application/json")
		.body(data)
		.when()
			.put("https://jsonplaceholder.typicode.com/albums/1")
		.then()
			.statusCode(200)
			.log().all();
	}

	@Test
	void patchAlbum() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("userId", "1");
		data.put("id", "1");
		data.put("title", "quidem molestiae enim");

		given()
		.contentType("application/json")
		.body(data)
		.when()
			.patch("https://jsonplaceholder.typicode.com/albums/1")
		.then()
			.statusCode(200)
			.log().all();
	}

	@Test
	void deleteAlbum() {

		given()
		.when()
			.delete("https://jsonplaceholder.typicode.com/albums/1")
		.then()
			.statusCode(200)
			.log().all();
	}

}
