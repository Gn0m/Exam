import ChangeEmployee.ChangeUser;
import Departments.HRDepartment;
import Departments.ITDepartment;
import Display.DisplayInfo;
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
    private DisplayInfo displayInfo;
    private Registration registration;
    private Recovery recovery;
    private Auth auth;
    private Scanner sc;
    private boolean authCheck;
    private ITDepartment itDepartment;
    private HRDepartment hrDepartment;
    private ChangeUser changeUser;


    Programm(DisplayInfo displayInfo, Registration registration, Recovery recovery, Auth auth,
             ITDepartment itDepartment, HRDepartment hrDepartment, ChangeUser changeUser) {
        authCheck = false;
        this.displayInfo = displayInfo;
        this.registration = registration;
        this.recovery = recovery;
        this.auth = auth;
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
            displayInfo.mainMenu();
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
            registration.registrationUser(createUser(sc), itDepartment);
        }

        if (number == 2) {
            displayInfo.login();
            String login = sc.nextLine();
            displayInfo.password();
            String password = sc.nextLine();
            boolean check = auth.auth(login, password,itDepartment);
            displayInfo.authDone(check);
            if (check) {
                authCheck = true;

            }
        }
        if (number == 3) {
            displayInfo.login();
            String login = sc.nextLine();
            displayInfo.newPassword();
            String password = sc.nextLine();
            recovery.recovery(login, password, itDepartment);
        }
        if (number == 4) {
            authCheck = true;
            mainCheck = false;
        }
    }

    private User createUser(Scanner sc) {
        displayInfo.secondName();
        String second = sc.nextLine();
        displayInfo.firstName();
        String first = sc.nextLine();
        displayInfo.thirdName();
        String third = sc.nextLine();
        displayInfo.day();
        int day = sc.nextInt();
        displayInfo.month();
        int month = sc.nextInt();
        displayInfo.year();
        int year = sc.nextInt();
        Calendar birthday = new GregorianCalendar(year, month, day);
        sc.nextLine();
        displayInfo.gender();
        String gender = sc.nextLine();
        displayInfo.phone();
        String phone = sc.nextLine();
        displayInfo.login();
        String login = sc.nextLine();
        displayInfo.password();
        String pas = sc.nextLine();
        return new User(first, second, third, birthday, gender, phone, login, pas);
    }

    private void userMenu() {
        while (UserSingleton.isAuth()) {
            displayInfo.userMenu();
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
            displayInfo.login();
            changeUser.changeLogin(sc.nextLine());
        }
        if (number == 2) {
            displayInfo.password();
            changeUser.changePassword(sc.nextLine());
        }
        if (number == 3) {
            displayInfo.displayUsers(itDepartment);
            displayInfo.display("Введите номер сотрудника: ");
            int index = sc.nextInt();
            displayInfo.display("Выберите тип");
            while (true) {
                displayInfo.display("1. Администратор " + "\n" + "2. HR");
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
        displayInfo.displayWorkers(hrDepartment);
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
