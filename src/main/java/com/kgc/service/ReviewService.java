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

    /**
     * 获取是否已经评论
     * @param productId
     * @return
     */
    boolean getIsReview(Integer productId);
    /**
     * 新增评论
     */
    int addReview(Review review);

}
