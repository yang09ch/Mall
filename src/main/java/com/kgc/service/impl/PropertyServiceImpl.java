package com.kgc.service.impl;

import com.kgc.mapper.PropertyMapper;
import com.kgc.pojo.Property;
import com.kgc.service.PropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Resource
    PropertyMapper propertyMapper;

    @Override
    public List<Property> propertyList(Integer categoryId) {
        return propertyMapper.propertyList(categoryId);
    }
}
