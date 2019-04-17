package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @RequestMapping("login")
    public String login(String username,String password, HttpSession session){
        Admin admin=new Admin();
        admin.setUsername(username);
        admin.setPassword(password);
        Admin ad = adminService.login(admin);
        System.out.println(ad+"===================================");
          System.out.println(ad+"---------------------------------------");
        if(ad!=null){
           session.setAttribute("admin",ad);
           return "redirect:/emp/queryAll";
        }
        return "login";
    }
    @RequestMapping("register")
    public String register(Admin admin,String code,HttpSession session) {
        String code1 =(String) session.getAttribute("validationCode");
        if(code1.equals(code)){
            int i = adminService.register(admin);
            if(i!=0) {
                return "login";
            }
        }else{
            return "register";
        }
        return "register";
    }
    @RequestMapping("exit")
    public String exit(HttpSession session){
        session.removeAttribute("Admin");
        return "login";
    }
}
