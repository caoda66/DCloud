package org.cyd.cloud.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author caoda
 * @date 2022/5/3
 */

@FeignClient(name = "github-client",url = "https://api.github.com")
public interface HelloFeignService {
    @GetMapping("/search/repositories")
    public String search(@RequestParam("q") String queryStr);
}
