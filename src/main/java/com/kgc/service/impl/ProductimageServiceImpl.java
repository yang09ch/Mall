package com.kgc.service.impl;

import com.kgc.mapper.ProductimageMapper;
import com.kgc.pojo.Productimage;
import com.kgc.service.ProductimageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductimageServiceImpl implements ProductimageService {
    @Resource
    ProductimageMapper productimageMapper;

    @Override
    public List<Productimage> getProductimgeList(Integer productimageProductId) {
        return productimageMapper.getProductimgeList(productimageProductId);
    }

    @Override
    public List<Productimage> getProductImgeYulan(Integer productimageProductid) {
        return productimageMapper.getProductImgeYulan(productimageProductid);
    }
}
