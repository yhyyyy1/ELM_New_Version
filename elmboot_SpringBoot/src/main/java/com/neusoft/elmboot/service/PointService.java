package com.neusoft.elmboot.service;

import com.neusoft.elmboot.model.bo.Point;
import com.neusoft.elmboot.model.bo.PointTurnover;
import com.neusoft.elmboot.model.vo.PointTurnoverVo;

import java.util.List;

public interface PointService {
    List<PointTurnover> checkDate(List<PointTurnover> pointTurnoverList);

    List<PointTurnover> getUsefulPointTurnover(String userID);

    List<PointTurnover> usePoint(List<PointTurnover> pointTurnoverList, Integer amount);

    Integer LogUsePointTurnover(String userId, Integer amount);

    List<PointTurnoverVo> getPointTurnoverVoList(String userId);

    Point getPoint(String userId);

    Integer getPointBalance(String userId);

    List<PointTurnover> getPointTurnover(String userId);

    Integer updatePointTurnover(String userId, Integer amount);
}
