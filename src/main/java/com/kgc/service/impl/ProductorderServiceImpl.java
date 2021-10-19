package com.kgc.service.impl;

import com.kgc.mapper.ProductorderMapper;
import com.kgc.pojo.Productorder;
import com.kgc.service.ProductorderService;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductorderServiceImpl implements ProductorderService {
    @Resource
    ProductorderMapper productorderMapper;

    @Override
    public PageUtil<Productorder> getProductorderPage(String productorderCode, String productorderPost, Integer pageIndex, Integer pageSize, Object... productorderStatus) {
        return null;
    }
}
