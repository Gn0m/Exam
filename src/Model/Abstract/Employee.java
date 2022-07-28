package Model.Abstract;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.Calendar;

@Getter
@Setter
public abstract class Employee {

    @Getter
    private String firstName;
    private String secondName;
    private String thirdName;
    private Calendar birthday;
    private String gender;
    private String phoneNumber;

    protected Employee() {
    }

    protected Employee(String firstName, String secondName, String thirdName, Calendar birthday, String gender, String phoneNumber) {
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
    @JsonIgnore
    public String getFullName(){
        return secondName.concat(" ").concat(firstName).concat(" ").concat(thirdName);
    }
}
