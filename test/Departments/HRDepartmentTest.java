package Departments;

import Model.Worker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HRDepartmentTest {
    private HRDepartment hrDepartment;
    private Worker worker;

    @Before
    public void setUp() {
        hrDepartment = new HRDepartment();
        worker = new Worker();
        worker.setFirstName("Алёша");
    }

    @Test
    public void addAndGet() {
        assertTrue(hrDepartment.getWorkers().isEmpty());
        hrDepartment.add(worker);
        assertEquals(1, hrDepartment.getWorkers().size());

        Worker testWorker = hrDepartment.get(0);
        assertEquals(worker, testWorker);

    }

    @Test
    public void delete() {
        hrDepartment.add(worker);
        assertFalse(hrDepartment.getWorkers().isEmpty());
        hrDepartment.delete(0);
        assertTrue(hrDepartment.getWorkers().isEmpty());
    }

    @Test
    public void update() {
        hrDepartment.add(worker);
        assertEquals("Алёша", hrDepartment.getWorkers().get(0).getFirstName());

        worker.setFirstName("Тестовый");
        hrDepartment.update(0, worker);
        assertEquals("Тестовый", hrDepartment.getWorkers().get(0).getFirstName());

    }
}