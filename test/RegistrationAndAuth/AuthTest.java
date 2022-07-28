package RegistrationAndAuth;

import Departments.ITDepartment;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AuthTest {
    private Auth auth;
    private ITDepartment itDepartment;



    @Before
    public void setUp() {
        auth = new Auth();
        itDepartment = new ITDepartment();
    }

    @Test
    public void auth() {
        boolean check = auth.auth("admin","admin",itDepartment);
        assertTrue(check);
        check  = auth.auth("admin","password",itDepartment);
        assertFalse(check);
    }
}