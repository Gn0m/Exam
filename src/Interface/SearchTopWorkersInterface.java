package Interface;

import Model.Worker;

import java.util.List;

public interface SearchTopWorkersInterface {

    List<Worker> findTopExpensive(List<Worker> workers);

    List<Worker> findTopDevotees(List<Worker> workers);
}
