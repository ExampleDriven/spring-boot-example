package org.exampledriven.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExampleApplication {

    private static Logger logger = LoggerFactory.getLogger(SpringBootExampleApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpringBootExampleApplication.class, args);
        logger.info("After run method");
    }

}
