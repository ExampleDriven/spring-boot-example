package org.exampledriven.admin.eureka.customer.shared.server.server.rest;

import org.exampledriven.admin.eureka.customer.shared.server.server.domain.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@RestController
@RefreshScope
public class TestController {

    @Value("${test.message}")
    private String message;

    @Autowired
    private  CounterService counterService;

    @Autowired
    private GaugeService gaugeService;

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
    public String printMessage() {

        counterService.increment("counter.testcntroller");
        gaugeService.submit("gauge.testcontroller", System.currentTimeMillis());

        return message;

    }

}