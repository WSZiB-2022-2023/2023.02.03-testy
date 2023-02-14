package pl.edu.wszib.testy;

import org.junit.jupiter.api.*;

public class CalculatorTest {
    static Calculator calculator = new Calculator();

    public CalculatorTest() {
        System.out.println("Konstruktor klasy testujacej !!!");
    }

    @BeforeEach
    public void prepare() {
        System.out.println("przygotowanie do testu !!!");
    }

    @AfterEach
    public void clean() {
        System.out.println("czyszczenie po teście !!!");
    }

    @BeforeAll
    public static void prepareAll() {
        System.out.println("Przygotowanie przed wszystkimi testami !!!");
    }

    @AfterAll
    public static void clearAfterAll() {
        System.out.println("Czyszczenie po wszystkich testach !!!");
    }

    @Test
    public void multiplyTwoPositivesTest() {
        int a = 4;
        int b = 5;
        int expectedResult = 20;

        int actual = calculator.multiply(a, b);

        Assertions.assertEquals(expectedResult, actual);
    }

    @Test
    public void multiplyPositiveAndNegativeTest() {
        int a = 5;
        int b = -5;
        int expectedResult = -25;

        int actual = calculator.multiply(a, b);

        Assertions.assertEquals(expectedResult, actual);
    }

    @Test
    public void divideTwoPositivesTest() {
        int a = 6;
        int b = 2;
        int expectedResult = 3;

        double actual = calculator.divide(a, b);

        Assertions.assertEquals(expectedResult, actual);
    }

    @Test
    public void divideWithFloatingResultTest() {
        int a = 5;
        int b = 2;
        double expectedResult = 2.5;

        double actual = calculator.divide(a, b);

        Assertions.assertEquals(expectedResult, actual, 0.001);
    }

    @Test
    public void divideByZeroTest() {
        int a = 5;
        int b = 0;

        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> calculator.divide(a, b)
        );
    }
}
