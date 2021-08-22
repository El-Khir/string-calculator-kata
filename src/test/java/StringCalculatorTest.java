import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void givenEmptyString_whenAdd_thenReturnZero() {
        assertEquals(stringCalculator.add(""), 0);
    }

    @Test
    public void givenStringContainingOnly4_whenAdd_thenReturn4() {
        assertEquals(stringCalculator.add("4"), 4);
    }

    @Test
    public void givenStringContaining6And4_whenAdd_thenReturn10() {
        assertEquals(stringCalculator.add("6,4"), 10);
    }

    @Test
    public void givenStringContainingFromZeroTo9_whenAdd_thenReturn45() {
        assertEquals(stringCalculator.add("0,1,2,3,4,5,6,7,8,9"), 45);
    }




}
