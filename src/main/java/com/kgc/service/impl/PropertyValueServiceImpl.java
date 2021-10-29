package com.kgc.service.impl;

import com.kgc.mapper.PropertyValueMapper;
import com.kgc.pojo.PropertyValue;
import com.kgc.service.PropertyValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PropertyValueServiceImpl implements PropertyValueService {
    @Resource
    PropertyValueMapper propertyValueMapper;

    @Override
    public List<PropertyValue> getProperValueAllByProductId(Integer productId) {
        return propertyValueMapper.getProperValueAllByProductId(productId);
    }
}
