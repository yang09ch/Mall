package com.kgc.mapper;

import com.kgc.pojo.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//商品类别
@Mapper
public interface CategoryMapper {
    /**
     * 商品类别
     * @return
     */
    List<Category> getCategoryAll();
}
