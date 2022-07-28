package Reports;


import Model.Worker;
import Search.TopWorkers;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.*;

@Getter
@Setter
public class Reports {

    private TopWorkers topWorkers;

    public Reports(TopWorkers topWorkers) {
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

    public List<String> topSalaryWorkers(List<Worker> workers) {
        ArrayList<Worker> list = (ArrayList<Worker>) topWorkers.findTopExpensive(workers);
        ArrayList<String> strings = new ArrayList<>();
        for (Worker worker : list) {
            strings.add(worker.toString() + " " + worker.getSalary());
        }
        return strings;
    }

    public List<String> topYearsWorkers(List<Worker> workers) {
        ArrayList<Worker> list = (ArrayList<Worker>) topWorkers.findTopDevotees(workers);
        ArrayList<String> strings = new ArrayList<>();
        for (Worker worker : list) {
            int years = LocalDate.now().getYear() - worker.getRecruitmentDate().getWeekYear();
            strings.add(worker.toString() + " ,общее время работы в компании ( год ): " + years);
        }
        return strings;
    }
}
