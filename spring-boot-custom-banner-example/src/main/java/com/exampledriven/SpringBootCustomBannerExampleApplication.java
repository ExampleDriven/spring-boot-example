package com.exampledriven;

import org.springframework.boot.ImageBanner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.io.ClassPathResource;

@SpringBootApplication
public class SpringBootCustomBannerExampleApplication {

    public static void main(String[] args) {
        ImageBanner banner = new ImageBanner(
                new ClassPathResource("rolling-stones.png"));

        new SpringApplicationBuilder()
                .sources(SpringBootCustomBannerExampleApplication.class)
                .banner(banner)
                .run();
    }

}
