package Departments;


import Model.Worker;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
public class HRDepartment {

    private List<Worker> workers;

    public HRDepartment() {
        workers = new LinkedList<>();
    }

    public void addWorker(Worker worker) {
    workers.add(worker);
    }

    public void deleteWorker(int id) {
    workers.remove(id);
    }

    public void updateWorker(int id, Worker worker) {
    workers.set(id,worker);
    }

    public Worker getWorker(int id) {
        return workers.get(id);
    }

}
