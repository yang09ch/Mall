package com.kgc.service.impl;

import com.kgc.mapper.CategoryMapper;
import com.kgc.mapper.ProductMapper;
import com.kgc.pojo.Product;
import com.kgc.service.ProductService;


import com.kgc.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    ProductMapper productMapper;

    @Override
    public PageUtil<Product> getProductLimit(String productName, BigDecimal firstPrice, BigDecimal lastPrice,
                                             Integer productCategoryId, Integer pageIndex, Integer pageSize,
                                             Object... productIsEnabled) {
        PageUtil<Product> pageUtil=new PageUtil<>();
        pageUtil.setPageSize(pageSize);
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setTotalCount(productMapper.getProductCount(productName, firstPrice, lastPrice, productCategoryId, productIsEnabled));
        pageUtil.setList(productMapper.getProductLimit(productName, firstPrice, lastPrice, productCategoryId, (pageIndex-1)*pageSize, pageSize, productIsEnabled));
        return pageUtil;
    }

    @Override
    public Product getProductByCategoryId(Integer productCategoryId) {
        return productMapper.getProductArray(productCategoryId);
    }

    @Override
    public List<Product> getLunPo() {
        return productMapper.getLunPo();
    }

}
