package com.neusoft.elmboot.PointTest;

import com.neusoft.elmboot.mapper.PointMapper;
import com.neusoft.elmboot.mapper.PointTurnoverMapper;
import com.neusoft.elmboot.model.bo.Point;
import com.neusoft.elmboot.model.bo.PointTurnover;
import com.neusoft.elmboot.model.vo.PointTurnoverVo;
import com.neusoft.elmboot.service.impl.PointServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GetPointTurnoverVoListTest {
    @Mock
    private PointMapper pointMapper;

    @InjectMocks
    private PointServiceImpl pointService;

    @Mock
    private PointTurnoverMapper pointTurnoverMapper;

    @Test
    void testGetPointTurnoverVoListSuccess() throws SQLException {
        // Arrange
        String userId = "user";
        Point point = new Point();
        point.setId(1L);
        point.setUserId(userId);
        List<PointTurnover> pointTurnovers = new ArrayList<>();

        when(pointMapper.getPoint(userId)).thenReturn(point);
        when(pointTurnoverMapper.getPointTurnover(point.getId(), userId)).thenReturn(pointTurnovers);

        // Act
        List<PointTurnoverVo> result = pointService.getPointTurnoverVoList(userId);

        // Assert
        assertNotNull(result);
    }

}
