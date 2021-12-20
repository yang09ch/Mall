package com.kgc.service;

import com.kgc.pojo.Productorder;
import com.kgc.util.PageUtil;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 商品订单 业务
 */
public interface ProductorderService {
    PageUtil<Productorder> getProductorderPage(
            String productorderCode,String productorderPost,Integer pageIndex,Integer pageSize,Object...productorderStatus);
    /**
     * 详情
     *  分页查询订单 根据状态查询所有订单
     */
    PageUtil<Productorder> getProductorderLimit(String productorderStatus,Integer productorderUserId
            ,Integer pageIndex,Integer pageSize);
    /**
     * 根据订单号 进行删除
     * @param productorderCode
     * @return
     */
    int removeProductor(String productorderCode);
    /**
     * 根据订单号 查询
     */
    Productorder getByProductorCode( String productorderCode);
    /**
     * 确定收货  将订单状态改为3
     */
    int updateProductorStatus(@Param("productorderCode")String productorderCode);
    /**
     * 订单新增
     * @param productorder
     * @return
     */
    int addProductor(Productorder productorder);
    /**
     *  修改订单信息
     */
    int updateProductor(Productorder productorder);
    List<Productorder> getTotalByDate(Date beginDate, Date endDate);
}
