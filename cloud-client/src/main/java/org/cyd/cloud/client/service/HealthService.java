package org.cyd.cloud.client.service;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;

/**
 * 动态服务上下线
 * @author caoda
 * @date 2022/5/1
 */
public class HealthService implements HealthIndicator {
    @Override
    public Health getHealth(boolean includeDetails) {
        return null;
    }

    @Override
    public Health health() {
        return null;
    }
}
