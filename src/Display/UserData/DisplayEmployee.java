package Display.UserData;

public class DisplayEmployee {

    public void firstName() {
        System.out.println("Введите имя");
    }

    public void secondName() {
        System.out.println("Введите фамилия");
    }

    public void thirdName() {
        System.out.println("Введите отчество");
    }

    public void year() {
        System.out.println("Введите год");
    }

    public void month() {
        System.out.println("Введите месяц");
    }

    public void day() {
        System.out.println("Введите день");
    }

    public void gender() {
        System.out.println("Введите пол(м/ж)");
    }

    public void phone() {
        System.out.println("Введите телефон");
    }

    public void authDone(boolean result) {
        if (result){
            System.out.println("Вы успешно авторизовались!");
        } else {
            System.out.println("Не верно указаны логин или пароль.");
        }
    }

    void params(){
        String [] params = {"1. Фамилия","2. Имя","3. Отчество","4. День рождения","5. Пол(м/ж)","6. Номер телефона"};
        for (String s: params) {
            System.out.println(s);
        }
    }
}
