package com.springboot.designpattern.filterpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuhall
 */
public class CriteriaFemale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> female = new ArrayList<>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("FEMALE")) {
                female.add(person);
            }
        }
        return female;
    }
}
