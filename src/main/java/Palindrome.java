import java.util.HashSet;
import java.util.Set;

public class Palindrome {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flded"};
        String answer = longestCommonPrefix(strs);
        //System.out.println(answer);
        String test = "asvbc";
        int dfjo = test.indexOf("svt");
        String kk = String.valueOf(dfjo);
        System.out.println(kk);
        System.out.println();
        Set<Integer> mySet = new HashSet<>();


    }

    static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if(length == 0) {
            return "";
        }
        String answer = strs[0];

        for(int i = 1; i < length; i++ ) {
            answer = findLCP(answer, strs[i]);
        }

        return answer;

    }

    static String findLCP(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < length; i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                break;
            }
            stringBuilder.append(str1.charAt(i));
        }
        return stringBuilder.toString();
    }

}
