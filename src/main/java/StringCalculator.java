import java.util.Arrays;

public class StringCalculator {

    public static final String NUMBERS_SEPARATOR = ",";

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return sum(toIntArray(numbers));
    }

    private int[] toIntArray(String numbers) {
        return Arrays.stream(numbers.split(NUMBERS_SEPARATOR))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
