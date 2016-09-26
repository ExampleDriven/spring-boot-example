package org.exampledriven.admin;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EnableAdminServer
@SpringBootApplication
public class SpringAdminExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringAdminExampleApplication.class, args);
    }
}
