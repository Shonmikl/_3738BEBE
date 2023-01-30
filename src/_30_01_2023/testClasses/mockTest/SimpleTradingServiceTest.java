package _30_01_2023.testClasses.mockTest;

import _30_01_2023.mockClasses.mock.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyLong;

@ExtendWith(MockitoExtension.class)
public class SimpleTradingServiceTest {

    @Mock
    TradeRepository tradeRepository;

    @Mock
    AuditService auditService;

    @Mock
    Trade trade;

    @Test
    public void testAuditLodEntryMAdeForNewTrade() {
        //Trade trade = new Trade("Test", "Test");
        Mockito.when(tradeRepository.createTrade(trade))
                .thenReturn(anyLong());
        TradingService tradingService
                = new SimpleTradingService(tradeRepository, auditService);

        tradingService.createTrade(trade);

        Mockito.verify(auditService).logNewTrade(trade);
    }
}