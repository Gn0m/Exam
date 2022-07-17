package Display;

import Interface.DisplayInterface;

public class DisplayInfo implements DisplayInterface {

    @Override
    public void mainMenu() {
        String [] menu = {"1. Создать нового пользователя","2. Авторизоваться","3. Восстановить пароль"};
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
}
