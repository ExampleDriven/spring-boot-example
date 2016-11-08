package com.example.exampledriven;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/test")
    public String hello() {

        String hello332 = "Hello33";
        return hello332;
    }

}
