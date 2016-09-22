package com.zac.spring_batch;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Test {
	private static final Logger log = LoggerFactory.getLogger(Test.class);

	public static void main(String[] args) throws Exception {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		long startTime = System.currentTimeMillis();
		log.info("Start time = [" + dateFormat.format(new Date()) + "]");
		
		// run main
		SpringApplication.run(Test.class, args);
		
		log.info("End time = [" + dateFormat.format(new Date()) + "]");
		long endTime = System.currentTimeMillis();
		log.info("Program running time = [" + (endTime - startTime) + "]ms");
		log.info("Program running time = [" + (endTime - startTime) / 1000f + "]s");
		
		System.err.println("Game over !!!");
		log.info("Game over !!!");
		// 
		System.exit(0);
	}
}