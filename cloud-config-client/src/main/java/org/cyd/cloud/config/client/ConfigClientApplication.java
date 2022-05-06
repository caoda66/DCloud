package org.cyd.cloud.config.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author caoda
 * @date 2022/5/5
 */
@SpringBootApplication
public class ConfigClientApplication implements ApplicationRunner {
    private static Logger logger = LoggerFactory.getLogger(ConfigClientApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        logger.info("------------configClient UP");
    }
}
