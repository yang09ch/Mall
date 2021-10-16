package com.kgc.service.impl;

import com.kgc.mapper.ReviewMapper;
import com.kgc.service.ReviewService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ReviewServiceImpl implements ReviewService {
    @Resource
    ReviewMapper reviewMapper;
}
