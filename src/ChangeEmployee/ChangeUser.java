package ChangeEmployee;


import Departments.HRDepartment;
import Departments.ITDepartment;
import Display.DisplayInfo;
import Model.Singleton.UserSingleton;
import Model.User;
import Model.Worker;

public class ChangeUser  {

    private ITDepartment itDepartment;
    private HRDepartment hrDepartment;

    public ChangeUser(ITDepartment itDepartment, HRDepartment hrDepartment) {
        this.itDepartment = itDepartment;
        this.hrDepartment = hrDepartment;
    }

    public boolean changeLogin(String newLogin) {
        User user = itDepartment.getUsers().get(UserSingleton.getId());
        if (user != null) {
            user.setLogin(newLogin);
            itDepartment.update(UserSingleton.getId(),user);
            DisplayInfo.display("Логин изменен");
            return true;
        } else {
            DisplayInfo.display("Не найден пользователь!");
            return false;
        }
    }

    public boolean changePassword(String newPassword) {
        User user = itDepartment.getUsers().get(UserSingleton.getId());
        if (user != null) {
            user.setPassword(newPassword);
            itDepartment.update(UserSingleton.getId(),user);
            DisplayInfo.display("Пароль изменен");
            return true;
        } else {
            DisplayInfo.display("Не найден пользователь!");
            return false;
        }
    }

    public boolean changeAdmin(int id) {
        User user = itDepartment.getUser(id-1);
        if (user != null) {

            if (user.isAdmin()) {
                user.setAdmin(false);
                itDepartment.update(id-1,user);
                DisplayInfo.display("Признак убран");
            } else {
                user.setAdmin(true);
                DisplayInfo.display("Признак проставлен");
            }
            return true;
        } else {
            DisplayInfo.display("Не найден пользователь!");
            return false;
        }
    }

    public boolean changeHr(int id) {
        User user = itDepartment.getUser(id-1);
        if (user != null) {

            if (user.isHr()) {
                user.setHr(false);
                itDepartment.update(id-1,user);
                DisplayInfo.display("Признак убран");
            } else {
                user.setHr(true);
                DisplayInfo.display("Признак проставлен");
            }
            return true;
        } else {
            DisplayInfo.display("Не найден пользователь!");
            return false;
        }
    }

    public boolean setWorker(int id) {
        Worker worker = hrDepartment.getWorker(id-1);
        if (worker != null){
            int index = UserSingleton.getId();
            User user = itDepartment.getUser(index);
            user.setWorker(worker);
            DisplayInfo.display("Сотрудник изменен");
            return true;
        } else return false;
    }


}
