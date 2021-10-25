package com.kgc.pojo;

import lombok.Data;
//商品图片
import java.io.Serializable;
@Data
public class Productimage implements Serializable {
    private Integer productimageId;//主键
           private Integer productimageType;//图片类型
    private String  productImageSrc;//图片路径
            private Integer productimageProductId;//商品编号
}
