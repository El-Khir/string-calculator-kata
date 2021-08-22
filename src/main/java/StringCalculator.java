import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class StringCalculator {

    public static final String DEFAULT_NUMBERS_DELIMITER_REGEX = "[,\n]";
    public static final String REGEX_CHARACTER_PROTECTION = "\\";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        return sum(toIntArray(numbers));
    }

    private int[] toIntArray(String numbers) {
        String delimiterRegex = getNumbersDelimiterRegex(numbers);
        String numbersWithoutDelimiterLine = removeCustomDelimiterLine(numbers);
        return Arrays.stream(numbersWithoutDelimiterLine.split(delimiterRegex))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

    private String getNumbersDelimiterRegex(String numbers) {
        if (containsCustomDelimiter(numbers)) {
            return REGEX_CHARACTER_PROTECTION +
                    numbers.charAt(CUSTOM_DELIMITER_PREFIX.length());
        }
        return DEFAULT_NUMBERS_DELIMITER_REGEX;
    }

    private String removeCustomDelimiterLine(String numbers) {
        if (containsCustomDelimiter(numbers)) {
            return numbers.lines().skip(1).collect(joining());
        }
        return numbers;
    }

    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    private boolean containsCustomDelimiter(String numbers) {
        return numbers.startsWith(CUSTOM_DELIMITER_PREFIX);
    }
}
