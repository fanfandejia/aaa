package com.baizhi.serviceimpl;

import com.baizhi.dao.AdminMapper;
import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service
@Transactional
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        Admin admin1 = adminMapper.selectOne(admin);
        return admin1;
    }

    @Override
    public int register(Admin admin) {
        int i = adminMapper.insertSelective(admin);
        return i;

    }
}
