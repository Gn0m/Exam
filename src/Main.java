import ChangeEmployee.ChangeUser;
import ChangeEmployee.ChangeWorker;
import Departments.HRDepartment;
import Departments.ITDepartment;
import Display.DisplayInfo;
import Display.DisplayLists.DisplayLists;
import Display.UserData.DisplayEmployee;
import Display.UserData.DisplayUser;
import Display.UserData.DisplayWorker;
import Model.Creator;
import RegistrationAndAuth.Auth;
import RegistrationAndAuth.Recovery;
import RegistrationAndAuth.Registration;
import Reports.Reports;
import Search.SearchWorkers;
import Search.TopWorkers;
import SerializeJackson.Serialize;
import javafx.scene.control.TextFormatter;

class Main {

    private static DisplayInfo displayInfo;
    private static DisplayEmployee displayEmployee;
    private static DisplayUser displayUser;
    private static DisplayWorker displayWorker;
    private static DisplayLists displayLists;
    private static ITDepartment itDepartment;
    private static HRDepartment hrDepartment;
    private static Reports reports;
    private static SearchWorkers searchWorkers;
    private static ChangeUser changeUser;
    private static ChangeWorker changeWorker;
    private static Serialize serialize;
    private static Auth auth;
    private static Recovery recovery;
    private static Registration registration;
    private static Creator creator;
    private static Launch launch;


    static {
        displayInfo = new DisplayInfo();
        displayEmployee = new DisplayEmployee();
        displayUser = new DisplayUser(displayEmployee);
        displayWorker = new DisplayWorker(displayEmployee);
        displayLists = new DisplayLists();

        itDepartment = new ITDepartment();
        hrDepartment = new HRDepartment();
        reports = new Reports(new TopWorkers());
        searchWorkers = new SearchWorkers();

        changeUser = new ChangeUser(displayUser, displayEmployee, displayInfo, displayLists);
        changeWorker = new ChangeWorker(displayWorker, displayEmployee, displayInfo);

        serialize = new Serialize();
        auth = new Auth();
        recovery = new Recovery();
        registration = new Registration();

        creator = new Creator(displayEmployee,displayUser,displayWorker,displayInfo);
        launch = new Launch(itDepartment, hrDepartment, reports, searchWorkers, changeWorker, changeUser, serialize,
                auth, recovery, registration, creator, displayWorker, displayUser, displayEmployee,
                displayLists, displayInfo);
    }

    public static void main(String[] args) {
        launch.start();
    }
}
