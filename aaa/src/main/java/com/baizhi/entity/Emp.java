package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "emp")
@Data
//@Data  生成set/get toString equals
@AllArgsConstructor
//全参构造
@NoArgsConstructor
public class Emp{
    @Id
    private Integer id;

    private String name;

    private Double salary;

    private Integer age;


}