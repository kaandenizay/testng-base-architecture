package tests.junitPractices;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class ParametrizedTest {


    @ParameterizedTest(name = "Run: {index} -   value: {arguments}")
    @ValueSource(ints = {1, 3, 5})
    public void intValues(int theParam) {
        System.out.println("theParam = " + theParam);
    }

    @ParameterizedTest(name = "Run: {index} -   value: {arguments}")
    @ValueSource(strings = {"kaan", "denizay"})
    public void stringValues(String theParam) {
        System.out.println("theParam = " + theParam);
    }


    @ParameterizedTest
    @CsvSource(value = {"kaan, denizay", "ali, atay"})
    public void csvSource(String param1, String param2) {
        System.out.println("param1 = " + param1);
        System.out.println("param2 = " + param2);
    }

    @ParameterizedTest
    @CsvFileSource(files = {"src/test/resources/shoppingList.csv",
            "src/test/resources/shoppingList2.csv"},
            numLinesToSkip = 1)
    public void csvSourceFile(String name, double price, int quantity, String uom, String provider) {
        System.out.println("name = " + name + ", " +
                "price = " + price + ", " +
                "quantity = " + quantity + ", " +
                "uom = " + uom + ", provider = " + provider);
    }

    @ParameterizedTest
    @MethodSource(value = {"sourceStringStream", "sourceString"})
    public void methodSource(String param1) {
        System.out.println("param1 = " + param1);
    }

    static List<String> sourceString() {
        return Arrays.asList("tomato", "carrot", "cabbage");
    }

    static Stream<String> sourceStringStream() {
        return Stream.of("beetroot", "apple", "pear");
    }
}
