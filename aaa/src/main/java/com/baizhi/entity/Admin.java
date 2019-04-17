package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "admin")
@Data
//@Data  生成set/get toString equals
@AllArgsConstructor
//全参构造
@NoArgsConstructor
public class Admin {
    @Id
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "password")
    private String password;



}