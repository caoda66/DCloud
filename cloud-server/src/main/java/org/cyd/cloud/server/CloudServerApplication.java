package org.cyd.cloud.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class CloudServerApplication {

    @RequestMapping("/")
    public String home() {
        int  i=1/0;
        return "Hello World";
    }
    public static void main(String[] args) {
        SpringApplication.run(CloudServerApplication.class, args);
    }

}
