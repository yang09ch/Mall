package com.kgc.service.impl;

import com.kgc.mapper.ProductorderMapper;
import com.kgc.service.ProductorderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductorderServiceImpl implements ProductorderService {
    @Resource
    ProductorderMapper productorderMapper;
}
