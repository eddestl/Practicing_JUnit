import org.example.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test BankAccount class")
public class BankAccountTest {

    @Test
    @DisplayName("Withdraw 200 successfully")
    public void testWithdraw(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test
    @DisplayName("Deposit 500 successfully")
    public void testDeposit(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.deposit(500);
        assertEquals(1000, bankAccount.getBalance());
    }


    @Test
    @DisplayName("Withdraw will become negative")
    public void testWithdrawNotStuckAtZero(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        bankAccount.withdraw(800);
        assertNotEquals(0, bankAccount.getBalance());
    }

    @Test
    @DisplayName("BankAccount is active when created")
    public void testIsActive(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertTrue(bankAccount.isActive());
    }

    @Test
    @DisplayName("Test AccountHolder not null")
    public void testBankAccountHolder(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertNull(bankAccount.getBankAccountHolder());
        bankAccount.setBankAccountHolder("Amanda");
        assertNotNull(bankAccount.getBankAccountHolder());

    }

    @Test
    @DisplayName("Test that we can't withdraw below minimum")
    public void testNoWithdrawBelowMinimum(){
        BankAccount bankAccount = new BankAccount(500, -1000);

        assertThrows(RuntimeException.class,() -> bankAccount.withdraw(2000));

    }

    @Test
    @DisplayName("Test no exceptions for withdraw and deposit")
    public void testWithdrawAndDepositWithoutExceptions(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertAll(() ->bankAccount.deposit(200), () -> bankAccount.withdraw(300));
    }

    @Test
    @DisplayName("Test speed deposit")
    public void testDepositTimeout(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assertTimeout(Duration.ofNanos(1), () -> bankAccount.deposit(200));
    }
}
