package com.studs.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(classes = {DemoApplication.class, TestConfig.class})
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
}
