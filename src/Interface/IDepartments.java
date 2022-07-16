package Interface;

import Model.Worker;

public interface IDepartments {

    void addOrUpdateDepartment(String name, Worker worker);

    void deleteDepartment(String name, Worker worker);

}
