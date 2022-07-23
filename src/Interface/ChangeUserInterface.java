package Interface;

import Model.Worker;

public interface ChangeUserInterface {

    boolean changeLogin(String newLogin);

    boolean changePassword(String newPassword);

    boolean changeAdmin(int id);

    boolean changeHr(int id);

    boolean setWorker(int id);
}
