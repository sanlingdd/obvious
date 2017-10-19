package com.obvious.client.authority;

import com.obvious.core.rest.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "obvious-authority")
public interface UserClient {

    @RequestMapping(value = "/authority/login", method = RequestMethod.GET)
    RestResponse login(@RequestParam(value = "username") String username,
                       @RequestParam(value = "passwd") String passwd);
}
