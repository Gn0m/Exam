package Display;

import Departments.HRDepartment;
import Departments.ITDepartment;
import Interface.DisplayInterface;

public  class DisplayInfo implements DisplayInterface {


    public void mainMenu() {
        String [] menu = {"1. Создать нового пользователя","2. Авторизоваться","3. Восстановить пароль","4. Выход"};
        for (String s : menu) {
            System.out.println(s);
        }
    }

    @Override
    public void display(String string) {
        System.out.println(string);
    }

    @Override
    public void firstName() {
        System.out.println("Введите имя");
    }

    @Override
    public void secondName() {
        System.out.println("Введите фамилия");
    }

    @Override
    public void thirdName() {
        System.out.println("Введите отчество");
    }

    @Override
    public void year() {
        System.out.println("Введите год рождения");
    }

    @Override
    public void month() {
        System.out.println("Введите месяц рождения");
    }

    @Override
    public void day() {
        System.out.println("Введите день рождения");
    }

    @Override
    public void login() {
        System.out.println("Введите логин");
    }

    @Override
    public void password() {
        System.out.println("Введите пароль");
    }

    @Override
    public void gender() {
        System.out.println("Введите пол(м/ж)");
    }

    @Override
    public void phone() {
        System.out.println("Введите телефон");
    }


    @Override
    public void authDone(boolean result) {
        if (result){
            System.out.println("Вы успешно авторизовались!");
        } else {
            System.out.println("Не верно указаны логин или пароль.");
        }
    }

    @Override
    public void newPassword() {
        System.out.println("Введите новый пароль");
    }

    @Override
    public void userMenu() {
        String [] menu = {"1. Изменить логин","2. Изменить пароль",
                "3. Изменить тип учётной записи","4. Привязать другого сотрудника","5. Выход",
                "6. Добавить пользователя","7. Добавить сотрудника",
                "8. Удалить пользователя","9. Удалить сотрудника","10. Изменить информацию о пользователе",
                "11. Изменить информацию о сотруднике"
        };
        for (String s : menu) {
            System.out.println(s);
        }
    }

    @Override
    public void displayWorkers(HRDepartment hrDepartment) {
        for (int i = 0; i <hrDepartment.getWorkers().size() ; i++) {
            System.out.println(i+1+" "+hrDepartment.getWorker(i));
        }
    }

    @Override
    public void displayUsers(ITDepartment itDepartment) {
        for (int i = 0; i <itDepartment.getUsers().size() ; i++) {
            System.out.println(i+1+" "+itDepartment.getUser(i));
        }
    }
}
