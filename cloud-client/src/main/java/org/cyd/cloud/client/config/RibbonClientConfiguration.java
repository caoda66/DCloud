package org.cyd.cloud.client.config;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author caoda
 * @date 2022/5/2
 */
//@Configuration
//@AvoidScan
//public class RibbonClientConfiguration {
//    @Autowired
//    IClientConfig config;
//
//    @Bean
//    public IRule ribbonRule(IClientConfig config) {
//        return new RandomRule();
//    }
//}
