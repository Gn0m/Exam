package Model;

import Model.Abstract.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class User extends Employee {

    private String login;
    private String password;
    private boolean admin;
    private boolean hr;
    private Worker worker;

    public User(String firstName, String secondName, String thirdName, Date birthday, String gender, String phoneNumber,
                String login, String password, boolean admin, boolean hr) {
        super(firstName, secondName, thirdName, birthday, gender, phoneNumber);
        this.login = login;
        this.password = password;
        this.admin = admin;
        this.hr = hr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return admin == user.admin &&
                hr == user.hr &&
                login.equals(user.login) &&
                password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(login, password, admin, hr);
    }

    @Override
    public String toString() {
        return "Логин: " + login + " \n" +
                ", пароль: " + password + " \n" +
                worker.toString();

    }
}
