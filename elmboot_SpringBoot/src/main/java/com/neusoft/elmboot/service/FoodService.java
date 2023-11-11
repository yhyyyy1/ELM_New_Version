package com.neusoft.elmboot.service;

import java.util.List;

import com.neusoft.elmboot.model.vo.FoodVo;

public interface FoodService {
    public List<FoodVo> listFoodByBusinessId(Integer businessId);
}