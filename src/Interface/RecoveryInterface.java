package Interface;

import Departments.ITDepartment;

public interface RecoveryInterface {

    boolean recovery(String login, String newPassword, ITDepartment itDepartment);
}
