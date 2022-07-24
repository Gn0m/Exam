package Display.DisplayLists;

import Departments.HRDepartment;
import Departments.ITDepartment;

public class DisplayLists {

    public static void displayWorkers(HRDepartment hrDepartment) {
        for (int i = 0; i <hrDepartment.getWorkers().size() ; i++) {
            System.out.println(i+1+" "+hrDepartment.getWorker(i));
        }
    }

    public static void displayUsers(ITDepartment itDepartment) {
        for (int i = 0; i <itDepartment.getUsers().size() ; i++) {
            System.out.println(i+1+" "+itDepartment.getUser(i));
        }
    }
}
