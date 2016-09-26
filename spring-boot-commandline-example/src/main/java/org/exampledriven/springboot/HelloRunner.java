package org.exampledriven.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloRunner implements CommandLineRunner {

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
        greetingService.greet(name);
    }
}
