package org.exampledriven.springboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * Created by Peter_Szanto on 9/26/2016.
 */
@Service
public class GreetingService {
    Logger logger = LoggerFactory.getLogger(GreetingService.class);

    public void  greet(String name) {
        logger.info("Hi " + name);
    }

}
