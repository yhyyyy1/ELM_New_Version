package com.neusoft.elmboot.VirtualWalletTest;

import com.neusoft.elmboot.exception.BusinessException;
import com.neusoft.elmboot.mapper.VirtualWalletMapper;
import com.neusoft.elmboot.model.bo.VirtualWallet;
import com.neusoft.elmboot.service.impl.VirtualWalletServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@SpringBootTest
public class ExpenseTest {

    @Mock
    private VirtualWalletMapper virtualWalletMapper;

    @InjectMocks
    private VirtualWalletServiceImpl virtualWalletService;

    @Test
    void testExpenseSuccess() throws SQLException {
        // Arrange
        String userId = "testUser";
        Integer amount = 50;
        VirtualWallet virtualWallet = new VirtualWallet();
        virtualWallet.setBalance(100);
        when(virtualWalletMapper.getVirtualWallet(userId)).thenReturn(virtualWallet);
        when(virtualWalletMapper.updateVirtualWallet(userId, 50)).thenReturn(1);

        // Act
        int result = virtualWalletService.expense(userId, amount);

        // Assert
        assertEquals(1, result);
    }

    @Test
    void testExpenseWalletNotFound() throws SQLException {
        // Arrange
        String userId = "testUser";
        Integer amount = 50;
        when(virtualWalletMapper.getVirtualWallet(userId)).thenReturn(null);

        // Act & Assert
        assertThrows(BusinessException.class, () -> virtualWalletService.expense(userId, amount));
    }
}
