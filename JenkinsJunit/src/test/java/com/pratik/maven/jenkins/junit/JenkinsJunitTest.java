package com.pratik.maven.jenkins.junit;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class JenkinsJunitTest {
	
	@Test
	public void getStatus() {
		JenkinsJunit ju = new JenkinsJunit();
		String output = ju.getValue();
		assertTrue(output.equalsIgnoreCase("Hello World"));
	}
	
	@Test
	public void getAnotherStatus() {
		JenkinsJunit ju = new JenkinsJunit();
		String output = ju.getValue();
		assertFalse(output.equalsIgnoreCase("Hi World"));
	}

}
