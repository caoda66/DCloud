package org.cyd.cloud.client.controller;

import org.cyd.cloud.client.service.HystrixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author caoda
 * @date 2022/5/3
 */
@RestController
public class HystrixContrller {
    @Autowired
    private HystrixService hystrixService;

    @GetMapping("/getUser")
    public String getUser(@RequestParam("userName")String userName) throws Exception {
        return hystrixService.getUser(userName);
    }
}
