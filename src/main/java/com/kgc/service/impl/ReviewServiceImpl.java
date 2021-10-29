package com.kgc.service.impl;

import com.kgc.mapper.ReviewMapper;
import com.kgc.pojo.Review;
import com.kgc.service.ReviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Resource
    ReviewMapper reviewMapper;

    @Override
    public int getReviewCount(Integer productId) {
        return reviewMapper.getReviewCount(productId);
    }

    @Override
    public List<Review> getReviewByProductId(Integer productid) {
        return reviewMapper.getReviewByProductId(productid);
    }

    @Override
    public boolean getIsReview(Integer productId) {
        if (reviewMapper.getReviewCount(productId)>0){
            return true;
        }else {
            return false;
        }
    }
}
