package com.hayes.ribbonconsume;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class RibbonConsumeApplication {

    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumeApplication.class, args);
    }

}
