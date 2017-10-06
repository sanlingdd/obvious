package com.obvious.authority.controller;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public boolean login(@RequestParam(value = "username") String username,
                         @RequestParam(value = "passwd") String passwd) {
        checkArgument(!StringUtils.isEmpty(username), "username should not be empty");
        checkNotNull(!StringUtils.isEmpty(passwd), "password should not be empty");
        UsernamePasswordToken token = new UsernamePasswordToken(username, passwd);
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return subject.isAuthenticated();
    }
}
