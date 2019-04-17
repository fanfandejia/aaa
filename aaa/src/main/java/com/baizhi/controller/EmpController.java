package com.baizhi.controller;

import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;



@Controller
@RequestMapping("emp")
public class EmpController {
    @Resource
    private EmpService empService;

    @RequestMapping("queryAll")
    public String queryAll(HttpSession session){
        List<Emp> emps = empService.queryAll();
        session.setAttribute("list",emps);
        return "emplist";
    }
    @RequestMapping("addEmp")
    public String addEmp(Emp emp){
        empService.addEmp(emp);
        return "redirect:/emp/queryAll";
    }
    @RequestMapping("removeEmp")
    public String removeEmp(Integer id){
        empService.removeEmp(id);
        return "redirect:/emp/queryAll";
    }
    @RequestMapping("modifyEmp")
    public String removeEmp(Emp emp){
        empService.modifyEmp(emp);
        return "redirect:/emp/queryAll";
    }
}
