package pom;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import java.util.HashMap;
public class APICommentsTest {

	@Test
	void getComments() {
		given()
		.when()
			.get("https://jsonplaceholder.typicode.com/posts/1/comments")
		.then()
			.statusCode(200)
			.log().all();
	}
	
	@Test
	void createComment() {
		HashMap<String, String> data = new HashMap<String, String>(); 
		data.put("postId", "1");
		data.put("name", "id labore ex et quam laborum");
		data.put("email", "Eliseo@gardner.biz");
		data.put("body", "laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium");
		
		given()
			.contentType("application/json")
			.body(data)
		.when()
			.post("https://jsonplaceholder.typicode.com/posts/1/comments")
		.then()
			.statusCode(201)
			.log().all();
	}
	
	@Test
	void updateComment() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("postId", "1");
		data.put("id", "1");
		data.put("name", "id labore ex et quam laborum");
		data.put("email", "Eliseo@gardner.biz");
		data.put("body", "laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium");
		
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
	void patchComment() {
		HashMap<String, String> data = new HashMap<String, String>();
		data.put("postId", "1");
		data.put("id", "1");
		data.put("name", "id labore ex et quam laborum");
		data.put("email", "Eliseo@gardner.biz");
		data.put("body", "laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium");
		
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
