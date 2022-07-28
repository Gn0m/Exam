package Display;

public class DisplayInfo {


    public void mainMenu() {
        String[] menu = {"1. Создать нового пользователя", "2. Авторизоваться", "3. Восстановить пароль", "4. Выход"};
        for (String s : menu) {
            System.out.println(s);
        }
    }

    public void userMenu(int count) {
        String[] menu = {"1. Найти сотрудника", "2. Сформировать отчёт",
                 "3. Добавить сотрудника","4. Изменить информацию о сотруднике","5. Удалить сотрудника",
                "6. Добавить пользователя","7. Изменить информацию о пользователе","8. Удалить пользователя"};
        for (int i = 0; i < count; i++) {
            System.out.println(menu[i]);
        }
    }

    public void display(String string) {
        System.out.println(string);
    }

    public void selectSearchOption() {
        String[] options = {"1. ПО ФИО", "2. Должности", "3. Название отдела", "4. ФИО начальника"};
        System.out.println("Выберите вариант поиска");
        for (String s : options) {
            System.out.println(s);
        }
    }

}
