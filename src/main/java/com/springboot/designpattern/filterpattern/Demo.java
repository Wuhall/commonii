package com.springboot.designpattern.filterpattern;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuhall
 */
public class Demo {
    @Test
    public void test() {
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Robert","Male", "Single"));
        persons.add(new Person("Laura","Female", "Married"));

        Criteria male = new CriteriaMale();
        Criteria female = new CriteriaFemale();

//        printPersons(male.meetCriteria(persons));
        printPersons(female.meetCriteria(persons));
    }

    public static void printPersons(List<Person> persons) {
        for (Person person : persons) {
            System.out.println("Person :[Name:]" + person.getName()
                    +", Gender : " + person.getGender()
                    +", Marital Status : " + person.getMaritalStatus()
                    +" ]");
        }
    }
}
