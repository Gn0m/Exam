package Departments;

import Interface.IDepartments;
import Interface.ITDepartmentInterface;
import Model.Abstract.Employee;
import Model.Worker;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Setter
@Getter
public class HRDepartment implements Interface.HRDepartmentInterface, IDepartments {

    private List<Worker> workers;
    private Map<String,Worker> departments;

    public HRDepartment() {
        workers = new LinkedList<>();
        departments = new HashMap<>();
    }


    @Override
    public void addWorker(Worker worker) {
    workers.add(worker);
    }

    @Override
    public void deleteWorker(int id) {
    workers.remove(id);
    }

    @Override
    public void updateWorker(int id, Worker worker) {
    workers.set(id,worker);
    }

    @Override
    public Employee getEmployee(int id) {
        return workers.get(id);
    }


    @Override
    public void addOrUpdateDepartment(String name, Worker worker) {
        departments.put(name,worker);
    }

    @Override
    public void deleteDepartment(String name, Worker worker) {
        departments.remove(name);
    }


}
