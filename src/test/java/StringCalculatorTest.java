import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StringCalculatorTest {

    StringCalculator stringCalculator = new StringCalculator();

    @Test
    public void givenEmptyString_whenAdd_thenReturnZero() {
        assertEquals(stringCalculator.add(""), 0);
    }

    @Test
    public void givenStringContainingOnly4_whenAdd_thenReturn4() {
        assertEquals(4, stringCalculator.add("4"));
    }

    @Test
    public void givenStringContaining6And4_whenAdd_thenReturn10() {
        assertEquals(10, stringCalculator.add("6,4"));
    }

    @Test
    public void givenStringContainingFromZeroTo9_whenAdd_thenReturn45() {
        assertEquals(45, stringCalculator.add("0,1,2,3,4,5,6,7,8,9"));
    }

    @Test
    public void givenStringContainingFrom1To3AndNewLineDelimiter_whenAdd_thenReturn6() {
        assertEquals(6, stringCalculator.add("1\n2,3"));
    }

    @Test
    public void givenStringContaining1And2_withSemicolonDelimiter_whenAdd_thenReturn3() {
        assertEquals(3, stringCalculator.add("//;\n1;2"));
    }

    @Test
    public void givenStringContainingNegatives_whenAdd_thenIllegalArgumentExceptionThrownWithAllNegativesInMessage() {
        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                () -> stringCalculator.add("1,-6,10,0,-2,11\n-100")
        );
        assertEquals("negatives not allowed : -6, -2, -100", thrownException.getMessage());
    }

    @Test
    public void givenStringContainingNegatives_withSemicolonDelimiter_whenAdd_thenIllegalArgumentExceptionThrownWithAllNegativesInMessage() {
        IllegalArgumentException thrownException = assertThrows(IllegalArgumentException.class,
                () -> stringCalculator.add("//;\n-1;-6;-11")
        );
        assertEquals("negatives not allowed : -1, -6, -11", thrownException.getMessage());
    }

}
