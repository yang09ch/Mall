package com.kgc.pojo;

import lombok.Data;

import java.io.Serializable;
//地区
@Data
public class Address implements Serializable {
    private String  addressAreaId;//主键
            private String  addressName;//地址的行政区划
    private String  addressRegionId;//父级区划
}
