package com.kgc.mapper;

import com.kgc.pojo.Category;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//商品类别
@Mapper
public interface CategoryMapper {
    /**
     * 商品类别
     * @return
     */
    List<Category> getCategoryAll();

    /**
     * 分页查询 产品类型
     */
    int getCategoryCount(@Param("categoryName") String categoryName);
    List<Category> getCategoryLimmitAll(@Param("categoryName") String categoryName, @Param("pageIndex") Integer pageIndex,@Param("pageSize")  Integer pageSize);
    /**
     * 新增产品类型
     */
    int addCategory(Category category);
    /**
     * 根据类型id 获取对象
     */
    Category getCategoryById(Integer cateId);
}
