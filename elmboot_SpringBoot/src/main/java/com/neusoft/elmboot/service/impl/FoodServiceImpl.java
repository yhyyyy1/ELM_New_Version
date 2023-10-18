package com.neusoft.elmboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.elmboot.model.entity.Food;
import com.neusoft.elmboot.model.vo.FoodVo;
import com.neusoft.elmboot.service.FoodService;
import com.neusoft.elmboot.mapper.FoodMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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
}




