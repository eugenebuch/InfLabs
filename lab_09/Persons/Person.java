package Persons;

import java.util.Calendar;

public class Person {
    private String lastname;
    private String firstname;
    private String middlename;
    private Calendar birthday;
    public void setLastname(String ln) {
        this.lastname=ln;
    }
    public void setFirstname(String ln) {
        this.firstname=ln;
    }
    public void setMiddlename(String ln) {
        this.middlename=ln;
    }
    public void setBirthday(Calendar ln) {
        this.birthday=ln;
    }
    public String getLastname() {
        return lastname;
    }
    public String getFirstname() {
        return firstname;
    }
    public String getMiddlename() {
        return middlename;
    }
    public Calendar getBirthday() {
        return birthday;
    }
    public String getFIO() {
        return (getLastname() + " " + String.valueOf(getFirstname().charAt(0))+
                "."+String.valueOf(getMiddlename().charAt(0))+".");
    }
    public static void main(String[] args) {
        Person guy1 = new Person();
        guy1.setLastname("Petrov");
        guy1.setFirstname("Ivan");
        guy1.setMiddlename("Vladimirovich");
        System.out.println(guy1.getFIO());
    }
}
/* copyright BuchEE */