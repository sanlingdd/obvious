package com.obvious.authority.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.obvious.core.rest.RestResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.google.common.base.Preconditions.checkArgument;

@RestController
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/")
    public String helloworld() {
        return "helloworld";
    }

    @RequestMapping("/login")
    @HystrixCommand(fallbackMethod = "defaultLogin")
    public RestResponse login(
                     @RequestParam(value = "username") String username,
                     @RequestParam(value = "passwd") String passwd) {
        try {
            checkArgument(!StringUtils.isEmpty(username), "username should not be empty");
            checkArgument(!StringUtils.isEmpty(passwd), "password should not be empty");
            UsernamePasswordToken token = new UsernamePasswordToken(username, passwd);
            token.setRememberMe(true);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
            return new RestResponse().data(subject.getPrincipal());
        } catch (IllegalArgumentException | UnknownAccountException | IncorrectCredentialsException | LockedAccountException e) {
            if (e instanceof UnknownAccountException || e instanceof IncorrectCredentialsException) {
                return new RestResponse().info("username and password aren't correct");
            } else if (e instanceof LockedAccountException) {
                return new RestResponse().info("the account is locked");
            } else {
                return new RestResponse().info(e.getMessage());
            }
        } catch (AuthenticationException re) {
            throw new RuntimeException(re);
        }

    }

    public RestResponse defaultLogin(String username, String passwd, Throwable throwable) {
        logger.info(throwable.getMessage());
        return new RestResponse().warn("login service is not available");
    }


}
