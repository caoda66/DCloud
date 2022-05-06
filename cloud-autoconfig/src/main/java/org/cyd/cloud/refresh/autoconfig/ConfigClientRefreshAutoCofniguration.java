package org.cyd.cloud.refresh.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.autoconfigure.RefreshAutoConfiguration;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.ScheduledAnnotationBeanPostProcessor;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.IntervalTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

/**
 * @author caoda
 * @date 2022/5/6
 */
@ConditionalOnClass(RefreshEndpoint.class)
@EnableConfigurationProperties({ConfigClientRefreshAutoCofnigurationProperties.class})
@AutoConfigureAfter(RefreshAutoConfiguration.class)
@Configuration
public class ConfigClientRefreshAutoCofniguration implements SchedulingConfigurer {

    @Autowired
    private ConfigClientRefreshAutoCofnigurationProperties configClientRefreshAutoCofnigurationProperties;

    /**
     * 刷新端点
     */
    @Autowired
    private RefreshEndpoint refreshEndpoint;

    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        final long interval=getRefreshIntervalInMillsecondes();
        scheduledTaskRegistrar.addFixedDelayTask(new IntervalTask(new Runnable() {
            @Override
            public void run() {
                System.out.println("-------刷新配置开始----");
                refreshEndpoint.refresh();
                System.out.println("-------刷新配置结束----");
            }
        },interval,interval));
    }

    private long getRefreshIntervalInMillsecondes() {
        return configClientRefreshAutoCofnigurationProperties.getRefreshInterval()*1000;
    }

    @ConditionalOnMissingBean(ScheduledAnnotationBeanPostProcessor.class)//当没有缺少bean才执行
    @EnableScheduling
    @Configuration
    protected static class EnableSchedulingCofnigProperties{

    }
}
