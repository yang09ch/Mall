package com.kgc.service.impl;

import com.kgc.mapper.ProductorderMapper;
import com.kgc.pojo.Productorder;
import com.kgc.service.ProductorderService;
import com.kgc.util.PageUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProductorderServiceImpl implements ProductorderService {
    @Resource
    ProductorderMapper productorderMapper;

    @Override
    public PageUtil<Productorder> getProductorderPage(String productorderCode, String productorderPost, Integer pageIndex, Integer pageSize, Object...productorderStatus) {
        PageUtil<Productorder> pageUtil=new PageUtil<>();
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setPageSize(pageSize);
        return pageUtil;
    }

    @Override
    public PageUtil<Productorder> getProductorderLimit(String productorderStatus,Integer productorderUserId, Integer pageIndex, Integer pageSize) {
        PageUtil<Productorder> pageUtil=new PageUtil<>();
        pageUtil.setPageIndex(pageIndex);
        pageUtil.setPageSize(pageSize);
        pageUtil.setTotalCount(productorderMapper.getProductorderCount(productorderStatus,productorderUserId));
        pageUtil.setList(productorderMapper.getProductorderList(productorderStatus, productorderUserId,(pageIndex)*pageSize, pageSize));
        if (pageUtil==null){
            pageUtil.setHasPrev(false);
        }else {
            pageUtil.setHasPrev(true);
        }
        return pageUtil;
    }

    @Override
    public int removeProductor(String productorderCode) {
        return productorderMapper.removeProductor(productorderCode);
    }

    @Override
    public Productorder getByProductorCode(String productorderCode) {
        return productorderMapper.getByProductorCode(productorderCode);
    }

    @Override
    public int updateProductorStatus(String productorderCode) {
        return productorderMapper.updateProductorStatus(productorderCode);
    }

    @Override
    public int addProductor(Productorder productorder) {
        return productorderMapper.addProductor(productorder);
    }

    @Override
    public int updateProductor(Productorder productorder) {
        return productorderMapper.updateProductor(productorder);
    }

    @Override
    public List<Productorder> getTotalByDate(String beginDate, String endDate) {
        return productorderMapper.getProductorderDate(beginDate, endDate);
    }
}
