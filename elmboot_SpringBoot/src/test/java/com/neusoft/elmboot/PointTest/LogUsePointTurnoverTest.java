package com.neusoft.elmboot.PointTest;

import com.neusoft.elmboot.mapper.PointMapper;
import com.neusoft.elmboot.mapper.PointTurnoverMapper;
import com.neusoft.elmboot.model.bo.Point;
import com.neusoft.elmboot.service.impl.PointServiceImpl;
import com.neusoft.elmboot.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class LogUsePointTurnoverTest {
    @Mock
    private PointMapper pointMapper;

    @InjectMocks
    private PointServiceImpl pointService;

    @Mock
    private PointTurnoverMapper pointTurnoverMapper;

    @Test
    void testLogUsePointTurnoverSuccess() throws SQLException {
        // Arrange
        String userId = "110";
        Integer amount = 50;
        Point point = new Point();
        point.setId(1L);
        point.setUserId(userId);

        when(pointMapper.getPoint(userId)).thenReturn(point);
        when(pointTurnoverMapper.saveUsePointTurnover(point.getId(), userId, "D", amount, DateUtil.getTodayString())).thenReturn(1);

        // Act
        Integer result = pointService.LogUsePointTurnover(userId, amount);

        // Assert
        assertNotNull(result);
        assertEquals(1, result); // 预期返回值为 1，表示成功
    }

}
