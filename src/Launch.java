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
import Model.Singleton.UserSingleton;
import Model.Worker;
import RegistrationAndAuth.Auth;
import RegistrationAndAuth.Recovery;
import RegistrationAndAuth.Registration;
import Reports.Reports;
import Search.SearchWorkers;
import SerializeJackson.Serialize;
import lombok.SneakyThrows;

import java.io.File;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

class Launch {
    private boolean mainCheck;

    private final Scanner sc;
    private boolean authCheck;
    private final ITDepartment itDepartment;
    private final HRDepartment hrDepartment;
    private final Reports reports;
    private final SearchWorkers searchWorkers;
    private final ChangeWorker changeWorker;
    private final ChangeUser changeUser;
    private final Serialize serialize;
    private final Auth auth;
    private final Recovery recovery;
    private final Registration registration;
    private final Creator creator;

    private final DisplayWorker displayWorker;
    private final DisplayUser displayUser;
    private final DisplayEmployee displayEmployee;
    private final DisplayLists displayLists;
    private final DisplayInfo displayInfo;

    Launch(ITDepartment itDepartment, HRDepartment hrDepartment, Reports reports, SearchWorkers searchWorkers,
           ChangeWorker changeWorker, ChangeUser changeUser, Serialize serialize, Auth auth, Recovery recovery,
           Registration registration, Creator creator,
           DisplayWorker displayWorker, DisplayUser displayUser, DisplayEmployee displayEmployee,
           DisplayLists displayLists, DisplayInfo displayInfo) {
        this.searchWorkers = searchWorkers;
        this.changeWorker = changeWorker;
        this.changeUser = changeUser;
        this.serialize = serialize;
        this.auth = auth;
        this.recovery = recovery;
        this.registration = registration;
        this.creator = creator;
        this.itDepartment = itDepartment;
        this.hrDepartment = hrDepartment;
        this.mainCheck = true;
        this.reports = reports;

        this.displayWorker = displayWorker;
        this.displayUser = displayUser;
        this.displayEmployee = displayEmployee;
        this.displayLists = displayLists;
        this.displayInfo = displayInfo;
        sc = new Scanner(System.in);
        authCheck = false;
    }

    @SneakyThrows
    void start() {
        loadConfig();
        while (mainCheck) {
            try {
                mainMenu();

                userMenu();
            } catch (InputMismatchException exception) {
                System.out.println("----Не верный ввод!----");
                sc.next();
            } catch (IndexOutOfBoundsException exception) {
                System.out.println("----Выбрано не верное значение!----");
            }
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
            registration.registrationUser(creator.createUser(sc), itDepartment);
        }

        if (number == 2) {
            displayUser.login();
            String login = sc.nextLine();
            displayUser.password();
            String password = sc.nextLine();
            boolean check = auth.auth(login, password, itDepartment);
            displayEmployee.authDone(check);
            if (check) {
                authCheck = true;
            }
        }
        if (number == 3) {
            displayUser.login();
            String login = sc.nextLine();
            displayUser.newPassword();
            String password = sc.nextLine();
            recovery.recovery(login, password, itDepartment);
        }
        if (number == 4) {
            saveConfig();
            authCheck = true;
            mainCheck = false;
        }
    }

    private void userMenu() {
        int type = 0;
        while (UserSingleton.isAuth()) {
            if (UserSingleton.getUser().isAdmin()) {
                displayInfo.userMenu(8);
                displayInfo.display("9. Выход");
            } else if (UserSingleton.getUser().isHr()) {
                displayInfo.userMenu(5);
                displayInfo.display("6. Выход");
                type = 1;
            } else {
                displayInfo.userMenu(2);
                displayInfo.display("3. Выход");
                type = 2;
            }
            choiceUserMenu(sc.nextInt(), type);
        }
    }

    private void choiceUserMenu(int choice, int type) {
        if (checkUserMenu(choice)) {
            switchActionsUserMenu(choice, type);
        }
    }

    private void switchActionsUserMenu(int number, int type) {
        boolean active = true;
        if (number == 9 || (number == 6 && type == 1) || (number == 3 && type == 2)) {
            active = false;
        } else if (number == 3) {
            itDepartment.add(creator.createUser(sc));
        } else if (number == 6) {
            displayLists.displayWorkers(hrDepartment.getWorkers());
            int index = sc.nextInt() - 1;
            hrDepartment.delete(index);
        }

        if (number == 1) {
            ArrayList<Worker> list = (ArrayList<Worker>) findWorker();
            displayInfo.display("Выберите действие:");
            displayInfo.display("1. Вывести на экран результаты " + "\n" + "2. Выгрузить в файл");
            int action = sc.nextInt();
            actionReportOutputWorker(action, list);
        }
        if (number == 2) {
            displayInfo.display("Выберите отчёт:");
            displayInfo.display("1. Cтруктура организации"
                    + "\n" + "2. Средняя зарплата по организации"
                    + "\n" + "3. Средняя зарплата по отделам"
                    + "\n" + "4. ТОП-10 самых дорогих сотрудников по зарплате"
                    + "\n" + "5. ТОП-10 самых преданных сотрудников по количеству лет работы в организации");
            int action = sc.nextInt();

            actionReport(action, hrDepartment.getWorkers(), reports);
        }

        if (number == 4) {
            hrDepartment.add(creator.createWorker(sc));
        }

        if (number == 5) {
            displayLists.displayUsers(itDepartment.getUsers());
            int index = sc.nextInt() - 1;
            itDepartment.delete(index);
        }

        if (number == 7) {
            displayLists.displayWorkers(hrDepartment.getWorkers());
            int index = sc.nextInt() - 1;
            changeWorker.change(index, sc, hrDepartment);
        }

        if (number == 8) {
            displayLists.displayUsers(itDepartment.getUsers());
            int index = sc.nextInt() - 1;
            changeUser.change(index, sc, itDepartment, hrDepartment);
        }

        if (!active) {
            authCheck = false;
            UserSingleton.setAuth(false);
            UserSingleton.setUser(null);
        }
    }

