package email.json;


import java.io.File;
import java.io.IOException;
import java.util.List;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import email.Email;

import javax.json.stream.JsonGenerationException;


//анмаршалинг для json
public class ReadJSON {
        public static void main(String[] args) throws IOException {
            ObjectMapper objectMapper = new ObjectMapper();
            //задаём тип коллекции для маппера
            JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Email.class );
            try {
                List<Email> emails = objectMapper.readValue(new File("./resources/emails-r.json"), type);
                for (Email arr : emails) {
                    System.out.println(arr);
                }
            } catch (JsonGenerationException | IOException e) {
                e.printStackTrace();
            }
        }


}
