package RegistrationAndAuth;

import Departments.ITDepartment;
import Model.User;

public class Registration {

    public boolean registrationUser(User user, ITDepartment itDepartment) {
        if (itDepartment.getUsers().stream()
                .anyMatch(object -> object.getLogin().equals(user.getLogin())
                        && object.getPassword().equals(user.getPassword()))) {
            System.out.println("Указанный логин или пароль заняты!");
            return false;
        } else {
            itDepartment.add(user);
            return true;
        }
    }


}
