package Display;

public  class DisplayInfo {


    public static void mainMenu() {
        String [] menu = {"1. Создать нового пользователя","2. Авторизоваться","3. Восстановить пароль","4. Выход"};
        for (String s : menu) {
            System.out.println(s);
        }
    }

    public static void userMenu() {
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

    public static void display(String string) {
        System.out.println(string);
    }

}
