package pl.camp.micro.book.store;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    Calculator calculator = new Calculator();
    final int a;

    public CalculatorTest() {
        this.a = 6;
        System.out.println("Test konstruktor");
    }

    @BeforeEach
    public void prepare() {
        System.out.println("przygotowanie !!");
    }

    @AfterEach
    public void clean() {
        System.out.println("czyszczenie !!");
    }

    @BeforeAll
    public static void prepareBeforeAll() {
        System.out.println("przygotowanie przed wszystkimi testami !!");
    }

    @AfterAll
    public static void cleanAfterAll() {
        System.out.println("czyszczenie po wszystkich testach !!");
    }

    @Test
    public void multiplyTwoPositivesTest() {
        int a = 5;
        int b = 3;
        int expectedResult = 15;

        int actual = calculator.multiply(a, b);

        Assertions.assertEquals(expectedResult, actual);
        //
    }

    @Test
    public void multiplyTwoNegativesTest() {
        int a = -5;
        int b = -6;
        int expectedResult = 30;

        int actual = calculator.multiply(a, b);

        Assertions.assertEquals(expectedResult, actual);
    }

    @Test
    public void divideTwoPositivesTest() {
        int a = 6;
        int b = 3;
        int expectedResult = 2;

        double actual = calculator.divide(a, b);

        Assertions.assertEquals(expectedResult, actual);
    }

    @Test
    public void divideTwoPositivesWithPointerResultTest() {
        int a = 5;
        int b = 2;
        double expectedResult = 2.5;

        double actual = calculator.divide(a, b);

        Assertions.assertEquals(expectedResult, actual, 0.001);
    }

    @Test
    public void divideByZeroTest() {
        final int a = 5;
        final int b = 0;

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(a,b));
    }
}
