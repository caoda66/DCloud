package org.cyd.cloud.zuul;

import com.netflix.appinfo.InstanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@EnableZuulProxy
@RestController
@EnableDiscoveryClient
public class CloudZuulApplication {

    @Autowired
    DiscoveryClient client;

    @GetMapping("/")
    public void home() {
        List<ServiceInstance> instances = client.getInstances("cloud-server");
        for (ServiceInstance serviceInstance : instances) {
            System.out.println(serviceInstance.getServiceId());
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(CloudZuulApplication.class, args);
    }

}
