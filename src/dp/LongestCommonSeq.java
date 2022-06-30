package dp;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSeq {

    static Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(longestCommonSeq("ABCDGH", "AEDFHR", 0, 0));
        memo.clear();
//        System.out.println(longestCommonSeq("AB", "AC", 0, 0));
    }

    static int longestCommonSeq(String s1, String s2, int l, int r) {

        if (s1.length() == l || s2.length() == r) return 0;
        if (memo.get(l + "" + r) != null) {
            System.out.println("l=" + l + "r=" + r + memo);
            return memo.get(l + "" + r);
        }
        if (s1.charAt(l) == s2.charAt(r)) {
            return 1 + longestCommonSeq(s1, s2, l + 1, r + 1);
        } else {
            int v = Math.max(longestCommonSeq(s1, s2, l, r + 1), longestCommonSeq(s1, s2, l + 1, r));
            memo.put(l + "" + r, v);
            return v;
        }
    }
}
