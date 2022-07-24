import ChangeEmployee.ChangeUser;
import Departments.HRDepartment;
import Departments.ITDepartment;
import Model.Worker;
import Reports.Reports;
import Search.SearchWorkers;
import Search.TopWorkers;
import SerializeJackson.Serialize;
import java.io.IOException;
import java.util.GregorianCalendar;


public class Main {

    public static void main(String[] args) {
        //тестовое
        ITDepartment itDepartment = new ITDepartment();
        HRDepartment hrDepartment = new HRDepartment();
        Reports reports = new Reports(new SearchWorkers(),new TopWorkers());
        hrDepartment.addWorker(new Worker("Леонид","Гущин","Петрович",
                new GregorianCalendar(1991,12,27),"м","8812843",
                "Программист","Разработки",100500,
                new GregorianCalendar(1991,11,27),false));
        hrDepartment.addWorker(new Worker("Людмила","Кучеренко","Александровна",
                new GregorianCalendar(1991,12,27),"м","8812843",
                "Программист","Разработки",100500,
                new GregorianCalendar(1991,11,27),false));

        Programm programm = new Programm(itDepartment,hrDepartment,new ChangeUser(itDepartment,hrDepartment));
        //тест
        try {
           hrDepartment.getWorkers().addAll(Serialize.parseJsonWorker("worker.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Serialize.serializeReportYears(reports.topYearsWorkers(hrDepartment.getWorkers()),"reports.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }


        // programm.start();
    }
}
