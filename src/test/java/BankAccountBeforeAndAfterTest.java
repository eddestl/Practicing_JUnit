import org.example.BankAccount;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// @TestInstance(TestInstance.Lifecycle.PER_CLASS) Able to have @BeforeAll and @AfterAll non-static
public class BankAccountBeforeAndAfterTest {

    static BankAccount bankAccount;

    @BeforeEach
    public void prepTest(){
        bankAccount = new BankAccount(500,0);
    }
    @Test
    public void testWithdraw(){
        bankAccount.withdraw(300);
        assertEquals(200, bankAccount.getBalance());
    }

    @Test

    public void testDeposit(){
        bankAccount.deposit(500);
        assertEquals(1000, bankAccount.getBalance());
    }

    @AfterEach
    public void endTest(){
        System.out.println("Bye");
    }
}


