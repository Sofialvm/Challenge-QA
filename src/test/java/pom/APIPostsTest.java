package pom;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;

public class APIPostsTest {
	
	@Test
	void getPosts() {
		given()
		.when()
			.get("https://jsonplaceholder.typicode.com/posts")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	void createPost() {
		HashMap<String, String> data = new HashMap<String, String>(); 
		data.put("title", "foo");
		data.put("body", "bar");
		data.put("userId", "1");
		  
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://jsonplaceholder.typicode.com/posts")
		.then()
			.statusCode(201)
			.log().all();
	}
	
	@Test
	void updatePost() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("id", "1");
		data.put("title", "foo");
		data.put("body", "bar");
		data.put("userId", "1");

		given()
		.contentType("application/json")
		.body(data)
		.when()
			.put("https://jsonplaceholder.typicode.com/posts/1")
		.then()
			.statusCode(200)
			.log().all();
	}

	@Test
	void patchPost() {
		HashMap<String, String> data = new HashMap<String, String>(); 
		data.put("title", "foo");
		
		given()
		.contentType("application/json")
		.body(data)
		.when()
			.patch("https://jsonplaceholder.typicode.com/posts/1")
		.then()
			.statusCode(200)
			.log().all();
	}

	@Test
	void deletePost() {
		given()
		.when()
			.delete("https://jsonplaceholder.typicode.com/posts/1")
		.then()
			.statusCode(200)
			.log().all();
	}


}
