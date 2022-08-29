import model.Customer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void TestingRegEXFail() {
        // Setup --> Expecting to Fail
        Customer customer = new Customer("Chris", "James", "jaes.gmail.com");
        // Execution --> Not Needed since all I should have to do is instance of, which shouldn't even really run
        // because the error will be thrown first.
        // Assertion
        assertTrue(customer instanceof Customer);

//        ????????
//        assertThrows(IllegalArgumentException.class ->{
//            Customer customer = new Customer("Chris", "James", "jaes.gmail.com");
//        });
//        ????????
    }
    @Test
    public void TestingRegExPass(){
        Customer customer = new Customer("Chris", "James", "chris.james@gmail.com");
        // Execution --> Not needed for same reason as stated above, but it should pass now.
        // Assertion
        assertTrue(customer instanceof Customer);
    }
}

