import org.junit.Test;
import org.lld.models.User;
import org.lld.service.impl.BalanceService;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class SplitwiseTest {
    BalanceService balanceService = new BalanceService();
    @Test
    public void ExampleTestCase() {
        Map<User, Map<User, Double>> balances = balanceService.getBalances();
        assertEquals(0, balances.size());
    }

}
