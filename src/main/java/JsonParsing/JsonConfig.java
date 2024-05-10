package JsonParsing;

import com.fasterxml.jackson.databind.*;
import org.springframework.context.annotation.*;

@Configuration

public class JsonConfig {
    ObjectMapper objectMapper = new ObjectMapper();

    @Bean
    public ObjectMapper ObjectMapper() {
        // pour activer une fonctionnalité spécifique qui sert à identer la sortie JSON générée
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        return objectMapper;
    }

}
