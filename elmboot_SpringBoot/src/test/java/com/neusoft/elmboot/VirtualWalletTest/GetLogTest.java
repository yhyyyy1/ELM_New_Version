package com.neusoft.elmboot.VirtualWalletTest;

import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.mapper.TransactionFlowMapper;
import com.neusoft.elmboot.mapper.VirtualWalletMapper;
import com.neusoft.elmboot.model.bo.VirtualWallet;
import com.neusoft.elmboot.model.vo.TransactionFlowVo;
import com.neusoft.elmboot.service.impl.VirtualWalletServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class GetLogTest {

    @Mock
    private VirtualWalletMapper virtualWalletMapper;

    @InjectMocks
    private VirtualWalletServiceImpl virtualWalletService;

    @Mock
    private TransactionFlowMapper transactionFlowMapper;

    @Test
    void testGetLogSuccess() throws SQLException {
        // Arrange
        String userId = "testUser";
        VirtualWallet virtualWallet = new VirtualWallet();
        virtualWallet.setId(1L);
        when(virtualWalletMapper.getVirtualWallet(userId)).thenReturn(virtualWallet);
        when(transactionFlowMapper.getTransactionFlow(userId, virtualWallet.getId())).thenReturn(new ArrayList<>());

        // Act
        List<TransactionFlowVo> result = virtualWalletService.getLog(userId);

        // Assert
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @Test
    void testGetLogWalletNotFound() throws SQLException {
        // Arrange
        String userId = "testUser";
        when(virtualWalletMapper.getVirtualWallet(userId)).thenReturn(null);

        // Act & Assert
        assertThrows(BusinessException.class, () -> virtualWalletService.getLog(userId));
    }

}
