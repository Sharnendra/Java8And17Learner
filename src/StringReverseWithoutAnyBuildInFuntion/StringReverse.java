package StringReverseWithoutAnyBuildInFuntion;

import java.util.function.Function;

public class StringReverse {
    public static void main(String[] args) {
        System.out.println(reverseString.apply("Hello Sharnendra!"));
    }

    public static Function<String, String> reverseString = (val) -> {
        char[] charArr = val.toCharArray();
        int left = 0;
        int right = val.length()-1;
        while(left < right) {
            char temp = charArr[left];
            charArr[left] = charArr[right];
            charArr[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(charArr);
    };
}
