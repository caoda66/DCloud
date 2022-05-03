package org.cyd.cloud.client.controller;

import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.cyd.cloud.client.api.HelloFeignService;
import org.cyd.cloud.client.api.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.cloud.client.loadbalancer.Request;
import org.springframework.web.bind.annotation.*;
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

    @Autowired
    HelloFeignService helloFeignService;

    @Autowired
    ServerService serverService;

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

    /**
     * 实现ribbon负载均衡（灰度）
     * @param version
     * @return
     */
    @GetMapping("/service/hello/{version}")
    public String getServiceApi2(@PathVariable("version")String version){
        RibbonFilterContextHolder.getCurrentContext().add("version", version);
        String helloStr = restTemplate.getForObject("http://cloud-server/server/hello", String.class);
        return helloStr;
    }

    @GetMapping("/search/github")
    public String searchGithuByStr(@RequestParam("str") String str){
      return   helloFeignService.search(str);
    }

    @GetMapping("/feign/hello")
    public String serverFeignHello(){
        return serverService.hello();
    }

    /**
     * feign 与eureka metadata结合实现灰度
     * @param version
     * @return
     */
    @GetMapping("/feign/version/hello")
    public String serverFeignHello(@RequestParam("version")String version){
        RibbonFilterContextHolder.getCurrentContext().add("version", version);
        return serverService.hello();
    }

}
