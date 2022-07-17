package Search;

import Interface.SearchTopWorkersInterface;
import Model.Worker;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TopWorkersInterface implements SearchTopWorkersInterface {

    private Comparator<Worker> comparatorExpensive = Comparator.comparingInt(Worker::getSalary);
    private Comparator<Worker> comparatorDevotees = Comparator.comparingInt(o -> o.getRecruitmentDate().get(Calendar.YEAR));


    @Override
    public List<Worker> findTopExpensive(List<Worker> workers) {
        return workers.stream().sorted(comparatorExpensive).limit(10).collect(Collectors.toList());
    }

    @Override
    public List<Worker> findTopDevotees(List<Worker> workers) {
        return workers.stream().sorted(comparatorDevotees).limit(10).collect(Collectors.toList());
    }
}
