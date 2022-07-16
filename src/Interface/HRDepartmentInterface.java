package Interface;

import Model.Abstract.Employee;
import Model.Worker;

public interface HRDepartmentInterface {

    void addWorker(Worker worker);

    void deleteWorker(int id);

    void updateWorker(int id,Worker worker);

    Employee getEmployee(int id);
}
