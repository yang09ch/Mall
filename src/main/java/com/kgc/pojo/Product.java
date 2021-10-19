package com.kgc.pojo;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

//商品信息
@Data
public class Product implements Serializable {
    private Integer productId;//主键
            private String  productName;//名称
    private String  productTitle;//标题
            private BigDecimal productPrice;//价格
    private BigDecimal productSalePrice;//原价
           private String  productCreateDate;//促销价
    private Integer productCategoryId;//类别编号
            private Integer productIsEnabled;//商品状态
    private List<Productimage> singleProductImageList;
}
