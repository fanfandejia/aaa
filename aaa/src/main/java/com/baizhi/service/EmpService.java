package com.baizhi.service;

import com.baizhi.entity.Emp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EmpService {
    public List<Emp> queryAll();
    public void addEmp(Emp emp);
    public void removeEmp(@Param("id") Integer id);
    public void modifyEmp(Emp emp);
}
