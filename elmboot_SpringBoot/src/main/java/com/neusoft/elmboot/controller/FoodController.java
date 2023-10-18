package com.neusoft.elmboot.controller;

import java.util.List;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.model.dto.food.FoodQueryRequest;
import com.neusoft.elmboot.model.vo.FoodVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.neusoft.elmboot.service.FoodService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/FoodController")
public class FoodController {

    @Resource
    private FoodService foodService;

    /**
     * 列出某个商家的商品
     *
     * @param foodQueryRequest
     * @return
     * @throws Exception
     */
    @RequestMapping("/listFoodByBusinessId")
    public BaseResponse<List<FoodVo>> listFoodByBusinessId(FoodQueryRequest foodQueryRequest) throws Exception {
        if (foodQueryRequest.getBusinessId() == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        List<FoodVo> foodVoList = foodService.listFoodByBusinessId(foodQueryRequest.getBusinessId());
        if (foodVoList.isEmpty()) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        return ResultUtils.success(foodVoList);
    }
}
