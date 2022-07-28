package Departments;
import Interface.EmployeeList;
import Model.User;
import lombok.Getter;

import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public class ITDepartment  implements EmployeeList<User> {

    @Getter
    private final List<User> users;

    public ITDepartment() {
        this.users = new LinkedList<>();
        //тестовое
        User admin = new User("Леонид","Гущин","Петрович",
                new GregorianCalendar(1991,12,27),"м","8812843","admin","admin");
        admin.setHr(true);
        admin.setAdmin(true);
        users.add(admin);
    }


    public void add(User user) {
    users.add(user);
    }

    public void delete(int id) {
    users.remove(id);
    }

    public void update(int id, User user) {
    users.set(id,user);
    }

    public User get(int id) {
        return users.get(id);
    }
}
