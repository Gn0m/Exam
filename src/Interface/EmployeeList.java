package Interface;

public interface EmployeeList<T> {

     void add(T employee);

     void delete(int id);

     void update(int id, T employee);

     T get(int id);
}
