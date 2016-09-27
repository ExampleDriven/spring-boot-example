package org.exampledriven.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloRunner implements CommandLineRunner {

    Logger logger = LoggerFactory.getLogger(HelloRunner.class);

    @Autowired
    GreetingService greetingService;

    @Override
    public void run(String... args) throws Exception {
        String name;
        if (args.length > 0) {
            name = args[0];
        } else {
            name = "Peter";
        }
        logger.info(greetingService.greet(name));
    }
}
