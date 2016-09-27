package org.exampledriven.springboot;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnMissingBean(value = GreetingService.class)
public class ExampleAutoConfiguration {

    @Bean
    public GreetingService helloService() {
        return name -> "Hi " + name + " I am an auto configured service";
    }

}
