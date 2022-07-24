package Search;


import Model.Worker;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TopWorkers {

    private Comparator<Worker> comparatorExpensive = (o1, o2) -> o2.getSalary() - o1.getSalary();
    private Comparator<Worker> comparatorDevotees = Comparator.comparingInt(o -> o.getRecruitmentDate().get(Calendar.YEAR));


    public List<Worker> findTopExpensive(List<Worker> workers) {
        return workers.stream().sorted(comparatorExpensive).limit(10).collect(Collectors.toList());
    }


    public List<Worker> findTopDevotees(List<Worker> workers) {
        return workers.stream().sorted(comparatorDevotees).limit(10).collect(Collectors.toList());
    }
}
