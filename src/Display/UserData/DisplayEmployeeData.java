package Display.UserData;

public class DisplayEmployeeData {

    public static void firstName() {
        System.out.println("Введите имя");
    }

    public static void secondName() {
        System.out.println("Введите фамилия");
    }

    public static void thirdName() {
        System.out.println("Введите отчество");
    }

    public static void year() {
        System.out.println("Введите год рождения");
    }

    public static void month() {
        System.out.println("Введите месяц рождения");
    }

    public static void day() {
        System.out.println("Введите день рождения");
    }

    public static void login() {
        System.out.println("Введите логин");
    }

    public static void password() {
        System.out.println("Введите пароль");
    }

    public static void gender() {
        System.out.println("Введите пол(м/ж)");
    }

    public static void phone() {
        System.out.println("Введите телефон");
    }

    public static void newPassword() {
        System.out.println("Введите новый пароль");
    }

    public static void authDone(boolean result) {
        if (result){
            System.out.println("Вы успешно авторизовались!");
        } else {
            System.out.println("Не верно указаны логин или пароль.");
        }
    }
}
