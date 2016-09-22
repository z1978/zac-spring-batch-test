package com.zac.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.BaseMatcher.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@RunWith(SpringJUnit4ClassRunner.class)
public class JUnitSpringExample {

	@BeforeClass
	public static void setUp() {
		System.out.println("-----> SETUP <-----");
	}

	@Test
	public void testSampleService() {
		System.out.println("-----> SETUP <-----");
	}

	@Test
	public void testSampleServiceGetAccountDescription() {
		// Check if the return description has a 'Description:' string.

	}

	@Test
	public void testSampleServiceGetAccountCode() {
		// Check if the return description has a 'Code:' string.

	}

	@AfterClass
	public static void afterTest() {
		System.out.println("-----> DESTROY <-----");
	}
}
