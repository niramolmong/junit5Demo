package junit5tests;

import listeners.Listener;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(Listener.class)
public class DisabledEnabledTest {

    @Test
    @DisplayName("First test method")
    @Disabled(value = "Disable this test") // this test will not run
    void firstMethod(){
        System.out.println("First test method");
    }
    @Test
    @DisabledOnOs(value = OS.MAC)
    @DisplayName("Second test method")
    void secondMethod(){
        System.out.println("Second test method");
    }
    @Test
    @DisplayName("Third test method")
    void thirdMethod(){
        System.out.println("Third test method");
    }
    @Test
    @DisplayName("Forth test method")
    void forthMethod(){
        System.out.println("Forth test method");
    }
    @Test
    @DisplayName("Fifth test method")
    void fifthMethod(){
        System.out.println("Fifth test method");
    }


}
