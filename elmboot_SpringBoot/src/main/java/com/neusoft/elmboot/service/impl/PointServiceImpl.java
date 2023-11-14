package com.neusoft.elmboot.service.impl;

import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.mapper.PointMapper;
import com.neusoft.elmboot.mapper.PointTurnoverMapper;
import com.neusoft.elmboot.model.bo.Point;
import com.neusoft.elmboot.model.bo.PointTurnover;
import com.neusoft.elmboot.model.vo.PointTurnoverVo;
import com.neusoft.elmboot.service.PointService;
import com.neusoft.elmboot.util.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PointServiceImpl implements PointService {
    @Autowired
    private PointMapper pointMapper;

    @Autowired
    private PointTurnoverMapper pointTurnoverMapper;

    @Override
    public List<PointTurnover> checkDate(List<PointTurnover> pointTurnoverList) {
        String DateNow = DateUtil.getTodayString();
        DateNow = DateUtil.roundUpToDay(DateNow);
        Iterator<PointTurnover> iterator = pointTurnoverList.iterator();
        while (iterator.hasNext()) {
            PointTurnover pointTurnover = iterator.next();
            String createTime = pointTurnover.getCreateTime();
            createTime = DateUtil.roundUpToDay(createTime);

            if (!DateUtil.compareDate(createTime, DateNow)) {
                //如果超过一年，过期了，就更新pointTurnover表
                //todo: 更新状态
                //并且将这个元素从List中删除
                iterator.remove();
            }
        }
        return pointTurnoverList;
    }

    @Override
    public List<PointTurnover> getUsefulPointTurnover(String userID) {
        return null;
    }

    @Override
    public List<PointTurnover> usePoint(List<PointTurnover> pointTurnoverList, Integer amount) {
        return null;
    }

    @Override
    public Integer LogUsePointTurnover(String userId, Integer amount) {
        return null;
    }

    @Override
    public List<PointTurnoverVo> getPointTurnoverVoList(String userId) {
        try {
            Point point = this.getPoint(userId);
            List<PointTurnover> pointTurnoverList = pointTurnoverMapper.getPointTurnover(point.getId(), userId);
            return getPointTurnoverVo(pointTurnoverList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Integer getPointBalance(String userId) {
        return null;
    }

    @Override
    public List<PointTurnover> getPointTurnover(String userId) {
        return null;
    }

    @Override
    public Integer updatePointTurnover(String userId, Integer amount) {
        return null;
    }

    @Override
    public Point getPoint(String userId) {
        if (userId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        try {
            return pointMapper.getPoint(userId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public PointTurnoverVo getPointTurnoverVo(PointTurnover pointTurnover) {
        if (pointTurnover == null) {
            return null;
        }
        PointTurnoverVo pointTurnoverVo = new PointTurnoverVo();
        BeanUtils.copyProperties(pointTurnover, pointTurnoverVo);
        return pointTurnoverVo;
    }


    public List<PointTurnoverVo> getPointTurnoverVo(List<PointTurnover> pointTurnoverList) {
        if (CollectionUtils.isEmpty(pointTurnoverList)) {
            return new ArrayList<>();
        }
        return pointTurnoverList.stream().map(this::getPointTurnoverVo).collect(Collectors.toList());
    }
}
