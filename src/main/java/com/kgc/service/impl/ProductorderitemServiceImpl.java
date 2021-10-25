package com.kgc.service.impl;

import com.kgc.mapper.ProductorderitemMapper;
import com.kgc.service.ProductorderitemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductorderitemServiceImpl implements ProductorderitemService {
    @Resource
    ProductorderitemMapper productorderitemMapper;

    @Override
    public int getProductorderItemCount(Integer productorId) {
        return productorderitemMapper.getProductorderItemCount(productorId);
    }
}
