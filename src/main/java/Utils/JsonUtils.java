package Utils;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import vehicle.*;

import java.io.*;

public class JsonUtils {
    public String jsonString;
    public String data;
    ObjectMapper objectMapper = new ObjectMapper();


    public File writeValueObjectMapper(Object object) throws IOException {
        File outputFile = new File("target/car.json");

        // ouverture en mode append donc "true"
        //FileWriter fileWriter = new FileWriter(outputFile, true);

        // on écrit l'objet JSON dans le fichier en mode append
        objectMapper.writeValue(outputFile, object);


        // fermeture du FileWriter
        // fileWriter.close();

        return outputFile;
    }

    public String writeValueAsStringMethod(Object object) throws JsonProcessingException {
        return objectMapper.writeValueAsString(object);
    }

    public Car readValueMethod(String string) throws JsonProcessingException {
        return objectMapper.readValue(string, Car.class);
    }

    public Car readValueMethodURL(String filePath) throws IOException {
        File file = new File(filePath);
        return objectMapper.readValue(file, Car.class);
    }

    public JsonNode readTreeMethod(String jsonString) throws JsonProcessingException {
        return objectMapper.readTree(jsonString);
    }

    public String getDataFromJSONode(String jsonString, String data) throws JsonProcessingException {
        JsonNode jsoNode = objectMapper.readTree(jsonString);
        return jsoNode.get(data).asText();
    }
}
