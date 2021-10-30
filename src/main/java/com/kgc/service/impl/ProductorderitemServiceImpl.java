package com.kgc.service.impl;

import com.kgc.mapper.ProductorderitemMapper;
import com.kgc.pojo.Productorderitem;
import com.kgc.service.ProductorderitemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductorderitemServiceImpl implements ProductorderitemService {
    @Resource
    ProductorderitemMapper productorderitemMapper;

    @Override
    public int getProductorderItemCount(Integer productorId) {
        return productorderitemMapper.getProductorderItemCount(productorId);
    }

    @Override
    public List<Productorderitem> getProductorderItemList(Integer productorderitemOrderId) {
        return productorderitemMapper.getProductorderItemList(productorderitemOrderId);
    }

    @Override
    public List<Productorderitem> getByProductorItemUserId(Integer userId) {
        return productorderitemMapper.getByProductorItemUserId(userId);
    }

    @Override
    public int getProductorderitemInsert(Productorderitem productorderitem) {
        return productorderitemMapper.getProductorderitemInsert(productorderitem);
    }

    @Override
    public int updateProductorderItemUpdate(Integer number, Integer productId, Integer userId) {
        return productorderitemMapper.updateProductorderItemUpdate(number,productId,userId);
    }

    @Override
    public int removeProductorItem(Integer productorderitemId) {
        return productorderitemMapper.removeProductorItem(productorderitemId);
    }
}
