package RegistrationAndAuth;

import Departments.ITDepartment;
import Model.User;

public class Registration  {

    public static boolean registrationUser(User user,ITDepartment itDepartment) {
        if (itDepartment.getUsers().stream()
                .anyMatch(object -> object.getLogin().equals(user.getLogin())
                        && object.getPassword().equals(user.getPassword()))){
            return false;
        } else {
            itDepartment.add(user);
            return true;
        }
    }



}
