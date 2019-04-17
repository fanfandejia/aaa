package com.baizhi.test;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.authz.permission.DomainPermission;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.ArrayList;
import java.util.Arrays;

public class MyRealm extends AuthorizingRealm {
//获取认证数据
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken upToken=(UsernamePasswordToken)authenticationToken;
        String username = upToken.getUsername();
     //   User user=UserMapper.selectByUsername(username);
        /*第一个参数：获取的User对象
           第二个参数：user.getPassword(),注意这里是指从数据库中获取的password
           第三个参数：realm，即当前的自定义的realm类的名称，也可写成getName()
           AuthenticationInfo authenticationInfo=new SimpleAccount(user,user.getPassword(),"MyRealm");
        */
    //    AuthenticationInfo authenticationInfo=new SimpleAccount("aa","123456","MyRealm");
        AuthenticationInfo authenticationInfo=null;
        if(username.equals("aa")){
            authenticationInfo=new SimpleAccount("aa","68609b8b64988c0f4def093eaa025e05", ByteSource.Util.bytes("abcd"),getName());
        }

        return authenticationInfo;
    }
//获取授权数据
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String primaryPrincipal = (String) principalCollection.getPrimaryPrincipal();
//        拿着username去获取角色   根据角色查权限
//        身份    角色      权限
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
//        authorizationInfo.addRole("super");
        authorizationInfo.addRoles(Arrays.asList("super","admin"));

//        authorizationInfo.addStringPermission("user:*");
        ArrayList<Permission> list = new ArrayList<Permission>();
        list.add(new DomainPermission("user:update"));
        list.add(new DomainPermission("user:add"));
        authorizationInfo.addObjectPermissions(list);

        return authorizationInfo;
    }
}
