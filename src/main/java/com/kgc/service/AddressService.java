package com.kgc.service;

import com.kgc.pojo.Address;

import java.util.List;

public interface AddressService {
    /**
     * 获取 全国省份信息
     */
    List<Address> addressList();
    /**
     * 获取 省内的市
     */
    List<Address> cityList(Integer addressRegionId);
    /**
     * 获取省内市内的区
     */
    List<Address> districtList(Integer addressRegionId);
}
