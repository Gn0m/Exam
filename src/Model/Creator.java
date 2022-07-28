package Model;

import Display.DisplayInfo;
import Display.UserData.DisplayEmployee;
import Display.UserData.DisplayUser;
import Display.UserData.DisplayWorker;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class Creator {

    private final DisplayEmployee displayEmployee;
    private final DisplayUser displayUser;
    private final DisplayWorker displayWorker;
    private final DisplayInfo displayInfo;

    public Creator(DisplayEmployee displayEmployee, DisplayUser displayUser, DisplayWorker displayWorker, DisplayInfo displayInfo) {
        this.displayEmployee = displayEmployee;
        this.displayUser = displayUser;
        this.displayWorker = displayWorker;
        this.displayInfo = displayInfo;
    }

    public User createUser(Scanner sc) {
        displayEmployee.secondName();
        String second = sc.nextLine();
        displayEmployee.firstName();
        String first = sc.nextLine();
        displayEmployee.thirdName();
        String third = sc.nextLine();
        displayEmployee.day();
        int day = sc.nextInt();
        displayEmployee.month();
        int month = sc.nextInt();
        displayEmployee.year();
        int year = sc.nextInt();
        Calendar birthday = new GregorianCalendar(year, month, day);
        sc.nextLine();
        displayEmployee.gender();
        String gender = sc.nextLine();
        displayEmployee.phone();
        String phone = sc.nextLine();
        displayUser.login();
        String login = sc.nextLine();
        displayUser.password();
        String pas = sc.nextLine();
        return new User(first, second, third, birthday, gender, phone, login, pas);
    }


    public Worker createWorker(Scanner sc) {
        displayEmployee.secondName();
        String second = sc.nextLine();
        displayEmployee.firstName();
        String first = sc.nextLine();
        displayEmployee.thirdName();
        String third = sc.nextLine();
        displayEmployee.day();
        int day = sc.nextInt();
        displayEmployee.month();
        int month = sc.nextInt();
        displayEmployee.year();
        int year = sc.nextInt();
        Calendar birthday = new GregorianCalendar(year, month, day);
        sc.nextLine();
        displayEmployee.gender();
        String gender = sc.nextLine();
        displayEmployee.phone();
        String phone = sc.nextLine();
        displayWorker.jobTitle();
        String title = sc.nextLine();
        displayWorker.department();
        String department = sc.nextLine();
        displayWorker.salary();
        int salary = sc.nextInt();
        displayInfo.display("Укажите дату приема на работу:");
        displayEmployee.day();
        int dayReception = sc.nextInt();
        displayEmployee.month();
        int monthReception = sc.nextInt();
        displayEmployee.year();
        int yearReception = sc.nextInt();
        Calendar recruitmentDate = new GregorianCalendar(dayReception, monthReception, yearReception);
        sc.nextLine();
        displayInfo.display("Укажите является ли начальником");
        boolean boss = sc.nextBoolean();

        return new Worker(first, second, third, birthday, gender, phone, title, department, salary, recruitmentDate, boss);
    }

}
