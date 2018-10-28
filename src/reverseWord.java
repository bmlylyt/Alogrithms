import java.util.ArrayList;
import java.util.List;

public class reverseWord {
    public static String reverseWord(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        int count = 0;
        reverseWord(chars, 0, chars.length - 1);
        for (int i = 0; i < chars.length - 1; i ++) {
            if (chars[i] == ' ' && i != 0) {
                reverseWord(chars, count, i - 1);
                count = i + 1;
            }
        }
        reverseWord(chars, count, chars.length - 1);
        return removeSpace(chars);
    }
    private static String removeSpace(char[] chars) {
        int slow = -1;
        for (int fast = 0; fast < chars.length; fast ++) {
            if (chars[fast] == ' ' && (fast == 0 || chars[fast - 1] == ' ')) continue;
            chars[++ slow] = chars[fast];
        }
        if(slow == 0) return "";
        System.out.println(slow);
        return chars[slow] == ' ' ? new String(chars, 0, slow ) : new String(chars, 0, slow + 1);

    }
    private static void reverseWord (char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left ++;
            right --;
        }
    }
    private static String removeOtherCases(String s) {
        char[] chars = s.toCharArray();
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast ++) {
            if ((chars[fast] >= 65 && chars[fast] <= 90) || (chars[fast] >= 97 && chars[fast] <= 122) ||(chars[fast] >= 30 && chars[fast] <= 39 )){
                if (chars[fast] >= 65 && chars[fast] <= 90) {
                    chars[slow ++] = (char) (chars[fast] + 32);
                } else {
                    chars[slow ++] = chars[fast];
                }
            }
        }
        return new String(chars, 0, slow);
    }
    public static void main(String[] args) {
       String s = "048";
       String s2 = "49";
       List<Integer> res = new ArrayList<>();
       res.add(1);
       res.add(2);
       res.add(3);
       System.out.println(res.size());

    }
}
