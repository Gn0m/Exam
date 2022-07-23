package Model;

import Model.Abstract.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Getter
@Setter
public class Worker extends Employee {

    private String jobTitle;
    private String department;
    private int salary;
    private Calendar recruitmentDate;
    private boolean boss;

    public Worker(String firstName, String secondName, String thirdName, Calendar birthday, String gender, String phoneNumber,
                  String jobTitle, String department, int salary, Calendar recruitmentDate, boolean boss) {
        super(firstName, secondName, thirdName, birthday, gender, phoneNumber);
        this.jobTitle = jobTitle;
        this.department = department;
        this.salary = salary;
        this.recruitmentDate = recruitmentDate;
        this.boss = boss;
    }

    public Worker() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Worker worker = (Worker) o;
        return salary == worker.salary &&
                boss == worker.boss &&
                jobTitle.equals(worker.jobTitle) &&
                department.equals(worker.department) &&
                recruitmentDate.equals(worker.recruitmentDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jobTitle, department, salary, recruitmentDate, boss);
    }

    @Override
    public String toString() {
        return getSecondName() + " " + getFirstName() + " " + getThirdName() + " " + ", отдел: " + getDepartment()
                +  ", должность " + getJobTitle() + "\n" + ", зарплата: " + getSalary()
                + "\n" + ", дата приема на работу: " + recruitmentDate.getTime();
    }
}


