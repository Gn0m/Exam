package Departments;

import Model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;

import static org.junit.Assert.*;

public class ITDepartmentTest {
    private ITDepartment itDepartment;
    private User user;

    @Before
    public void setUp() {
        itDepartment = new ITDepartment();
        user = new User();
        user.setFirstName("Алёша");
    }

    @Test
    public void addAndGet() {
        itDepartment.add(user);

        assertFalse(itDepartment.getUsers().isEmpty());

        User admin = itDepartment.get(0);

        assertEquals(user, itDepartment.get(1));
        assertEquals(user.getFirstName(), itDepartment.get(1).getFirstName());
        assertEquals(admin, itDepartment.get(0));
        assertEquals(admin.getLogin(), itDepartment.get(0).getLogin());
    }

    @Test
    public void delete() {
        itDepartment.add(user);
        assertEquals(user, itDepartment.get(1));
        assertEquals(2, itDepartment.getUsers().size());
        itDepartment.delete(1);
        assertEquals(1, itDepartment.getUsers().size());
    }

    @Test
    public void update() {
        User admin = itDepartment.get(0);
        assertEquals(admin.getLogin(), itDepartment.get(0).getLogin());

        admin.setLogin("newLogin");
        itDepartment.update(0, admin);
        assertEquals(admin.getLogin(), itDepartment.get(0).getLogin());
    }


    @Test
    public void getUsers() {
        LinkedList<User> list = (LinkedList<User>) itDepartment.getUsers();

        assertNotNull(list);
    }
}