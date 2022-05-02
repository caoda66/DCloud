package org.cyd.cloud.client.config;

import com.netflix.eureka.registry.rule.AlwaysMatchInstanceStatusRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author caoda
 * @date 2022/4/29
 */
@Configuration
public class BeanConfig {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    /**
     * 更换ribbon负载均衡策略,针对全局起作用
     * @return
     */
//    @Bean
//    public IRule  rule(){
//        return new RandomRule();
//    }

}
