package com.kgc.service.impl;

import com.kgc.mapper.AddressMapper;
import com.kgc.pojo.Address;
import com.kgc.service.AddressService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Resource
    AddressMapper addressMapper;

    @Override
    public List<Address> addressList() {
        return addressMapper.addressList();
    }

    @Override
    public List<Address> cityList(Integer addressRegionId) {
        return addressMapper.cityList(addressRegionId);
    }

    @Override
    public List<Address> districtList(Integer addressRegionId) {
        return addressMapper.districtList(addressRegionId);
    }
}
