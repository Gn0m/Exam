package Model;

import Model.Abstract.Employee;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
@JsonAutoDetect
public class User extends Employee implements Serializable {

    private static final long serialVersionUID = 7141153244728040486L;
    private String login;
    private String password;
    private boolean admin;
    private boolean hr;
    private Worker worker;

    public User(String firstName, String secondName, String thirdName, Calendar birthday, String gender, String phoneNumber,
                String login, String password) {
        super(firstName, secondName, thirdName, birthday, gender, phoneNumber);
        this.login = login;
        this.password = password;
    }

    public User() {
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
        if (worker != null){
            return "Логин: " + login  + ", пароль: " + password + " \n" +
                    worker.toString();
        } else return "Логин: " + login + ", пароль: " + password;

    }
}
