package Search;


import Model.Worker;
import java.util.List;
import java.util.stream.Collectors;


public class SearchWorkers {

    public List<Worker> find(String firstName, String secondName, String thirdName, List<Worker> list) {
        return list.stream()
                .filter(worker -> worker.toString()
                        .equals(firstName.concat(" ").concat(secondName).concat(" ").concat(thirdName)))
                .collect(Collectors.toList());
    }


    public List<Worker> findDepartment(String department, List<Worker> list) {
        return list.stream()
                .filter(worker-> worker.getDepartment().equals(department)).collect(Collectors.toList());
    }


    public List<Worker> findBoss(String firstName, String secondName, String thirdName, List<Worker> list) {
        String str = firstName.concat(" ").concat(secondName).concat(" ").concat(thirdName);
        return list.stream().filter(worker ->worker.getFullName().equals(str) && worker.isBoss()).collect(Collectors.toList());
    }


    public List<Worker> findTitle(String title, List<Worker> list) {
        return list.stream().filter(worker -> worker.getJobTitle().equals(title)).collect(Collectors.toList());
    }
}
