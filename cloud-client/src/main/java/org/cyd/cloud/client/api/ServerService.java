package org.cyd.cloud.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author caoda
 * @date 2022/5/3
 */
@FeignClient(name = "cloud-server")
public interface ServerService {
    @GetMapping("/server//hello")
    String hello();
}
