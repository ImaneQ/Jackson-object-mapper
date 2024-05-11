package com.example.introjacksonobjectmapper;

import Utils.*;
import com.fasterxml.jackson.databind.*;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import vehicle.*;

import java.io.*;

@SpringBootApplication
public class IntroJacksonObjectMapperApplication {
    public static void main(String[] args) throws IOException {
        SpringApplication.run(IntroJacksonObjectMapperApplication.class, args);

        JsonUtils jsonUtils = new JsonUtils();

        Car car = new Car("blue", "Lamborghini");
        Car car2 = new Car("red", "Ferrari");

        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        String json2 = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
        String jsonCarArray =
                "[{ \"color\" : \"Grey\", \"type\" : \"Audi\" }, { \"color\" : \"Green\", \"type\" : \"Porsche\" }]";
        String jsonString = "{ \"color\" : \"White\", \"type\" : \"Audi RS4\" }";

        System.out.println(jsonUtils.writeValueObjectMapper(car));
        System.out.println(jsonUtils.writeValueAsStringMethod(car));

        System.out.println(jsonUtils.writeValueObjectMapper(car2));
        System.out.println(jsonUtils.writeValueAsStringMethod(car2));

        System.out.println(jsonUtils.readValueMethod(json));
        System.out.println(jsonUtils.readValueMethodURL("target/car.json"));

        System.out.println(jsonUtils.readTreeMethod(json2));
        JsonNode readTreeJson = jsonUtils.readTreeMethod(json2);
        System.out.println("readTreeJson " + readTreeJson);

        System.out.println("Color : " + jsonUtils.getDataFromJSONode(json2,"color"));
        System.out.println("Type : " + jsonUtils.getDataFromJSONode(json2,"type"));

        System.out.println("List of cars : " + jsonUtils.parseJsonArrayTojavaObjectList(jsonCarArray));
        System.out.println("Java Map from JSON string : " + jsonUtils.creatingJavaMapFromJsonString(jsonString));
    }

}
