package Interface;

import Model.Worker;

public interface DepartmentsInterface {

    void addOrUpdateDepartment(String name, Worker worker);

    void deleteDepartment(String name, Worker worker);

}
