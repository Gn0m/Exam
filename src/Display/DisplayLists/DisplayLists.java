package Display.DisplayLists;


import Model.User;
import Model.Worker;

import java.util.List;

public class DisplayLists {

    public void displayWorkers(List<Worker> list) {
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(i+1+" "+list.get(i));
        }
        System.out.print("\n");
    }

    public void displayUsers(List<User> list) {
        for (int i = 0; i <list.size() ; i++) {
            System.out.println(i+1+" "+list.get(i));
        }
    }
}
