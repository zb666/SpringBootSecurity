package com.gupaoedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class GpSpringScheduledDemoApp {

    public static void main(String[] args) {
        SpringApplication.run(GpSpringScheduledDemoApp.class,args);
    }

}
