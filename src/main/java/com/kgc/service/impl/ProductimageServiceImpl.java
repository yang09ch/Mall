package com.kgc.service.impl;

import com.kgc.mapper.ProductimageMapper;
import com.kgc.service.ProductimageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ProductimageServiceImpl implements ProductimageService {
    @Resource
    ProductimageMapper productimageMapper;

}
