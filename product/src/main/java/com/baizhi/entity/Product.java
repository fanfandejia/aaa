package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private Double price;

    @Column(name = "content")
    private String content;

    @Column(name = "imgpath")
    private String imgpath;

    @Column(name = "status")
    private Integer status;

    @Column(name = "uptime")
    private Date uptime;

    @Column(name = "city")
    private String city;


}