package com.kgc.mapper;

import com.kgc.pojo.Productimage;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//商品图片
@Mapper
public interface ProductimageMapper {
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
