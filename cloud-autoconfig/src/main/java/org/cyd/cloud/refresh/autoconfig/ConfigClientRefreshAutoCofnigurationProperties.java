package org.cyd.cloud.refresh.autoconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author caoda
 * @date 2022/5/6
 */
@ConfigurationProperties(prefix="cyd.cloud.config")
public class ConfigClientRefreshAutoCofnigurationProperties {
    /**
     * 刷新时间间隔
     */
    private long refreshInterval=5;

    public long getRefreshInterval() {
        return refreshInterval;
    }

    public void setRefreshInterval(long refreshInterval) {
        this.refreshInterval = refreshInterval;
    }
}
