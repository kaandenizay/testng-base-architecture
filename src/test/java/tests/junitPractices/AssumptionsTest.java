package tests.junitPractices;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assumptions.assumeTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;


public class AssumptionsTest {


    @ParameterizedTest(name = "Run: {index} -   value: {arguments}")
    @ValueSource(ints = {1, 3, 5})
    public void intValues(int theParam) {
        assumeTrue(theParam > 4);
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest
    @CsvSource(value = {"kaan, 28, true", "ali, 41, true", "ismail, 5, true"})
    public void csvSource(String param1, int param2, boolean param3) {
        assumingThat(param2 > 20, () -> System.out.println("This code ran"));
        System.out.println("param1 = " + param1 + ", param2 = " + param2 + ", param3 = " + param3);
    }



}
