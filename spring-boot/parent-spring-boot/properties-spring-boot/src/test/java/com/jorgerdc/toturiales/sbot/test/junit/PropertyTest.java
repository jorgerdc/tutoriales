/**
 * PropertyTest.java
 * Creation Date: 17/07/2018, 18:57:49
 *
 * Copyright (C) The Project *properties-spring-boot* Authors.
 *
 * This software was created for didactic and academic purposes.
 * It can be used and even modified by referring to the author
 * or project on GitHub. If the file is modified, add a note
 * after this paragraph saying that this file is a modified version.
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 */

package com.jorgerdc.toturiales.sbot.test.junit;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jorgerdc.tutoriales.sboot.Application;
import com.jorgerdc.tutoriales.sboot.bean.Person;
import com.jorgerdc.tutoriales.sboot.bean.Project;

/**
 * This test is used to validate property injection using spring boot.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Application.class })
public class PropertyTest {

	private static final Logger log = LoggerFactory.getLogger(PropertyTest.class);

	@Resource
	private Project project;

	@Value("${app.message}")
	private String appMessageLevel1;

	@Value("${app.level1}")
	private String appLevel1;

	@Value("${app.level2}")
	private String appLevel2;

	@Value("${app.level3}")
	private String appLevel3;

	@Value("${app.level4}")
	private String appLevel4;

	/**
	 * @throws MalformedURLException
	 */
	@Test
	public void checkProperties() throws MalformedURLException {
		Project expected;
		Person owner;

		log.debug("Checking project values: {}", project);

		expected = new Project();
		expected.setActive(true);
		expected.setName("Awesome project");
		owner = new Person();
		owner.setName("Super man");
		expected.setOwner(owner);
		expected.setProjectId(100L);
		expected.setUrl(new URL("http://www.project.com"));
		assertEquals(expected.toString(), project.toString());

	}

	/**
	 * The value of the appMessageLevel1 attribute should match with the
	 * /config/application.properties High precedence.
	 */
	@Test
	public void checkPropertyOverride() {
		assertEquals("I'm at config directory level 1", appMessageLevel1);
	}

	/**
	 * This property checks that all the properties values are injected. Every
	 * property is located in a different file.
	 */
	@Test
	public void checkPropertiesInOtherFiles() {
		assertEquals("level 1", appLevel1);
		assertEquals("level 2", appLevel2);
		assertEquals("level 3", appLevel3);
		assertEquals("level 4", appLevel4);
	}

}
