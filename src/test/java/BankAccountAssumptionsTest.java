import org.example.BankAccount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.*;

public class BankAccountAssumptionsTest {


    @Test
    @DisplayName("BankAccount is active when created")
    public void testIsActive(){
        BankAccount bankAccount = new BankAccount(500, -1000);
        assumingThat(bankAccount != null, () -> assertTrue(bankAccount.isActive()));
    }
}
