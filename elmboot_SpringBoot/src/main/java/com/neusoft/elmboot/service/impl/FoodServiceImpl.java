package com.neusoft.elmboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.elmboot.model.dto.food.FoodQueryRequest;
import com.neusoft.elmboot.model.entity.Food;
import com.neusoft.elmboot.model.vo.FoodVo;
import com.neusoft.elmboot.service.FoodService;
import com.neusoft.elmboot.mapper.FoodMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 14505
 * @description 针对表【food】的数据库操作Service实现
 * @createDate 2023-10-12 13:00:49
 */
@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food>
        implements FoodService {

    /**
     * 列出某个商家的商品
     *
     * @param businessId
     * @return
     */
    @Override
    public List<FoodVo> listFoodByBusinessId(Integer businessId) {
        return null;
    }

    /**
     * 实体对象封装操作类
     *
     * @param foodQueryRequest
     * @return
     */
    @Override
    public QueryWrapper<Food> getQueryWrapper(FoodQueryRequest foodQueryRequest) {
        QueryWrapper<Food> queryWrapper = new QueryWrapper<>();
        if (foodQueryRequest == null) {
            return null;
        }
        Integer businessId = foodQueryRequest.getBusinessId();

        queryWrapper.eq(ObjectUtils.isNotEmpty(businessId), "BusinessId", businessId);
        return queryWrapper;
    }

    public FoodVo getFoodVo(Food food) {
        if (food == null) {
            return null;
        }
        FoodVo foodVo = new FoodVo();
        BeanUtils.copyProperties(food, foodVo);
        return foodVo;
    }

    public List<FoodVo> getFoodVo(List<Food> foodList) {
        if (CollectionUtils.isEmpty(foodList)) {
            return new ArrayList<>();
        }
        return foodList.stream().map(this::getFoodVo).collect(Collectors.toList());
    }
}




