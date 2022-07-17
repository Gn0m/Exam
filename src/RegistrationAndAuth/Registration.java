package RegistrationAndAuth;

import Departments.ITDepartment;
import Interface.RegistrationInterface;
import Model.User;

import java.util.Date;

public class Registration implements RegistrationInterface {

    private ITDepartment itDepartment;

    public Registration(ITDepartment itDepartment) {
        this.itDepartment = itDepartment;
    }

    @Override
    public boolean registrationUser(User user) {
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
