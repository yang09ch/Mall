package com.kgc.service.impl;

import com.kgc.mapper.PropertyValueMapper;
import com.kgc.service.PropertyValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PropertyValueServiceImpl implements PropertyValueService {
    @Resource
    PropertyValueMapper propertyValueMapper;
}
