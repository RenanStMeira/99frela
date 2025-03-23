package com.studs.demo;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@TestConfiguration
public class TestConfig {

    @Bean
    public String exampleBean() {
        return "example";
    }
}