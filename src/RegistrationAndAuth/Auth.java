package RegistrationAndAuth;

import Departments.ITDepartment;
import Interface.AuthInterface;

public class Auth implements AuthInterface {

    private ITDepartment itDepartment;

    public Auth(ITDepartment itDepartment) {
        this.itDepartment = itDepartment;
    }

    @Override
    public boolean auth(String login, String password) {
        return itDepartment.getUsers().stream()
                .anyMatch(user -> user.getLogin().equals(login) && user.getPassword().equals(password));
    }

}
