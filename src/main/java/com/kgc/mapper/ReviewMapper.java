package com.kgc.mapper;

import org.apache.ibatis.annotations.Mapper;
//评论
@Mapper
public interface ReviewMapper {
    //计算评论次数
    int getReviewCount(Integer productId);
}
