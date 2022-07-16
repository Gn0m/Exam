package Model.Abstract;


import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public abstract class Employee {

    @Getter
    private String firstName;
    private String secondName;
    private String thirdName;
    private Date birthday;
    private String gender;
    private String phoneNumber;

    public Employee(String firstName, String secondName, String thirdName, Date birthday, String gender, String phoneNumber) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.birthday = birthday;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return firstName + " " + secondName +
                " " + thirdName;
    }

    public String getFullName(){
        return firstName.concat("").concat(secondName).concat(" ").concat(thirdName);
    }
}
