package RegistrationAndAuth;

import Departments.ITDepartment;
import Interface.RecoveryInterface;

public class Recovery implements RecoveryInterface {
    private ITDepartment itDepartment;

    public Recovery(ITDepartment itDepartment) {
        this.itDepartment = itDepartment;
    }

    @Override
    public boolean recovery(String login, String newPassword) {
        boolean check = itDepartment.getUsers().stream().anyMatch(user -> user.getLogin().equals(login));
        if (check) {
            itDepartment.getUsers()
                    .stream().filter(user -> user.getLogin().equals(login))
                    .forEach(user -> user.setPassword(newPassword));
            return true;
        } else {
            return false;
        }
    }
}
