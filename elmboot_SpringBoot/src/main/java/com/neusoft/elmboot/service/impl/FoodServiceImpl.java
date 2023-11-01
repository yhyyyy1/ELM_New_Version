package com.neusoft.elmboot.service.impl;

import java.util.List;

import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.exception.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.neusoft.elmboot.mapper.FoodMapper;
import com.neusoft.elmboot.model.po.Food;
import com.neusoft.elmboot.service.FoodService;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodMapper foodMapper;

    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        if(){
            throw new BusinessException(ErrorCode.SYSTEM_ERROR);
        }
        return foodMapper.listFoodByBusinessId(businessId);
    }
}
