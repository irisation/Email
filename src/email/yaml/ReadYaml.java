package email.yaml;


import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import email.Email;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class ReadYaml {
    public static void main(String[] args) throws IOException {

        YAMLFactory fact = new YAMLFactory();
        ObjectMapper objectMapper = new ObjectMapper(fact);
        //задаём тип коллекции для маппера
        JavaType type = objectMapper.getTypeFactory().constructCollectionType(List.class, Email.class);
        List<Email> emails = objectMapper.readValue(new File("./resources/emails-w.yaml"), type);
        for (Email email:emails){
            System.out.println(email);
        }
    }


}

