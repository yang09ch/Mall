package com.kgc.service;

import com.kgc.pojo.Productimage;

import java.util.List;

public interface ProductimageService {
    /**
     * 根据商品的编号查询图片
     * @param productimageProductId
     * @return
     */
    List<Productimage> getProductimgeList(Integer productimageProductId);
    /**
     * 获取商品的预览图 根据商品id
     */
    List<Productimage> getProductImgeYulan(Integer productimageProductid);
    /**
     * 获取详细图
     */
    List<Productimage> getProductImageXIan(Integer productimageProductid);
}
