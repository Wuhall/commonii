package com.springboot.designpattern.filterpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Wuhall
 */
public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> male = new ArrayList<>();
        for (Person person : persons) {
            if (person.getGender().equalsIgnoreCase("MALE")) {
                male.add(person);
            }
        }
        return male;
    }
}
