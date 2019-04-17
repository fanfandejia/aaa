package com.baizhi.serviceimpl;

import com.baizhi.dao.EmpMapper;
import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Resource
    private EmpMapper empMapper;

    @Override
    public List<Emp> queryAll() {
        List<Emp> emps = empMapper.selectAll();
        return emps;
    }

    @Override
    public void addEmp(Emp emp) {
        empMapper.insert(emp);
    }

    @Override
    public void removeEmp(Integer id) {
        empMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void modifyEmp(Emp emp) {
        empMapper.updateByPrimaryKeySelective(emp);
    }
}
