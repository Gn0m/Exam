import Departments.ITDepartment;
import Display.DisplayInfo;
import RegistrationAndAuth.Auth;
import RegistrationAndAuth.Recovery;
import RegistrationAndAuth.Registration;

public class Main {

    public static void main(String[] args) {
        ITDepartment department = new ITDepartment();
        Programm programm = new Programm(new DisplayInfo(),new Registration(department),new Recovery(department),
                new Auth(department));
        programm.start();
    }
}
