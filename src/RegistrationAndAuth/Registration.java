package RegistrationAndAuth;

import Departments.ITDepartment;
import Interface.RegistrationInterface;
import Model.User;

public class Registration implements RegistrationInterface {

    @Override
    public boolean registrationUser(User user,ITDepartment itDepartment) {
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
