package com.baizhi.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;

public class TestShiro {
    public static void main(String[] args) {
        //安全管理器工厂                                           第二种认证方式需要写.ini的配置文件： "classpath:shiro.ini"
        IniSecurityManagerFactory iniSecurityManagerFactory=new IniSecurityManagerFactory("classpath:shiro.ini");
       //获取安全管理器
        SecurityManager instance = iniSecurityManagerFactory.createInstance();
       //将安全管理器交给工具类
        SecurityUtils.setSecurityManager(instance);
       //通过工具类获取主体
        Subject subject = SecurityUtils.getSubject();

        AuthenticationToken authenticationToken=new UsernamePasswordToken("aa","123456");
        //第一种认证方式：通过抛异常的方式查看认证是否成功
        try {
            subject.login(authenticationToken);
            System.out.println("认证成功");
        }catch (AuthenticationException e){
            e.printStackTrace();
            System.out.println("认证失败");
        }
        //第二种认证方式：isAuthenticated() 的返回值  true：成功   false：失败
        boolean b = subject.isAuthenticated();
        System.out.println(b);

        //授权
        if(subject.isAuthenticated()){
            //基于角色
            //如果角色是管理员  hasRole()
            if(subject.hasRole("admin")){
                System.out.println("aaaa");
            }

            //基于资源
        }
    }
}
