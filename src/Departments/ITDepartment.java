package Departments;

import Model.Abstract.Employee;
import Model.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class ITDepartment implements Interface.ITDepartmentInterface {

    @Getter
    private List<User> users;

    public ITDepartment() {
        this.users = new ArrayList<>();
    }

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
    public User getUser(int id) {
        return users.get(id);
    }
}
