package com.neusoft.elmboot.controller;

import java.util.List;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.model.vo.FoodVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.elmboot.model.bo.Food;
import com.neusoft.elmboot.service.FoodService;

@RestController
@RequestMapping("/FoodController")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @RequestMapping("/listFoodByBusinessId")
    public BaseResponse<List<FoodVo>> listFoodByBusinessId(Food food) throws Exception {
        if (food.getBusinessId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        List<FoodVo> foodVoList = foodService.listFoodByBusinessId(food.getBusinessId());
        if (foodVoList != null) {
            return ResultUtils.success(foodVoList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取当前商家的商品列表失败");
        }
    }

}
