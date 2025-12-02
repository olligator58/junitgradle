package org.example;

public class StringUtils {

    public static boolean isPalindrome(String str) {
        if (str == null || str.length() < 2) {
            return false;
        }
        str = str.toLowerCase().replaceAll("\\s|'|,", "");
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
