package RegistrationAndAuth;

import Departments.ITDepartment;


public class Recovery {

    public void recovery(String login, String newPassword, ITDepartment itDepartment) {
        boolean check = itDepartment.getUsers().stream().anyMatch(user -> user.getLogin().equals(login));
        if (check) {
            itDepartment.getUsers()
                    .stream().filter(user -> user.getLogin().equals(login))
                    .forEach(user -> user.setPassword(newPassword));
        }
    }
}
