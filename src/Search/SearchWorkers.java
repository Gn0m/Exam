package Search;


import Model.Worker;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class SearchWorkers {

    public List<Worker> find(String firstName, String secondName, String thirdName, List<Worker> list) {
        return list.stream()
                .filter(worker -> worker.fullName()
                        .equals(secondName.concat(" ").concat(firstName).concat(" ").concat(thirdName)))
                .collect(Collectors.toList());
    }


    public List<Worker> findDepartment(String department, List<Worker> list) {
        return list.stream()
                .filter(worker-> worker.getDepartment().equals(department)).collect(Collectors.toList());
    }


    public List<Worker> findBoss(String firstName, String secondName, String thirdName, List<Worker> list) {
        String fullName = secondName.concat(" ").concat(firstName).concat(" ").concat(thirdName);
        Worker user = list.stream()
                .filter(worker -> worker.getFullName().equals(fullName) && worker.isBoss()).findFirst().orElse(null);
        String department = Objects.requireNonNull(user).getDepartment();
        return list.stream().filter(worker -> worker.getDepartment().equals(department)).collect(Collectors.toList());
    }


    public List<Worker> findTitle(String title, List<Worker> list) {
        return list.stream().filter(worker -> worker.getJobTitle().equals(title)).collect(Collectors.toList());
    }
}
