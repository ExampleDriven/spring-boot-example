package org.exampledriven.springboot;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootExampleApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootExampleApplication.class, args);
        new SpringApplicationBuilder()
                .sources(SpringBootExampleApplication.class)
                .bannerMode(Banner.Mode.OFF)
                .run(args);
    }

//    If this bean is enabled it will overwrite the autoconfigured bean
    @Bean
    public GreetingService helloService() {
        return name -> "Hi " + name + " I am NOT an auto configured service";
    }

}
