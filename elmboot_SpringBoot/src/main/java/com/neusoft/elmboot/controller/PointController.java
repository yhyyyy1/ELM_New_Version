package com.neusoft.elmboot.controller;

import com.neusoft.elmboot.common.BaseResponse;
import com.neusoft.elmboot.common.ErrorCode;
import com.neusoft.elmboot.common.ResultUtils;
import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.model.bo.Point;
import com.neusoft.elmboot.model.bo.PointTurnover;
import com.neusoft.elmboot.model.vo.PointTurnoverVo;
import com.neusoft.elmboot.service.BusinessService;
import com.neusoft.elmboot.service.PointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/point")
public class PointController {

    @Autowired
    private PointService pointService;

    /**
     * 获取用户积分余额——对应业务1
     *
     * @param userId
     * @return
     */
    public BaseResponse<Integer> getPointBalance(String userId) {
        if (userId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        Integer result = pointService.getPointBalance(userId);
        if (result >= 0) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，查询用户积分余额失败");
        }
    }

    /**
     * 获取积分
     *
     * @param userId
     * @return
     */
    public BaseResponse<Integer> updatePointTurnover(String userId, Integer amount) {
        if (userId == null || amount == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        if (amount <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "获得的积分不可以为负数");
        }
        Integer result = pointService.updatePointTurnover(userId, amount);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，查询用户积分余额失败");
        }
    }

    public BaseResponse<Integer> usePoint(String userId, Integer amount) {
        if (userId == null || amount == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        if (amount <= 0) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "获得的积分不可以为负数");
        }
        Integer result = pointService.updatePointTurnover(userId, amount);
        if (result.equals(1)) {
            return ResultUtils.success(result);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，查询用户积分余额失败");
        }
    }

    /**
     * 获取用户的积分使用明细
     *
     * @param userId
     * @return
     */
    public BaseResponse<List<PointTurnoverVo>> getPointTurnoverVo(String userId) {
        if (userId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        List<PointTurnoverVo> pointTurnoverVoList = pointService.getPointTurnoverVoList(userId);
        if (pointTurnoverVoList != null) {
            return ResultUtils.success(pointTurnoverVoList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取积分使用明细失败");
        }
    }

    /**
     * 获取可使用的积分明细（因为状态的更新不是实时的，所以此处获取的并不是最后使用的）
     *
     * @param userId
     * @return
     */
    private BaseResponse<List<PointTurnover>> getUsefulPointTurnover(String userId) {
        if (userId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        List<PointTurnover> pointTurnoverList = pointService.getPointTurnover(userId);
        if (pointTurnoverList != null) {
            return ResultUtils.success(pointTurnoverList);
        } else {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取积分使用明细失败");
        }
    }

    /**
     * 获取用户积分表
     *
     * @param userId
     * @return
     */
    private BaseResponse<Point> getPoint(String userId) {
        if (userId == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "请求参数不可为空");
        }
        Point point = pointService.getPoint(userId);
        if (point == null) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "数据库操作失败，获取用户积分详情失败");
        } else {
            return ResultUtils.success(point);
        }
    }
}
