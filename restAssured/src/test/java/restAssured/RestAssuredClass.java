package restAssured;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredClass {

	@Test
	public void testNewUser() {
		// Configurar RestAssured
		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		// Crear el JSON del usuario
		String userJson = "{\n" + "  \"id\": 0,\n" + "  \"username\": \"elia2\",\n" + "  \"firstName\": \"string\",\n"
				+ "  \"lastName\": \"string\",\n" + "  \"email\": \"string\",\n" + "  \"password\": \"string\",\n"
				+ "  \"phone\": \"string\",\n" + "  \"userStatus\": 0\n" + "}";

		// Realizar la solicitud POST para crear el usuario
		Response response = RestAssured.given().contentType(ContentType.JSON).body(userJson).when().post("/user").then()
				.statusCode(200) // Puedes ajustar el código de estado esperado según la API
				.extract().response();

		// Imprimir la respuesta
		System.out.println(response.asString());
	}
	
	
	@Test
    public void testGetUserByUsername() {
        // Configurar RestAssured
        RestAssured.baseURI = "https://petstore.swagger.io/v2";

        // El nombre de usuario que queremos obtener
        String username = "elia2";

        // Realizar la solicitud GET al endpoint /user/{username}
        Response response = RestAssured.given()
                .pathParam("username", username)
                .when()
                .get("/user/{username}")
                .then()
                .statusCode(200)
                .extract().response();

        // Imprimir la respuesta
        System.out.println(response.asString());
    }
	
	
	
	
}
