package com.obvious.authority.config;

import com.obvious.authority.realm.PasswdRealm;
import com.obvious.authority.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.context.annotation.Bean;

@Configurable
public class ShiroConfig {

    @Autowired
    @Getter
    @Setter
    private UserService userService;

    @Bean
    public MethodInvokingFactoryBean methodInvokingFactoryBean () {
        MethodInvokingFactoryBean methodInvokingFactoryBean = new MethodInvokingFactoryBean();
        methodInvokingFactoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        methodInvokingFactoryBean.setArguments(new Object[] {securityManager()});
        return methodInvokingFactoryBean;
    }

    @Bean
    public SecurityManager securityManager () {
        SecurityManager securityManager = new DefaultSecurityManager(realm());
        return securityManager;
    }

    @Bean
    public PasswdRealm realm () {
        PasswdRealm realm = new PasswdRealm();
        realm.setUserService(userService);
        return realm;
    }
}
