package SerializeJackson;


import Model.User;
import Model.Worker;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Serialize {

    @SneakyThrows
    public static void Serialize(List<User> list, String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(filePath), list);
    }

    @SneakyThrows
    public static ArrayList<User> Deserialize(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        return (ArrayList<User>) mapper.readValue(new File(filePath), new TypeReference<List<User>>() {
        });
    }

    public static List<User> parseJsonUser(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = new FileInputStream(filePath);
        return mapper.readValue(is, new TypeReference<List<User>>() {
        });
    }

    public static List<Worker> parseJsonWorker(String filePath) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        InputStream is = new FileInputStream(filePath);
        return mapper.readValue(is, new TypeReference<List<Worker>>() {
        });
    }

    public static void serializeReportListStr(List<String> list, String filePath) throws IOException {
        File file = new File(filePath);

        FileWriter fileWriter = new FileWriter(file);
        for (String s : list) {
            fileWriter.write(s + "\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }

    public static void serializeReportAvgOrg(String string, String filePath) throws IOException {
        File file = new File(filePath);

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("Средняя зарплата по организации: " + string);
        fileWriter.flush();
        fileWriter.close();
    }

    public static void serializeReportSalary(List<Worker> list, String filePath) throws IOException {
        File file = new File(filePath);

        FileWriter fileWriter = new FileWriter(file);
        for (Worker worker : list) {
            fileWriter.write(worker.toString() + "\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }

    public static void serializeReportYears(List<Worker> list, String filePath) throws IOException {
        File file = new File(filePath);

        FileWriter fileWriter = new FileWriter(file);
        for (Worker worker : list) {

            LocalDate localDate = LocalDate.now();

            int years = localDate.getYear() - worker.getRecruitmentDate().getWeekYear();
            fileWriter.write(worker + " Количество лет проработанных в компании " + years + "\n");
        }

        fileWriter.flush();
        fileWriter.close();
    }


}


