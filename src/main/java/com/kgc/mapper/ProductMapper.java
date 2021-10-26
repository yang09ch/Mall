package com.kgc.mapper;

import com.kgc.pojo.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

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
    /**
     * 根基 商品类型查询 正则出售或者是促销的商品（显示前8条记录）
     */
    List<Product> getProductArray(Integer productCategoryId);
    /*根据id获取商品查询*/
    List<Product> getProductList(Integer productCategoryId);

    /**
     * 轮播  进行绑定数据 展示前六条
     */
    List<Product> getLunPo();
    /**
     * 模糊查询商品
     */
    List<Product> getProductAll(@Param("productName") String productName,@Param("productCategoryId") Integer productCategoryId);
    /**
     * 根据搜索框输入的商品查询 存在数量
     */
    int getProductNameByCount(String productName);
    /**
     * 根据商品id 获取商品的对象
     */
    Product getByProductId(Integer productId);
}
