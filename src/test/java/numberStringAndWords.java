import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class numberStringAndWords {

    static Map<String, Integer> numberMap = Map.of("zero", 0,
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9);

    static String[] numbers = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

    static int string2int(String str) {
        for (int i = 0; i < numbers.length; i++) {
            str = str.replace(numbers[i], Integer.toString(i));
        }
        return Integer.parseInt(str);
    }

    static int solve(String s) {

        StringBuilder answer = new StringBuilder();
        StringBuilder chars = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isNum(c)) {
                answer.append(c);
            } else {
                chars.append(c);
                if (isStringNum(chars.toString())) {
                    answer.append(numberMap.get(chars.toString()));
                    chars.delete(0,chars.length()-1);
                }
            }
        }

        return Integer.parseInt(answer.toString());
    }

    private static boolean isNum(char c) {
        return c >= '0' && c <= '9';
    }

    private static boolean isStringNum(String str) {
        return str.length() >= 3 && numberMap.containsKey(str);
    }

}