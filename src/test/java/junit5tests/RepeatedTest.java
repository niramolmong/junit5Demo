package junit5tests;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.Test;

public class RepeatedTest {
    @Test
    @org.junit.jupiter.api.RepeatedTest(5)
    void firstRepeatedMethod(){
        System.out.println("Repeat first method");
    }

    @Test
    @org.junit.jupiter.api.RepeatedTest(value = 3, name = "Running repetition: {currentRepetition}." + " Total is: {totalRepetitions}")
    void secondRepeatedMethod(){
        System.out.println("Repeat second method");
    }

    @Test
    @org.junit.jupiter.api.RepeatedTest(3)
    void thirdRepeatedMethod(RepetitionInfo repetitionInfo){
        System.out.println("Repeat third method");
        Assumptions.assumingThat(repetitionInfo.getCurrentRepetition() == 3, () -> System.out.println("This code only run for  repetition = " + "3"));
    }

}
