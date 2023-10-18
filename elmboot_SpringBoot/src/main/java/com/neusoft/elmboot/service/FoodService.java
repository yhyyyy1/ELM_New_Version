package com.neusoft.elmboot.service;

import com.neusoft.elmboot.model.entity.Food;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.elmboot.model.vo.FoodVo;

import java.util.List;

/**
* @author 14505
* @description 针对表【food】的数据库操作Service
* @createDate 2023-10-12 13:00:49
*/
public interface FoodService extends IService<Food> {

    /**
     * 列出某个商家的商品
     * @param businessId
     * @return
     */
    List<FoodVo> listFoodByBusinessId(Integer businessId);
}
