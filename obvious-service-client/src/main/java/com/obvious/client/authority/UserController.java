package com.obvious.client.authority;

import com.obvious.core.rest.RestResponse;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableFeignClients
@EnableDiscoveryClient
@Getter
@Setter
public class UserController {

    @Autowired
    private UserClient userClient;

    @RequestMapping("/login")
    public RestResponse hello(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "passwd") String passwd) {
        return userClient.login(username, passwd);
    }
}
