package com.neusoft.elmboot.service;

import com.neusoft.elmboot.model.entity.Business;
import com.baomidou.mybatisplus.extension.service.IService;
import com.neusoft.elmboot.model.vo.BusinessVo;

import java.util.List;

/**
 * @author 14505
 * @description 针对表【business】的数据库操作Service
 * @createDate 2023-10-12 13:00:59
 */
public interface BusinessService extends IService<Business> {
    /**
     * 通过商家的类型获取商家信息列表
     *
     * @param orderTypeId
     * @return
     */
    List<BusinessVo> listBusinessVoByOrderTypeId(Integer orderTypeId);

    /**
     * 通过商家Id获取商家信息
     *
     * @param businessId
     * @return
     */
    BusinessVo getBusinessVoById(Integer businessId);

    /**
     * 通过商家的名字查询商家——模糊匹配
     *
     * @param businessName
     * @return
     */
    List<BusinessVo> listBusinessVoByBusinessName(String businessName);
}
