package restAssured;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ejercicio2  {

	@Test
	public void testMascotasVendidas() {
		// Establecer la URL base del servicio
		String baseUrl = "https://petstore.swagger.io/v2/pet";

		// Realizar la solicitud GET y almacenar la respuesta
		Response response = RestAssured.given().queryParam("status", "sold").when().get(baseUrl + "/findByStatus");

		// Obtener el cuerpo de la respuesta en forma de JSON como String
		String jsonResponse = response.getBody().asString();


        // Usar Jackson para parsear el JSON y extraer los campos id y name
        ObjectMapper objectMapper = new ObjectMapper();
        try {
        	 List<Map<String, Object>> pets = objectMapper.readValue(jsonResponse, new com.fasterxml.jackson.core.type.TypeReference<List<Map<String, Object>>>(){});

             // Crear un diccionario para almacenar id y name
             Map<Long, String> petDictionary = new HashMap<>();

             // Iterar sobre la lista de pets y almacenar en el diccionario
             for (Map<String, Object> pet : pets) {
                 Long id = ((Number) pet.get("id")).longValue();  // Convertir id a Long
                 String name = (String) pet.get("name");
                 petDictionary.put(id, name);
             }
          // Imprimir el diccionario
             System.out.println("Contenido del diccionario (petDictionary):");
             for (Map.Entry<Long, String> entry : petDictionary.entrySet()) {
                 System.out.println("id: " + entry.getKey() + ", name: " + entry.getValue());
             }
             
             Ejercicio3 ej3 = new Ejercicio3(petDictionary);
             ej3.countPetsWithSameName();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
