package Reports;


import Model.Worker;
import Search.SearchWorkers;
import Search.TopWorkers;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class Reports {
    private SearchWorkers workers;
    private TopWorkers topWorkers;


    public Reports(SearchWorkers workers, TopWorkers topWorkers) {
        this.workers = workers;
        this.topWorkers = topWorkers;

    }

    public List<String> organizationInfo(List<Worker> workers) {
        List<String> list = new ArrayList<>();
        for (Worker worker : workers) {
            if (worker.isBoss()) {
                list.add("Отдел: " + worker.getDepartment() + " " + " Руководитель: " + worker.getFullName());
            }
        }
        return list;
    }

    public String avgSalaryOrg(List<Worker> workers) {
        int avg = 0;
        for (Worker worker : workers) {
            avg += worker.getSalary();
        }
        return "Средняя зарплата по организации: " + avg / workers.size();
    }

    public List<String> avgSalaryDepartment(List<Worker> workers) {
        List<String> list = new ArrayList<>();
        Set<String> set = new HashSet<>();
        int avg = 0;
        int count = 0;
        String department;
        for (Worker worker : workers) {
            set.add(worker.getDepartment());
        }
        System.out.println(set);
        for (String s : set) {
            for (Worker worker : workers) {
                if (worker.getDepartment().equals(s)) {
                    count++;
                    avg += worker.getSalary();
                }
            }
            avg = avg / count;
            list.add(s.concat(": ").concat(String.valueOf(avg)));
            count = 0;
        }
        return list;
    }

    public List<Worker> topSalaryWorkers(List<Worker> workers){
        return topWorkers.findTopExpensive(workers);
    }

    public List<Worker> topYearsWorkers(List<Worker> workers){
        return topWorkers.findTopDevotees(workers);
    }
}
