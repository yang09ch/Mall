package com.kgc.mapper;

import com.kgc.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

//商品信息
@Mapper
public interface ProductMapper {
    /**
     * 产品条件 分页查询
     * @param productName 产品名称
     * @param firstPrice  最低价
     * @param lastPrice   最高价
     * @param productCategoryId 产品类型
     * @param productIsEnabled 产品状态
     * @return
     */
    int getProductCount(
            @Param("productName") String productName,
            @Param("firstPrice") BigDecimal firstPrice,
            @Param("lastPrice") BigDecimal lastPrice,
            @Param("productCategoryId")Integer productCategoryId,
            @Param("productIsEnabled") Object...productIsEnabled);
    List<Product> getProductLimit(@Param("productName") String productName,
                                  @Param("firstPrice") BigDecimal firstPrice,
                                  @Param("lastPrice") BigDecimal lastPrice,
                                  @Param("productCategoryId")Integer productCategoryId,
                                  @Param("pageIndex") Integer pageIndex,
                                  @Param("pageSize") Integer pageSize,
                                  @Param("productIsEnabled") Object...productIsEnabled);
}
