package Departments;

import Model.Abstract.Employee;
import Model.User;

import java.util.List;

public class ITDepartment implements Interface.ITDepartmentInterface {

    private List<User> users;


    @Override
    public void add(User user) {
    users.add(user);
    }

    @Override
    public void delete(int id) {
    users.remove(id);
    }

    @Override
    public void update(int id, User user) {
    users.set(id,user);
    }

    @Override
    public Employee getEmployee(int id) {
        return users.get(id);
    }
}
