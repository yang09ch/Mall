package com.kgc.service.impl;

import com.kgc.mapper.CategoryMapper;
import com.kgc.pojo.Category;
import com.kgc.service.CategoryService;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Resource
    CategoryMapper categoryMapper;

    @Override
    public List<Category> getCategoryAll() {
        return categoryMapper.getCategoryAll();
    }

    @Override
    public PageUtil<Category> getCategoryLimitPage(String categoryName, Integer pageIndex, Integer pageSize) {
        return null;
    }

    @Override
    public int addCategory(Category category) {
        return 0;
    }

    @Override
    public Category getCategoryById(Integer cateId) {
        return categoryMapper.getCategoryById(cateId);
    }
}
