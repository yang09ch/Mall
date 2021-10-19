package com.kgc.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

//商品类别
@Data
public class Category implements Serializable {
    private Integer  categoryId;//主键
            private String  categoryName;//名称
    private String  categoryImageSrc;//图片
    private List<Product> productList;
}
