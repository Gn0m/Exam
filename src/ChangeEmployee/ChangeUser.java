package ChangeEmployee;

import Departments.HRDepartment;
import Departments.ITDepartment;
import Display.DisplayInfo;
import Display.DisplayLists.DisplayLists;
import Display.UserData.DisplayEmployee;
import Display.UserData.DisplayUser;
import Model.Singleton.UserSingleton;
import Model.User;
import Model.Worker;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ChangeUser {

    private final DisplayUser displayUser;
    private final DisplayEmployee displayEmployee;
    private final DisplayInfo displayInfo;
    private final DisplayLists displayLists;

    public ChangeUser(DisplayUser displayUser, DisplayEmployee displayEmployee, DisplayInfo displayInfo,
                      DisplayLists displayLists) {
        this.displayUser = displayUser;
        this.displayEmployee = displayEmployee;
        this.displayInfo = displayInfo;
        this.displayLists = displayLists;
    }

    public void change(int index, Scanner sc, ITDepartment itDepartment,HRDepartment hrDepartment) {
        User user = itDepartment.get(index);
        while (true) {
            displayUser.choiceParam();
            displayInfo.display("12. Выход");
            int param = sc.nextInt();
            sc.nextLine();
            if (param == 1) {
                displayEmployee.secondName();
                user.setSecondName(sc.nextLine());
            }
            if (param == 2) {
                displayEmployee.firstName();
                user.setFirstName(sc.nextLine());
            }
            if (param == 3) {
                displayEmployee.thirdName();
                user.setThirdName(sc.nextLine());
            }
            if (param == 4) {
                displayEmployee.day();
                int day = sc.nextInt();
                displayEmployee.month();
                int month = sc.nextInt();
                displayEmployee.year();
                int year = sc.nextInt();
                Calendar birthday = new GregorianCalendar(year, month, day);
                user.setBirthday(birthday);
            }
            if (param == 5) {
                displayEmployee.gender();
                user.setGender(sc.nextLine());
            }
            if (param == 6) {
                displayEmployee.phone();
                user.setPhoneNumber(sc.nextLine());
            }
            if (param == 7) {
                displayUser.login();
                user.setLogin(sc.nextLine());
            }
            if (param == 8) {
                displayUser.password();
                user.setPassword(sc.nextLine());
            }
            if (param == 9) {
                displayUser.isAdmin();
                user.setAdmin(sc.nextBoolean());
            }
            if (param == 10) {
                displayUser.isHR();
                user.setHr(sc.nextBoolean());
            }
            if (param == 11) {
                displayLists.displayWorkers(hrDepartment.getWorkers());
                int indexWorker = sc.nextInt()-1;
                Worker worker = hrDepartment.get(indexWorker);
                setWorker(worker,itDepartment);
            }
            if (param == 12) {
                break;
            }
            itDepartment.update(index, user);
        }
    }

    private void setWorker(Worker worker, ITDepartment itDepartment) {
        if (worker != null) {
            int index = UserSingleton.getId();
            User user = itDepartment.get(index);
            user.setWorker(worker);
            displayInfo.display("Сотрудник изменен");
        }
    }
}
