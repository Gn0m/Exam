package SerializeJackson;


import Model.User;
import Model.Worker;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class Serialize {

    @SneakyThrows
    public  void serializeUsers(List<User> list, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filePath), list);
    }

    @SneakyThrows
    public  ArrayList<User> deserializeUsers(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        return (ArrayList<User>) mapper.readValue(new File(filePath), new TypeReference<List<User>>() {
        });
    }

    @SneakyThrows
    public  void serializeWorkers(List<Worker> list, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filePath), list);
    }

    @SneakyThrows
    public  ArrayList<Worker> deserializeWorkers(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        return (ArrayList<Worker>) mapper.readValue(new File(filePath), new TypeReference<List<Worker>>() {
        });
    }

    public  void serializeReport(List<String> list, String filePath) throws IOException {
        File file = new File(filePath);
        try{
            FileWriter fileWriter = new FileWriter(file);
            for (String s : list) {
                fileWriter.write(s + "\n");
            }
            fileWriter.flush();
            fileWriter.close();
        } catch (FileNotFoundException ex){
            System.out.println("Не верное имя файла!"+"\n");
        }
    }

    public  void serializeReport(String string, String filePath) throws IOException {
        File file = new File(filePath);
        try{
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(string);
            fileWriter.flush();
            fileWriter.close();
        } catch (FileNotFoundException ex){
            System.out.println("Не верное имя файла!"+"\n");
        }
    }






}


