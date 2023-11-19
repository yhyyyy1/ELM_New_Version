package com.neusoft.elmboot.PointTest;

import com.neusoft.elmboot.mapper.PointMapper;
import com.neusoft.elmboot.model.bo.Point;
import com.neusoft.elmboot.service.impl.PointServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GetPointTest {
    @Mock
    private PointMapper pointMapper;

    @InjectMocks
    private PointServiceImpl pointService;

    @Test
    void testGetPointSuccess() throws SQLException {
        // Arrange
        String userId = "testUser";
        Point point = new Point();
        point.setUserId(userId);
        when(pointMapper.getPoint(userId)).thenReturn(point);

        // Act
        Point result = pointService.getPoint(userId);

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getUserId());
    }

    @Test
    void testGetPointThrowsException() throws SQLException {
        // Arrange
        String userId = "testUser";
        when(pointMapper.getPoint(userId)).thenThrow(SQLException.class);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> pointService.getPoint(userId));
    }
}
