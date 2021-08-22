import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void givenEmptyString_whenAdd_thenReturnZero() {
        assertEquals(stringCalculator.add(""), 0);
    }

    @Test
    public void givenStringContainingOneNumber_whenAdd_thenReturnThisNumber() {
        assertEquals(stringCalculator.add("4"), 4);
    }

    @Test
    public void givenStringContainingTwoNumbers_whenAdd_thenReturnSum() {
        assertEquals(stringCalculator.add("6,4"), 10);
    }




}
