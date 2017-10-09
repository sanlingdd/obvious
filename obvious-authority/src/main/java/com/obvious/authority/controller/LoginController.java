package com.obvious.authority.controller;

import com.obvious.authority.entity.UserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.google.common.base.Preconditions.checkArgument;

@RestController
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public UserEntity login(
                     @RequestParam(value = "username") String username,
                     @RequestParam(value = "passwd") String passwd) {
        checkArgument(!StringUtils.isEmpty(username), "username should not be empty");
        checkArgument(!StringUtils.isEmpty(passwd), "password should not be empty");
        UsernamePasswordToken token = new UsernamePasswordToken(username, passwd);
        token.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
        return (UserEntity) subject.getPrincipal();
    }
}
