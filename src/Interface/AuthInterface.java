package Interface;


import Departments.ITDepartment;

public interface AuthInterface {

    boolean auth(String login, String password, ITDepartment itDepartment);

}
