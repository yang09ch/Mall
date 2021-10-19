package com.kgc.vo;

import lombok.Data;

import java.util.List;

@Data
public class AddressVo<T> {
    private List<T> addressList;
    private List<T> childAddressList;
    private boolean success;
}
