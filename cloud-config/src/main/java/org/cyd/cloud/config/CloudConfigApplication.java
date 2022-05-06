package org.cyd.cloud.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author caoda
 * @date 2022/5/5
 */
@SpringBootApplication
@EnableConfigServer
public class CloudConfigApplication implements ApplicationRunner {
    private Logger logger = LoggerFactory.getLogger(CloudConfigApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CloudConfigApplication.class, args);
    }
    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("-----------------------------cloudconfig app start--------------------------------------");
    }
}
