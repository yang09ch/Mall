package com.kgc.service;

import com.kgc.pojo.Category;
import com.kgc.util.PageUtil;

import java.util.List;

public interface CategoryService {
    List<Category> getCategoryAll();

    /**
     * 分页 模糊查询
     * @param categoryName
     * @param pageIndex
     * @param pageSize
     * @return
     */
    PageUtil<Category> getCategoryLimitPage(String categoryName,Integer pageIndex,Integer pageSize);
    /**
     * 新增产品类型
     */
    int addCategory(Category category);
    /**
     * 根据类型id 获取对象
     */
    Category getCategoryById(Integer cateId);
}
