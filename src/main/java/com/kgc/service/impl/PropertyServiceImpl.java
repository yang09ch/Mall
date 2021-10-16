package com.kgc.service.impl;

import com.kgc.mapper.PropertyMapper;
import com.kgc.service.PropertyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PropertyServiceImpl implements PropertyService {
    @Resource
    PropertyMapper propertyMapper;
}
