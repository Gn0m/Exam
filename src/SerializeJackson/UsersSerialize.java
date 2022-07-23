package SerializeJackson;


import Model.User;
import Model.Worker;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UsersSerialize {


    @SneakyThrows
    public static void Serialize(List<User> list){
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File("save.dat"), list);
    }

    @SneakyThrows
    public static ArrayList<User> Deserialize(){
        ObjectMapper mapper = new ObjectMapper();
        return (ArrayList<User>) mapper.readValue(new File("save.dat"), new TypeReference<List<User>>() {});
    }

    public static List<User> parseJsonUser() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = new FileInputStream("user.json");
        return mapper.readValue(is, new TypeReference<List<User>>() {});
    }

    public static List<Worker> parseJsonWorker() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = new FileInputStream("worker.json");
        return mapper.readValue(is, new TypeReference<List<Worker>>() {});
    }


    }


