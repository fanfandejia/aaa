package com.baizhi.test;

import org.apache.shiro.crypto.hash.Md5Hash;

public class TestMd5 {
    public static void main(String[] args) {
        //参数1：密码  参数2：加盐  参数3：hash散列次数
        Md5Hash md5Hash = new Md5Hash("123456","abcd",1024);
       //toHex()得到十六进制的
        System.out.println(md5Hash.toHex());
        //123456              e10adc3949ba59abbe56e057f20f883e
        //123456  abcd        da3177cbd9f064004b6a0d59a3a484bb
        //123456  abcd  1024   68609b8b64988c0f4def093eaa025e05


    }
}
