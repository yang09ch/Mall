package com.kgc.service.impl;

import com.kgc.mapper.CategoryMapper;
import com.kgc.pojo.Category;
import com.kgc.service.CategoryService;
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
}
