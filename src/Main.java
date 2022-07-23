import ChangeEmployee.ChangeUser;
import Departments.HRDepartment;
import Departments.ITDepartment;
import Display.DisplayInfo;
import Model.User;
import Model.Worker;
import RegistrationAndAuth.Auth;
import RegistrationAndAuth.Recovery;
import RegistrationAndAuth.Registration;
import SerializeJackson.UsersSerialize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.GregorianCalendar;


public class Main {

    public static void main(String[] args) {
        //тестовое
        ITDepartment itDepartment = new ITDepartment();
        DisplayInfo displayInfo = new DisplayInfo();
        Registration registration = new Registration();
        Recovery recovery = new Recovery();
        Auth auth = new Auth();
        HRDepartment hrDepartment = new HRDepartment();
        hrDepartment.addWorker(new Worker("Леонид","Гущин","Петрович",
                new GregorianCalendar(1991,12,27),"м","8812843",
                "Программист","Разработки",100500,
                new GregorianCalendar(1991,11,27),false));

        Programm programm = new Programm(displayInfo,registration,recovery,
                auth,itDepartment,hrDepartment,new ChangeUser(itDepartment,displayInfo,hrDepartment));
        //тест
        UsersSerialize.Serialize(itDepartment.getUsers());
        UsersSerialize.Deserialize();

        try {
            ArrayList<Worker> list = (ArrayList<Worker>) UsersSerialize.parseJsonWorker();
            hrDepartment.getWorkers().addAll(list);
        } catch (IOException e) {
            e.printStackTrace();
        }

        programm.start();
    }
}
