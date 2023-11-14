package com.neusoft.elmboot.service;

import com.neusoft.elmboot.model.bo.Point;
import com.neusoft.elmboot.model.bo.PointTurnover;
import com.neusoft.elmboot.model.vo.PointTurnoverVo;

import java.util.List;

public interface PointService {
    //todo: checkDate
    List<PointTurnover> checkDate(List<PointTurnover> pointTurnoverList);

    //todo: 获取state以A开头的PT
    List<PointTurnover> getUsefulPointTurnover(String userID);

    //todo: 消费时更新PT，按时间顺序更新
    List<PointTurnover> usePoint(List<PointTurnover> pointTurnoverList, Integer amount);

    //todo: 消费的new PT
    Integer LogUsePointTurnover(String userId, Integer amount);

    List<PointTurnoverVo> getPointTurnoverVoList(String userId);

    Point getPoint(String userId);

    Integer getPointBalance(String userId);

    List<PointTurnover> getPointTurnover(String userId);

    Integer updatePointTurnover(String userId, Integer amount);
}
