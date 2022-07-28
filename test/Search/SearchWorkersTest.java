package Search;

import Departments.HRDepartment;
import Model.Worker;
import SerializeJackson.Serialize;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class SearchWorkersTest {

    private HRDepartment hrDepartment;
    private Serialize serialize;
    private SearchWorkers searchWorkers;

    @Before
    public void setUp() {
        hrDepartment = new HRDepartment();
        serialize = new Serialize();
        searchWorkers = new SearchWorkers();
        hrDepartment.getWorkers().addAll(serialize.deserializeWorkers("worker.json"));
    }

    @Test
    public void find() {
        ArrayList<Worker> list = (ArrayList<Worker>) searchWorkers
                .find("Леонид","Гущин","Петрович",hrDepartment.getWorkers());
        if (list.size()==1){
            Worker worker = list.get(0);
            assertEquals("Гущин",worker.getSecondName());
            assertEquals("Леонид",worker.getFirstName());
            assertEquals("Петрович",worker.getThirdName());
        } else {
            for (Worker worker: list) {
                assertEquals("Гущин Леонид Петрович",worker.fullName());
            }
        }
    }

    @Test
    public void findDepartment() {
        ArrayList<Worker> list = (ArrayList<Worker>) searchWorkers
                .findDepartment("Разработки",hrDepartment.getWorkers());
            for (Worker worker: list) {
                assertEquals("Разработки",worker.getDepartment());
            }

    }

    @Test
    public void findBoss() {
        ArrayList<Worker> list = (ArrayList<Worker>) searchWorkers
                .findBoss("Cally","Puckett","Langley",hrDepartment.getWorkers());
        for (Worker worker: list) {
            assertEquals("Разработки",worker.getDepartment());
        }
    }

    @Test
    public void findTitle() {
        ArrayList<Worker> list = (ArrayList<Worker>) searchWorkers
                .findTitle("Программист Java",hrDepartment.getWorkers());
        for (Worker worker: list) {
            assertEquals("Программист Java",worker.getJobTitle());
        }
    }
}