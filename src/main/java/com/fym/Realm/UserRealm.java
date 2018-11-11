package com.fym.Realm;

import com.fym.dao.SysUserMapper;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRealm extends AuthorizingRealm {
    @Autowired
    SysUserMapper mapper;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {


        return null;
    }

    /**
     * 认证 登录时调用
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        String userName=(String) token.getPrincipal();
        String password = new String((char[]) token.getCredentials());


        if ( mapper.selectByLogin(userName)==null||! (password.equals(mapper.selectByLogin(userName))) ){
            throw new UnknownAccountException("账号密码不正确");
        }
        SimpleAuthenticationInfo simpleAuthenticationInfo=new SimpleAuthenticationInfo(userName,password,getName());
        return simpleAuthenticationInfo;
    }
}
