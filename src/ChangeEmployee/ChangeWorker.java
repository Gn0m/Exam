package ChangeEmployee;


import Departments.HRDepartment;
import Display.DisplayInfo;
import Display.UserData.DisplayEmployee;
import Display.UserData.DisplayWorker;
import Model.Worker;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class ChangeWorker {
    private final DisplayWorker displayWorker;
    private final DisplayEmployee displayEmployee;
    private final DisplayInfo displayInfo;

    public ChangeWorker(DisplayWorker displayWorker, DisplayEmployee displayEmployee, DisplayInfo displayInfo) {
        this.displayWorker = displayWorker;
        this.displayEmployee = displayEmployee;
        this.displayInfo = displayInfo;
    }

    public void change(int index, Scanner sc, HRDepartment hrDepartment) {
        Worker worker = hrDepartment.get(index);
        while (true) {
            displayWorker.choiceParam();
            displayInfo.display("12. Выход");
            int param = sc.nextInt();
            sc.nextLine();
            if (param == 1) {
                displayEmployee.secondName();
                worker.setSecondName(sc.nextLine());
            }
            if (param == 2) {
                displayEmployee.firstName();
                worker.setFirstName(sc.nextLine());
            }
            if (param == 3) {
                displayEmployee.thirdName();
                worker.setThirdName(sc.nextLine());
            }

            if (param == 4) {
                displayEmployee.day();
                int day = sc.nextInt();
                displayEmployee.month();
                int month = sc.nextInt();
                displayEmployee.year();
                int year = sc.nextInt();
                Calendar birthday = new GregorianCalendar(year, month, day);
                worker.setBirthday(birthday);
            }
            if (param == 5) {
                displayEmployee.gender();
                worker.setGender(sc.nextLine());
            }

            if (param == 6) {
                displayEmployee.phone();
                worker.setPhoneNumber(sc.nextLine());
            }

            if (param == 7) {
                displayWorker.jobTitle();
                worker.setJobTitle(sc.nextLine());
            }
            if (param == 8) {
                displayWorker.department();
                worker.setDepartment(sc.nextLine());
            }

            if (param == 9) {
                displayWorker.salary();
                worker.setSalary(sc.nextInt());
            }
            if (param == 10) {
                displayEmployee.day();
                int day = sc.nextInt();
                displayEmployee.month();
                int month = sc.nextInt();
                displayEmployee.year();
                int year = sc.nextInt();
                Calendar recruitmentDate = new GregorianCalendar(year, month, day);
                worker.setRecruitmentDate(recruitmentDate);
            }

            if (param == 11) {
                displayInfo.display("true -> сотрудник является начальником false -> не является");
                worker.setBoss(sc.nextBoolean());
            }

            if (param == 12) {
                break;
            }
            hrDepartment.update(index, worker);
        }
    }


}
