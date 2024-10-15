package tests.junitPractices;

import org.junit.jupiter.api.*;

public class RepeatedTests {

    @RepeatedTest(value = 6)
    void firstMethod(){
        System.out.println("First method is executed");
    }

    @RepeatedTest(value = 3, name = "Running repetition method: {currentRepetition} .Total is: {totalRepetitions}")
    @DisplayName("This is a repeated test method")
    void secondMethod(){
        System.out.println("Repetition method is executed");
    }

    @RepeatedTest(value = 3)
    void thirdMethod(RepetitionInfo repetitionInfo){
        System.out.println("Repetition method is executed");
        Assumptions.assumingThat(repetitionInfo.getCurrentRepetition() == 3,
                () -> System.out.println("This code only runs when repetion is 3"));
    }
}
