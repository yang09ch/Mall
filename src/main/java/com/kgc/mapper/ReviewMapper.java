package com.kgc.mapper;

import com.kgc.pojo.Review;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

//评论
@Mapper
public interface ReviewMapper {
    //计算评论次数
    int getReviewCount(Integer productId);
    /**
     * 获商品的评论
     */
    List<Review> getReviewByProductId(Integer productid);
}
