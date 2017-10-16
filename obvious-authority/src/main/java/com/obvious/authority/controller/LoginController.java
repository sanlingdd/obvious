package com.obvious.authority.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.obvious.core.rest.RestResponse;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.google.common.base.Preconditions.checkArgument;

@RestController
@RequestMapping("/authority")
public class LoginController {

    @RequestMapping("/login")
    @HystrixCommand(fallbackMethod = "defaultLogin")
    public RestResponse login(
                     @RequestParam(value = "username") String username,
                     @RequestParam(value = "passwd") String passwd) {
        Subject subject;
        try {
            checkArgument(!StringUtils.isEmpty(username), "username should not be empty");
            checkArgument(!StringUtils.isEmpty(passwd), "password should not be empty");
            UsernamePasswordToken token = new UsernamePasswordToken(username, passwd);
            token.setRememberMe(true);
            subject = SecurityUtils.getSubject();
            subject.login(token);
        } catch (IllegalArgumentException e) {//| AuthenticationException e) {
            return new RestResponse().error(e.getMessage());
        }
        return new RestResponse().data(subject.getPrincipal());
    }

    public RestResponse defaultLogin(String username, String passwd) {
        return new RestResponse().warn("login service is not available");
    }


}
