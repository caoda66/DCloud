package org.cyd.cloud.server.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoda
 * @date 2022/5/1
 */
@RestController
@RequestMapping("/server")
public class ProviderController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/hello")
    public String hello(){
        return "hello, this is server "+port;
    }
}
