package org.cyd.cloud.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author caoda
 * @date 2022/5/1
 */
@RestController
@RequestMapping("/restful")
public class EurekaServiceController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/service/{serviceId}")
    public ServiceInstance getServerInfo(@PathVariable("serviceId")String serviceId){
        ServiceInstance choose = loadBalancerClient.choose(serviceId);

        return choose;
    }

    /**
     * 实现ribbon负载均衡
     * @param serviceId
     * @return
     */
    @GetMapping("/service/{serviceId}/hello")
    public String getServiceApi(@PathVariable("serviceId")String serviceId){
        String helloStr = restTemplate.getForObject("http://cloud-server/server/hello", String.class);
        return helloStr;
    }
}
