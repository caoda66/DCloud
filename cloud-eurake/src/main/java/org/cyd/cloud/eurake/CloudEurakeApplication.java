package org.cyd.cloud.eurake;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CloudEurakeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudEurakeApplication.class, args);
    }

}
