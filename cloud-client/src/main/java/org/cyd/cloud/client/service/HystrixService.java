package org.cyd.cloud.client.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;

/**
 * @author caoda
 * @date 2022/5/3
 */
@Service
public class HystrixService {

    @HystrixCommand(fallbackMethod = "defaultUser")
    public String getUser(String useName) throws Exception {
        if ("Spring".equals(useName)) {
            return "this is a real user";
        }else {
            throw new Exception("用户不存在");
        }
    }

    public String defaultUser(String useName) {
        return "the user does not exist in this system";
    }
}
