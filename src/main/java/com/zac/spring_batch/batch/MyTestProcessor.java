package com.zac.spring_batch.batch;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.zac.spring_batch.entity.people;

public class MyTestProcessor implements ItemProcessor<people, people> {
	private static final Logger log = LoggerFactory.getLogger(MyTestProcessor.class);
    @Override
    public people process(final people person) throws Exception {
        final String firstName = person.getFirst_name();
        final String lastName  = person.getLast_name();
        log.debug(firstName + lastName);

        return person;
    }

}
