package org.cyd.cloud.config.client.controller;

import org.cyd.cloud.config.client.config.ConfigInfoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoda
 * @date 2022/5/5
 */
@RestController
public class TestController {

    @Autowired
    ConfigInfoProperties configInfoProperties;

    @GetMapping("/name")
    public String getName(){
        return  configInfoProperties.getName();
    }
}
