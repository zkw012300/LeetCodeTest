/**
 * Link: https://leetcode.com/problems/string-to-integer-atoi/
 * Status: AC
 *
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−2^31,  2^31 − 1]. If the numerical value is out of the range of representable values, INT_MAX (2^31 − 1) or INT_MIN (−2^31) is returned.
 * Example 1:
 * <p>
 * Input: "42"
 * Output: 42
 * Example 2:
 * <p>
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 * Example 3:
 * <p>
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 * Example 4:
 * <p>
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 * Example 5:
 * <p>
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−2^31) is returned.
 */
public class StringToInteger {

    public static int myAtoi(String str) {
        char[] charArray = str.trim().toCharArray();
        boolean isNegative = false;
        long sum = 0;
        for (int i = 0; i < charArray.length; i++) {
            int ascii = charArray[i];
            if (ascii == 43 && i == 0) {
                isNegative = false;
            } else if (ascii == 45 && i == 0) {
                isNegative = true;
            } else if (ascii >= 48 && ascii <= 57) {
                sum *= 10;
                sum += (ascii - 48);
                if (sum > Integer.MAX_VALUE) {
                    if (isNegative) {
                        return Integer.MIN_VALUE;
                    } else {
                        return Integer.MAX_VALUE;
                    }
                }
            } else {
                return getResult(sum, isNegative);
            }
        }
        return getResult(sum, isNegative);
    }

    private static int getResult(long l, boolean isNegative) {
        return isNegative ? (int) -l : (int) l;
    }

    public static void main(String[] args) {
        check("42", 42);
        check("4193 with words", 4193);
        check("words and 987", 0);
        check("+-2", 0);
        check(" +0 123", 0);
        check("-42", -42);
        check("   -42", -42);
        check("9223372036854775808", Integer.MAX_VALUE);
    }

    private static void check(String str, int result) {
        System.out.print("Case: " + str + "\t");
        if (myAtoi(str) == result) {
            System.out.println("Success!");
        } else {
            System.out.println();
            throw new RuntimeException("Failed!");
        }
    }

}
