import ChangeEmployee.ChangeUser;
import Departments.HRDepartment;
import Departments.ITDepartment;
import Display.DisplayInfo;
import Display.DisplayLists.DisplayLists;
import Display.UserData.DisplayEmployeeData;
import Model.Singleton.UserSingleton;
import Model.User;
import RegistrationAndAuth.Auth;
import RegistrationAndAuth.Recovery;
import RegistrationAndAuth.Registration;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

class Programm {
    private boolean mainCheck;

    private Scanner sc;
    private boolean authCheck;
    private ITDepartment itDepartment;
    private HRDepartment hrDepartment;
    private ChangeUser changeUser;


    Programm(ITDepartment itDepartment, HRDepartment hrDepartment, ChangeUser changeUser) {
        authCheck = false;
        this.itDepartment = itDepartment;
        this.hrDepartment = hrDepartment;
        this.changeUser = changeUser;
        this.mainCheck = true;
        sc = new Scanner(System.in);
    }

    void start() {
        while (mainCheck) {
            mainMenu();

            userMenu();

        }


    }

    private void mainMenu() {

        while (!authCheck) {
            DisplayInfo.mainMenu();
            choiceMainMenu(sc.nextInt());
        }

    }

    private void choiceMainMenu(int choice) {
        if (checkMainMenu(choice)) {
            switchActionsMainMenu(choice);
        }
    }

    private boolean checkMainMenu(int number) {
        return number > 0 && number <= 4;
    }

    private void switchActionsMainMenu(int number) {
        sc.nextLine();
        if (number == 1) {
            Registration.registrationUser(createUser(sc), itDepartment);
        }

        if (number == 2) {
            DisplayEmployeeData.login();
            String login = sc.nextLine();
            DisplayEmployeeData.password();
            String password = sc.nextLine();
            boolean check = Auth.auth(login, password, itDepartment);
            DisplayEmployeeData.authDone(check);
            if (check) {
                authCheck = true;

            }
        }
        if (number == 3) {
            DisplayEmployeeData.login();
            String login = sc.nextLine();
            DisplayEmployeeData.newPassword();
            String password = sc.nextLine();
            Recovery.recovery(login, password, itDepartment);
        }
        if (number == 4) {
            authCheck = true;
            mainCheck = false;
        }
    }

    private User createUser(Scanner sc) {
        DisplayEmployeeData.secondName();
        String second = sc.nextLine();
        DisplayEmployeeData.firstName();
        String first = sc.nextLine();
        DisplayEmployeeData.thirdName();
        String third = sc.nextLine();
        DisplayEmployeeData.day();
        int day = sc.nextInt();
        DisplayEmployeeData.month();
        int month = sc.nextInt();
        DisplayEmployeeData.year();
        int year = sc.nextInt();
        Calendar birthday = new GregorianCalendar(year, month, day);
        sc.nextLine();
        DisplayEmployeeData.gender();
        String gender = sc.nextLine();
        DisplayEmployeeData.phone();
        String phone = sc.nextLine();
        DisplayEmployeeData.login();
        String login = sc.nextLine();
        DisplayEmployeeData.password();
        String pas = sc.nextLine();
        return new User(first, second, third, birthday, gender, phone, login, pas);
    }

    private void userMenu() {
        while (UserSingleton.isAuth()) {
            DisplayInfo.userMenu();
            choiceUserMenu(sc.nextInt());
        }
    }

    private void choiceUserMenu(int choice) {
        if (checkUserMenu(choice)) {
            switchActionsUserMenu(choice);
        }
    }

    private void switchActionsUserMenu(int number) {
        sc.nextLine();
        if (number == 1) {
            DisplayEmployeeData.login();
            changeUser.changeLogin(sc.nextLine());
        }
        if (number == 2) {
            DisplayEmployeeData.password();
            changeUser.changePassword(sc.nextLine());
        }
        if (number == 3) {
            DisplayLists.displayUsers(itDepartment);
            DisplayInfo.display("Введите номер сотрудника: ");
            int index = sc.nextInt();
            DisplayInfo.display("Выберите тип");
            while (true) {
                DisplayInfo.display("1. Администратор " + "\n" + "2. HR");
                int choice = sc.nextInt();
                if (choice == 1) {
                    changeUser.changeAdmin(index);
                    break;
                }
                if (choice == 2) {
                    changeUser.changeHr(index);
                    break;
                }
            }
        }
        if (number == 4) {
            DisplayLists.displayWorkers(hrDepartment);
            changeUser.setWorker(sc.nextInt());
        }
        if (number == 5) {
            authCheck = false;
            UserSingleton.setAuth(false);
            UserSingleton.setUser(null);
        }

    }

    private boolean checkUserMenu(int number) {
        return number > 0 && number <= 5;
    }
}
