package com.baizhi.aaa;
import com.baizhi.dao.AdminMapper;
import com.baizhi.dao.EmpMapper;
import com.baizhi.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AaaApplicationTests {
    @Resource
    private EmpMapper empMapper;
    @Resource
    private AdminMapper adminMapper;
   /* @Test
    public void contextLoads() {
        EmpExample empExample=new EmpExample();
        List<Emp> emps = empMapper.selectByExample(empExample);
        for (Emp emp : emps) {
            System.out.println(emp);
        }
    }*/
  /*  @Test
    public void contextLoads() {
        Admin t=new Admin();
        t.setUsername("aa");
        t.setPassword("123456");
        Admin admin = adminMapper.selectOne(t);
        System.out.println(admin);

    }*/
    @Test
    public void contextLoads() {
        Admin record=new Admin(2,"ll","乐乐","男","123456");
        int i = adminMapper.insertSelective(record);
        System.out.println(i);

    }
    @Test
    public void test2(){
        Admin admin = new Admin(10, "aa", "aa", "aa", "aa");
        adminMapper.insert(admin);
//        System.out.println();
    }
}
