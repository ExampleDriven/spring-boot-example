package org.exampledriven.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Date;

@RestController
public class MetricsDemoController {

    @Autowired
    private CounterService counterService;

    @Autowired
    private GaugeService gaugeService;

    @GetMapping("testMetric")
    public String testMetrics() {
        counterService.increment("example.counter");

        gaugeService.submit("example.gauge", new Date().getTime());

        return "metric incremeneted, gauge set. Check http://localhost:8080/metrics";
    }

}
