package com.neusoft.elmboot.VirtualWalletTest;

import com.neusoft.elmboot.mapper.VirtualWalletMapper;
import com.neusoft.elmboot.model.bo.VirtualWallet;
import com.neusoft.elmboot.model.vo.VirtualWalletVo;
import com.neusoft.elmboot.service.impl.VirtualWalletServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class GetWalletTest {
    @Mock
    private VirtualWalletMapper virtualWalletMapper;

    @InjectMocks
    private VirtualWalletServiceImpl virtualWalletService;

    @Test
    void testGetWalletSuccess() throws SQLException {

        // Arrange
        String userId = "110";
        VirtualWallet virtualWallet = new VirtualWallet();
        virtualWallet.setUserId(userId);
        when(virtualWalletMapper.getVirtualWallet(userId)).thenReturn(virtualWallet);

        // Act
        VirtualWalletVo result = virtualWalletService.getWallet(userId);

        // Assert
        assertNotNull(result);
        assertEquals(userId, result.getUserId());
    }

    @Test
    void testGetWalletThrowsException() throws SQLException {
        // Arrange
        String userId = "1101";
        when(virtualWalletMapper.getVirtualWallet(userId)).thenThrow(SQLException.class);

        // Act & Assert
        assertThrows(RuntimeException.class, () -> virtualWalletService.getWallet(userId));
    }
}
