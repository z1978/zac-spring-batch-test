package com.zac.spring_batch.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zac.spring_batch.entity.people;

@Configuration
@EnableBatchProcessing
public class MyTestConfig {
	private @Autowired @Qualifier("myTestStep") Step myTestStep;
	@Autowired
	public JobBuilderFactory jobBuilderFactory;

	@Autowired
	public StepBuilderFactory stepBuilderFactory;

	@Autowired
	public DataSource dataSource;

	@Bean
	public Job importUserJob() {
		return jobBuilderFactory.get("myTestJob")
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
