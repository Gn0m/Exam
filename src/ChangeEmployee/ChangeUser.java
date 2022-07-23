package ChangeEmployee;


import Departments.HRDepartment;
import Departments.ITDepartment;
import Display.DisplayInfo;
import Interface.ChangeUserInterface;
import Model.Singleton.UserSingleton;
import Model.User;
import Model.Worker;

public class ChangeUser implements ChangeUserInterface {

    private ITDepartment itDepartment;
    private HRDepartment hrDepartment;
    private DisplayInfo displayInfo;

    public ChangeUser(ITDepartment itDepartment, DisplayInfo displayInfo,HRDepartment hrDepartment) {
        this.itDepartment = itDepartment;
        this.displayInfo = displayInfo;
        this.hrDepartment = hrDepartment;
    }

    @Override
    public boolean changeLogin(String newLogin) {
        User user = itDepartment.getUsers().get(UserSingleton.getId());
        if (user != null) {
            user.setLogin(newLogin);
            itDepartment.update(UserSingleton.getId(),user);
            displayInfo.display("Логин изменен");
            return true;
        } else {
            displayInfo.display("Не найден пользователь!");
            return false;
        }
    }

    @Override
    public boolean changePassword(String newPassword) {
        User user = itDepartment.getUsers().get(UserSingleton.getId());
        if (user != null) {
            user.setPassword(newPassword);
            itDepartment.update(UserSingleton.getId(),user);
            displayInfo.display("Пароль изменен");
            return true;
        } else {
            displayInfo.display("Не найден пользователь!");
            return false;
        }
    }

    @Override
    public boolean changeAdmin(int id) {
        User user = itDepartment.getUser(id-1);
        if (user != null) {

            if (user.isAdmin()) {
                user.setAdmin(false);
                itDepartment.update(id-1,user);
                displayInfo.display("Признак убран");
            } else {
                user.setAdmin(true);
                displayInfo.display("Признак проставлен");
            }
            return true;
        } else {
            displayInfo.display("Не найден пользователь!");
            return false;
        }
    }

    @Override
    public boolean changeHr(int id) {
        User user = itDepartment.getUser(id-1);
        if (user != null) {

            if (user.isHr()) {
                user.setHr(false);
                itDepartment.update(id-1,user);
                displayInfo.display("Признак убран");
            } else {
                user.setHr(true);
                displayInfo.display("Признак проставлен");
            }
            return true;
        } else {
            displayInfo.display("Не найден пользователь!");
            return false;
        }
    }

    @Override
    public boolean setWorker(int id) {
        Worker worker = hrDepartment.getWorker(id-1);
        if (worker != null){
            int index = UserSingleton.getId();
            User user = itDepartment.getUser(index);
            user.setWorker(worker);
            displayInfo.display("Сотрудник изменен");
            return true;
        } else return false;
    }


}
