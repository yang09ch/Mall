package com.kgc.service.impl;

import com.kgc.mapper.AddressMapper;
import com.kgc.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    AddressMapper addressMapper;
}
