package com.kgc.pojo;

import lombok.Data;
//商品属性值
import java.io.Serializable;
@Data
public class PropertyValue implements Serializable {
    private Integer propertyValueId;//主键
            private String  propertyValueValue;//属性值
    private Integer propertyValuePropertyId;//商品属性id
            private Integer propertyValueProductId;//商品信息id
}
