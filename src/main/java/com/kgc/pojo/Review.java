package com.kgc.pojo;

import lombok.Data;
//评论
import java.io.Serializable;
@Data
public class Review implements Serializable {
    private Integer reviewId;//主键
            private String  reviewContent;//评论内容
    private String  reviewCreateDate;//创建时间
            private Integer reviewUserId;//评论人
    private Integer reviewProductId;//商品id
            private Integer reviewOrderItemId;//订单明细表的id'
    private User reviewUser;

}
