package Interface;

import Departments.HRDepartment;
import Departments.ITDepartment;


public interface DisplayInterface {

    void mainMenu();

    void display(String string);

    void firstName();

    void secondName();

    void thirdName();


    void year();

    void month();

    void day();

    void login();

    void password();

    void gender();

    void phone();

    void authDone(boolean result);

    void newPassword();

    void userMenu();

    void displayWorkers(HRDepartment hrDepartment);

    void displayUsers(ITDepartment itDepartment);
}
