package Interface;

import Model.Worker;

import java.util.List;

public interface SearchWorkerInterface {

    List<Worker> find(String firstName, String secondName, String thirdName, List<Worker> list);

    List<Worker> findDepartment(String department, List<Worker> list);

    List<Worker> findBoss(String firstName, String secondName, String thirdName, List<Worker> list);

    List<Worker> findTitle(String title, List<Worker> list);
}
