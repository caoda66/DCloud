package org.cyd.cloud.config.client.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

/**
 * @author caoda
 * @date 2022/5/5
 */
@Component
@RefreshScope
public class ConfigInfoProperties {

    @Value("${myname}")
    private String  name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
