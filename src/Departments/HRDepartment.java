package Departments;


import Interface.EmployeeList;
import Model.Worker;
import lombok.Getter;

import java.util.*;


public class HRDepartment implements EmployeeList<Worker> {
    @Getter
    private List<Worker> workers;

    public HRDepartment() {
        workers = new LinkedList<>();
    }

    public void add(Worker worker) {
    workers.add(worker);
    }

    public void delete(int id) {
    workers.remove(id);
    }

    public void update(int id, Worker worker) {
    workers.set(id,worker);
    }

    public Worker get(int id) {
        return workers.get(id);
    }

}