    private boolean checkUserMenu(int number) {
        return number > 0 && number <= 9;
    }

    private List<Worker> findWorker() {
        List<Worker> list = new ArrayList<>();
        displayInfo.selectSearchOption();
        int choice = sc.nextInt();
        sc.nextLine();
        if (choice == 1) {
            displayEmployee.secondName();
            String second = sc.nextLine();
            displayEmployee.firstName();
            String first = sc.nextLine();
            displayEmployee.thirdName();
            String third = sc.nextLine();
            list = searchWorkers.find(first, second, third, hrDepartment.getWorkers());
        }
        if (choice == 2) {
            displayWorker.jobTitle();
            String title = sc.nextLine();
            list = searchWorkers.findTitle(title, hrDepartment.getWorkers());
        }
        if (choice == 3) {
            displayWorker.department();
            String department = sc.nextLine();
            list = searchWorkers.findDepartment(department, hrDepartment.getWorkers());
        }

        if (choice == 4) {
            displayEmployee.secondName();
            String second = sc.nextLine();
            displayEmployee.firstName();
            String first = sc.nextLine();
            displayEmployee.thirdName();
            String third = sc.nextLine();
            list = searchWorkers.findBoss(first, second, third, hrDepartment.getWorkers());
        }
        return list;
    }

    @SneakyThrows
    private void actionReportOutputWorker(int action, List<Worker> list) {
        if (action == 1) {
            if (list.size() == 1) {
                int index = hrDepartment.getWorkers().indexOf(list.get(0));
                displayInfo.display(index + " " + list.get(0).toString());
            } else {
                for (Worker worker : list) {
                    for (int j = 0; j < hrDepartment.getWorkers().size(); j++) {
                        if (hrDepartment.getWorkers().get(j).equals(worker)) {
                            displayInfo.display(j + " " + worker.toString());
                            break;
                        }
                    }
                }
            }
        }
        if (action == 2) {
            sc.nextLine();
            displayInfo.display("Укажите наименование файла");
            String path = sc.nextLine();
            ArrayList<String> strings = new ArrayList<>();
            for (Worker worker : list) {
                for (int j = 0; j < hrDepartment.getWorkers().size(); j++) {
                    if (hrDepartment.getWorkers().get(j).equals(worker)) {
                        strings.add(j + " " + worker.toString());
                        break;
                    }
                }
            }
            serialize.serializeReport(strings, path);
        }
    }

    @SneakyThrows
    private void actionReportOutputString(int action, List<String> list) {
        if (action == 1) {
            for (String s : list) {
                displayInfo.display(s);
            }
        }
        if (action == 2) {
            sc.nextLine();
            displayInfo.display("Укажите наименование файла");
            String path = sc.nextLine();
            serialize.serializeReport(list, path);
        }
    }

    private void actionReport(int action, List<Worker> workers, Reports reports) {
        ArrayList<String> list;
        if (action == 1) {
            list = (ArrayList<String>) reports.organizationInfo(workers);
            displayInfo.display("1. Вывести на экран результаты " + "\n" + "2. Выгрузить в файл");
            int output = sc.nextInt();
            actionReportOutputString(output, list);
        }
        if (action == 2) {
            String avg = reports.avgSalaryOrg(workers);
            displayInfo.display("1. Вывести на экран результаты " + "\n" + "2. Выгрузить в файл");
            int output = sc.nextInt();
            actionReportOutputString(output, avg);
        }

        if (action == 3) {
            list = (ArrayList<String>) reports.avgSalaryDepartment(workers);
            displayInfo.display("1. Вывести на экран результаты " + "\n" + "2. Выгрузить в файл");
            int output = sc.nextInt();
            actionReportOutputString(output, list);
        }

        if (action == 4) {
            list = (ArrayList<String>) reports.topSalaryWorkers(workers);
            displayInfo.display("1. Вывести на экран результаты " + "\n" + "2. Выгрузить в файл");
            int output = sc.nextInt();
            actionReportOutputString(output, list);
        }

        if (action == 5) {
            list = (ArrayList<String>) reports.topYearsWorkers(workers);
            displayInfo.display("1. Вывести на экран результаты " + "\n" + "2. Выгрузить в файл");
            int output = sc.nextInt();
            actionReportOutputString(output, list);
        }
    }

    @SneakyThrows
    private void actionReportOutputString(int action, String string) {
        if (action == 1) {
            displayInfo.display(string);
        }
        if (action == 2) {
            sc.nextLine();
            displayInfo.display("Укажите наименование файла");
            String path = sc.nextLine();
            serialize.serializeReport(string, path);

        }
    }

    private void loadConfig() {
        File user = new File("userConfig.json");
        File worker = new File("workerConfig.json");
        if (user.exists() && worker.exists()) {
            itDepartment.getUsers().addAll(serialize.deserializeUsers("userConfig.json"));
            hrDepartment.getWorkers().addAll(serialize.deserializeWorkers("workerConfig.json"));
        } else {
            itDepartment.getUsers().addAll(serialize.deserializeUsers("user.json"));
            hrDepartment.getWorkers().addAll(serialize.deserializeWorkers("worker.json"));
        }
    }

    private void saveConfig() {
        serialize.serializeUsers(itDepartment.getUsers(), "userConfig.json");
        serialize.serializeWorkers(hrDepartment.getWorkers(), "workerConfig.json");

    }
}
