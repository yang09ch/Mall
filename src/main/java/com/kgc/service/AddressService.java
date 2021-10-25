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
    List<Address> cityList(String addressRegionId);
    /**
     * 获取省内市内的区
     */
    List<Address> districtList(String addressRegionId);
    /**
     * 根据 userAddress 获取 市 区
     */
    Address getByUserAddress(String addressAreaId);
}
