import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class AccountTest {
    private Account account;

    @Before
    public void setUp() {
        account = new Account();
    }

    @Test
    public void testInitialBalance() {
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    public void testDeposit() {
        account.deposit(100.0);
        assertEquals(100.0, account.getBalance(), 0.001);

        account.deposit(50.0);
        assertEquals(150.0, account.getBalance(), 0.001);
    }

    @Test
    public void testWithdrawSufficientBalance() {
        account.deposit(200.0);
        double withdrawnAmount = account.withdraw(100.0);
        assertEquals(100.0, withdrawnAmount, 0.001);
        assertEquals(100.0, account.getBalance(), 0.001);
    }

    // Test for withdrawal when balance is insufficient
    @Test
    public void testWithdrawInsufficientBalance() {
        account.deposit(50.0);
        double withdrawnAmount = account.withdraw(100.0);
        assertEquals(0.0, withdrawnAmount, 0.001);
        assertEquals(50.0, account.getBalance(), 0.001);
    }

    @Test
    public void testNegativeDeposit() {
        account.deposit(-100.0);
        assertEquals(0.0, account.getBalance(), 0.001);
    }

    @Test
    public void testNegativeWithdraw() {
        account.deposit(100.0);
        double withdrawnAmount = account.withdraw(-50.0);
        assertEquals(0.0, withdrawnAmount, 0.001);
        assertEquals(100.0, account.getBalance(), 0.001);
    }
}
