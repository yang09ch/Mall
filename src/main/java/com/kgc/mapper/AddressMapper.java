package com.kgc.mapper;

import com.kgc.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

//地区
@Mapper
public interface AddressMapper {
    /**
     * 获取 全国省份信息
     */
    List<Address> addressList();
    /**
     * 获取 省内的市
     */
    List<Address> cityList(@Param("addressRegionId") String addressRegionId);
    /**
     * 获取省内市内的区
     */
    List<Address> districtList(@Param("addressRegionId") String addressRegionId);
    /**
     * 根据 userAddress 获取 市 区
     */
    Address getByUserAddress(String addressAreaId);
}
