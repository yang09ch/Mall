package com.kgc.service;

import com.kgc.pojo.Review;

import java.util.List;

public interface ReviewService {
    //计算评论次数
    int getReviewCount(Integer productId);
    /**
     * 获商品的评论
     */
    List<Review> getReviewByProductId(Integer productid);

}
