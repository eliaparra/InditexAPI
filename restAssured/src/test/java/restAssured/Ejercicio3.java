package restAssured;
import java.util.HashMap;
import java.util.Map;

public class Ejercicio3 {
	
	private Map<Long, String> petDictionary;

	public Ejercicio3(Map<Long, String> petDictionary) {
		 this.petDictionary = new HashMap<>(petDictionary);
	}

	// Método para contar cuántas mascotas tienen el mismo nombre
    public void countPetsWithSameName() {
        Map<String, Integer> nameCountMap = new HashMap<>();

        // Iterar sobre el petDictionary y contar las ocurrencias de cada nombre
        for (String name : petDictionary.values()) {
            nameCountMap.put(name, nameCountMap.getOrDefault(name, 0) + 1);
        }

        // Imprimir el resultado
        System.out.println("Número de mascotas con el mismo nombre:");
        for (Map.Entry<String, Integer> entry : nameCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
