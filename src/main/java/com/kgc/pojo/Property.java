package com.kgc.pojo;

import lombok.Data;
//商品属性
import java.io.Serializable;
@Data
public class Property implements Serializable {
    private Integer propertyId;//主键
            private String  propertyName;//属性名
    private Integer propertyCategoryId;//属性类别
}
