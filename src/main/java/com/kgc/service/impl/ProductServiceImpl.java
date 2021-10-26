package com.kgc.service.impl;
import com.kgc.mapper.ProductMapper;
import com.kgc.pojo.Product;
import com.kgc.service.ProductService;


import com.kgc.util.PageUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

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
    public List<Product> getProductArray(Integer productCategoryId) {
        return productMapper.getProductArray(productCategoryId);
    }
    @Override
    public List<Product> getLunPo() {
        return productMapper.getLunPo();
    }

    @Override
    public List<Product> getProductAll(String productName, Integer productCategoryId) {
        if (productCategoryId!=null){
            productName="";
        }
        return productMapper.getProductAll(productName,productCategoryId);
    }

    @Override
    public List<Product> getProductList(Integer productCategoryId) {
        return productMapper.getProductList(productCategoryId);
    }

    @Override
    public int getProductNameByCount(String productName) {
        return productMapper.getProductNameByCount(productName);
    }

    @Override
    public Product getByProductId(Integer productId) {
        return productMapper.getByProductId(productId);
    }

}
