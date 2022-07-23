package Departments;
import Model.User;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class ITDepartment implements Interface.ITDepartmentInterface {

    @Getter
    private List<User> users;

    public ITDepartment() {
        this.users = new ArrayList<>();
        //тестовое
        User admin = new User("Леонид","Гущин","Петрович",
                new GregorianCalendar(1991,12,27),"м","8812843","admin","admin");
        users.add(admin);
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
