package RegistrationAndAuth;

import Departments.ITDepartment;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RecoveryTest {

    private ITDepartment itDepartment;
    private Recovery recovery;

    @Before
    public void setUp() {
        itDepartment = new ITDepartment();
        recovery = new Recovery();
    }

    @Test
    public void recovery() {
        assertEquals("admin",itDepartment.get(0).getPassword());
        recovery.recovery("admin","password",itDepartment);

        assertEquals("password",itDepartment.get(0).getPassword());
    }
}