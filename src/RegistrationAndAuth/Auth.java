package RegistrationAndAuth;


import Departments.ITDepartment;
import Interface.AuthInterface;
import Model.Singleton.UserSingleton;
import Model.User;



public class Auth implements AuthInterface {

    @Override
    public boolean auth(String login, String password,ITDepartment itDepartment) {
        User foundUser = itDepartment.getUsers().stream()
                .filter(user -> user.getLogin().equals(login) && user.getPassword().equals(password))
                .findFirst().orElse(null);
        if (foundUser != null){
            UserSingleton.setUser(foundUser);
            UserSingleton.setId(itDepartment.getUsers().indexOf(foundUser));
            UserSingleton.setAuth(true);
            return true;
        } else
            return false;
    }



}
