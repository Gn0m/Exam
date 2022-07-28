package Display.UserData;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DisplayUser {

    private DisplayEmployee displayEmployee;

    public DisplayUser(DisplayEmployee displayEmployee) {
        this.displayEmployee = displayEmployee;
    }

    public void login() {
        System.out.println("Введите логин");
    }

    public void password() {
        System.out.println("Введите пароль");
    }

    public void newPassword() {
        System.out.println("Введите новый пароль");
    }

    public void isAdmin(){
        System.out.println("Установить true, убрать false");
    }

    public void isHR(){
        System.out.println("Установить true, убрать false");
    }

    public void worker(){
        System.out.println("Выберите сотрудника");
    }

    public void choiceParam(){
        displayEmployee.params();
        String [] params = {"7. Логин","8. Пароль","9. Админ",
                "10. HR","11. Привязать сотрудника"};
        for (String s: params) {
            System.out.println(s);
        }
    }
}
