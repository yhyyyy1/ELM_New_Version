package com.neusoft.elmboot.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.neusoft.elmboot.model.entity.Business;
import com.neusoft.elmboot.model.vo.BusinessVo;
import com.neusoft.elmboot.service.BusinessService;
import com.neusoft.elmboot.mapper.BusinessMapper;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author 14505
* @description 针对表【business】的数据库操作Service实现
* @createDate 2023-10-12 13:00:59
*/
@Service
public class BusinessServiceImpl extends ServiceImpl<BusinessMapper, Business>
    implements BusinessService{

    /**
     * 通过商家的类型获取商家信息列表
     * @param orderTypeId
     * @return
     */
    @Override
    public List<BusinessVo> listBusinessVoByOrderTypeId(Integer orderTypeId) {
        return null;
    }

    /**
     * 通过商家Id获取商家信息
     *
     * @param businessId
     * @return
     */
    @Override
    public BusinessVo getBusinessVoById(Integer businessId) {
        return null;
    }

    /**
     * 通过商家的名字查询商家——模糊匹配
     *
     * @param businessName
     * @return
     */
    @Override
    public List<BusinessVo> listBusinessVoByBusinessName(String businessName) {
        return null;
    }
}




