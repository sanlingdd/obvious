package com.obvious.authority.realm;

import com.obvious.authority.entity.UserEntity;
import com.obvious.authority.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import static com.google.common.base.Preconditions.*;

public class PasswdRealm extends AuthorizingRealm {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Getter
    @Setter
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(
            PrincipalCollection principals) {
        logger.info("begin to do authorization, session id: " +
                    SecurityUtils.getSubject().getSession().getId());
        UserEntity userEntity = (UserEntity) SecurityUtils.getSubject().getPrincipal();
        AuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        logger.info("end to do authorization, session id: " +
                SecurityUtils.getSubject().getSession().getId());
        return authorizationInfo;
    }

    /**
     * do authentication and return authentication info.
     * @param token it's username and password token.
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken token) throws AuthenticationException {
        checkNotNull(token);
        logger.info("begin to authenticate, session id: " +
                    SecurityUtils.getSubject().getSession().getId());
        UsernamePasswordToken passwdToken = (UsernamePasswordToken) token;
        UserEntity userEntity = userService.checkUser(passwdToken.getUsername());
        logger.info("end to authentication, session id: " +
                    SecurityUtils.getSubject().getSession().getId());
        if (userEntity == null) {
            throw new AuthenticationException("username and password are not correct");
        } else {
            return new SimpleAuthenticationInfo(userEntity, userEntity.getPasswd(), this.getName());
        }
    }
}
