package RegistrationAndAuth;

import Departments.ITDepartment;
import Model.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RegistrationTest {
    private ITDepartment itDepartment;
    private Registration registration;
    private User user;

    @Before
    public void setUp() {
        itDepartment = new ITDepartment();
        registration = new Registration();
        user = new User();
    }

    @Test
    public void registrationUser() {
        user.setLogin("admin");
        user.setPassword("admin");
        boolean check = registration.registrationUser(user,itDepartment);

        assertFalse(check);

        user.setLogin("notAdmin");
        check = registration.registrationUser(user,itDepartment);

        assertTrue(check);

    }
}