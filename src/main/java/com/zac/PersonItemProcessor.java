package com.zac;


import org.springframework.batch.item.ItemProcessor;

import com.zac.spring_batch.entity.People;

public class PersonItemProcessor implements ItemProcessor<People, People> {

    @Override
    public People process(final People people) throws Exception {
        final String firstName = people.getFirst_name();
        final String lastName  = people.getLast_name();

//        final people transformedPerson = new people(firstName, lastName);

        return people;
    }

}
