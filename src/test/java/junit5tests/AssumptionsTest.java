package junit5tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.provider.ValueSource;

public class AssumptionsTest {

    @org.junit.jupiter.params.ParameterizedTest(name = "Run {index} - value: {arguments}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void intValues(int theParam){
        Assumptions.assumeTrue(theParam > 4);
        System.out.println("theParam = " + theParam);
    }
    //test rebase

    //test2 rebase
}
