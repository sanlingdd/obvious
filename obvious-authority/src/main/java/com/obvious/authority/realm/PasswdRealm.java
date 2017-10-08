package com.obvious.authority.realm;

import com.obvious.authority.entity.UserEntity;
import com.obvious.authority.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PasswdRealm extends AuthorizingRealm {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
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
        logger.info("begin to authenticate [session id] " +
                    SecurityUtils.getSubject().getSession().getId());
        UserEntity userEntity = userService
        return null;
    }
}
