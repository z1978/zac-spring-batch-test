package com.zac.spring_batch.batch;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zac.spring_batch.entity.people;

@Configuration
public class MyTestConfig {
	private static final Logger log = LoggerFactory.getLogger(MyTestConfig.class);
	private @Autowired @Qualifier("myTestStep") Step myTestStep;


	@Bean
	public Job myTestJob(JobBuilderFactory jobs) {
		return jobs.get("myTestJob")
				.incrementer(new RunIdIncrementer())
				.flow(myTestStep).end().build();
	}

	@Bean
	public Step myTestStep(StepBuilderFactory stepBuilderFactory,
			MyTestProcessor processor, MyTestReader reader, MyTestWriter writer) {
		return stepBuilderFactory.get("myTestStep").<people, people> chunk(10)
				.reader(reader).processor(processor).writer(writer)
				.build();
	}

}
