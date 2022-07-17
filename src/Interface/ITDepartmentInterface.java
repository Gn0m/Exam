package Interface;

import Model.Abstract.Employee;
import Model.User;

public interface ITDepartmentInterface {

    void add(User user);

    void delete(int id);

    void update(int id,User user);

    User getUser(int id);

}
