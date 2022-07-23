package Interface;

import Departments.ITDepartment;
import Model.User;



public interface RegistrationInterface {

    boolean registrationUser(User user, ITDepartment itDepartment);

}
