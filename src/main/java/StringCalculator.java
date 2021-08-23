import java.util.Arrays;

import static java.util.stream.Collectors.joining;

public class StringCalculator {

    public static final String DEFAULT_NUMBERS_DELIMITER_REGEX = "[,\n]";
    public static final String REGEX_CHARACTER_PROTECTION = "\\";
    public static final String CUSTOM_DELIMITER_PREFIX = "//";
    public static final String NEGATIVES_NOT_ALLOWED_EXCEPTION_PREFIX_MESSAGE = "negatives not allowed : ";
    public static final String NUMBERS_IN_MESSAGE_DELIMITER = ", ";

    public int add(String numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        int[] numbersAsIntArray = toIntArray(numbers);
        throwExceptionIfContainsNegatives(numbersAsIntArray);
        return sum(numbersAsIntArray);
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

    private void throwExceptionIfContainsNegatives(int[] numbers) {
        int[] negativeNumbers = Arrays.stream(numbers)
                .filter(number -> number < 0)
                .toArray();
        if (negativeNumbers.length > 0) {
            throw new IllegalArgumentException(buildNegativeNotAllowedExceptionMessage(negativeNumbers));
        }
    }

    private String buildNegativeNotAllowedExceptionMessage(int[] negativeNumbers) {
        String commaSeparatedNegativeNumbers = Arrays.stream(negativeNumbers)
                .mapToObj(String::valueOf)
                .collect(joining(NUMBERS_IN_MESSAGE_DELIMITER));
        return NEGATIVES_NOT_ALLOWED_EXCEPTION_PREFIX_MESSAGE +
                commaSeparatedNegativeNumbers;
    }

    private String removeCustomDelimiterLine(String numbers) {
        if (containsCustomDelimiter(numbers)) {
            return numbers.lines().skip(1).collect(joining());
        }
        return numbers;
    }

    private boolean containsCustomDelimiter(String numbers) {
        return numbers.startsWith(CUSTOM_DELIMITER_PREFIX);
    }

    private int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }
}
