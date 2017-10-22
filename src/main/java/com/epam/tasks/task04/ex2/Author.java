package com.epam.tasks.task04.ex2;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Komarov Vasiliy on 13.10.2017.
 */
public class Author {
    private String name;
    private Calendar dateOfBirth;
    private Calendar dateOfDeath;
    private Sex sex;

    public Author(String name, Calendar dateOfBirth, Sex sex) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = null;
        this.sex = sex;
    }

    public Author(String name, Calendar dateOfBirth, Calendar dateOfDeath, Sex sex) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public Calendar getDateOfDeath() {
        return dateOfDeath;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge(){
        Calendar boundaryDate;
        if (getDateOfDeath() == null) {
            boundaryDate = new GregorianCalendar();
        }
        else boundaryDate = getDateOfDeath();
        int age = boundaryDate.get(Calendar.YEAR) - getDateOfBirth().get(Calendar.YEAR);
        if (boundaryDate.get(Calendar.DAY_OF_YEAR) <= getDateOfBirth().get(Calendar.DAY_OF_YEAR)){
            age--;
        }
        return age;
    }

    @Override
    public String toString() {
        return String.format("Name: %-10s age: %-3s sex: %-5s %s"
                , getName()
                , getAge()
                , getSex().toString().toLowerCase()
                , getDateOfDeath() == null ? "" : "dead");
    }
}
