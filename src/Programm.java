import Display.DisplayInfo;
import Model.User;
import RegistrationAndAuth.Auth;
import RegistrationAndAuth.Recovery;
import RegistrationAndAuth.Registration;

import java.util.Date;
import java.util.Scanner;

class Programm {
    private DisplayInfo displayInfo;
    private Registration registration;
    private Recovery recovery;
    private Auth auth;
    private Scanner sc;
    private boolean authCheck;


    Programm(DisplayInfo displayInfo, Registration registration, Recovery recovery, Auth auth) {
        authCheck = false;
        this.displayInfo = displayInfo;
        this.registration = registration;
        this.recovery = recovery;
        this.auth = auth;
        sc = new Scanner(System.in);
    }

    void start() {
        mainMenu();
    }

    private void mainMenu() {

        while (!authCheck) {
            displayInfo.mainMenu();
            choise(sc.nextInt());
        }

    }

    private void choise(int choise) {
        if (checkMainMenu(choise)) {
            switchActions(choise);
        }
    }

    private boolean checkMainMenu(int number) {
        return number > 0 && number <= 3;
    }

    private void switchActions(int number) {
        sc.nextLine();
        if (number == 1){
            registration.registrationUser(createUser(sc));
        }

        if (number == 2){
            displayInfo.login();
            String login = sc.nextLine();
            displayInfo.password();
            String password = sc.nextLine();
            boolean check = auth.auth(login,password);
            displayInfo.authDone(check);
            if (check){
                authCheck = true;
            }
        }
        if (number == 3){
            displayInfo.login();
            String login = sc.nextLine();
            displayInfo.newPassword();
            String password = sc.nextLine();
            recovery.recovery(login,password);
        }
    }

    private User createUser(Scanner sc){
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
        Date birthday = new Date(year,month,day);
        sc.nextLine();
        displayInfo.gender();
        String gender = sc.nextLine();
        displayInfo.phone();
        String phone = sc.nextLine();
        displayInfo.login();
        String login = sc.nextLine();
        displayInfo.password();
        String pas = sc.nextLine();
        return new User(first,second,third,birthday,gender,phone,login,pas);
    }

}
