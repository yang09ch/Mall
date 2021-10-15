package com.kgc.pojo;

import lombok.Data;

import java.io.Serializable;
//商品类别
@Data
public class Category implements Serializable {
    private Integer  categoryId;//主键
            private String  categoryName;//名称
    private String  categoryImageSrc;//图片
}
