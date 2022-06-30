package dp;

public class EditDistance {

    public static void main(String[] args) {
        System.out.println(edit("SATURDAY".toCharArray(), "SUNDAY".toCharArray(), 0, 0));
        System.out.println(edit("CAT".toCharArray(), "CUT".toCharArray(), 0, 0));
        System.out.println(edit("GEEK".toCharArray(), "GEEKS".toCharArray(), 0, 0));
    }

    public static int edit(char[] str1, char[] str2, int index1, int index2) {

        if (index1 + 1 == str1.length && index2 + 1 == str2.length) return 0;

        if (index1 + 1 == str1.length) return str2.length - index2 - 1;

        if (index2 + 1 == str2.length) return str1.length - index1 - 1;

        if (str1[index1] == str2[index2]) {
            return edit(str1, str2, index1 + 1, index2 + 1);
        } else {
            int result = Math.min(edit(str1, str2, index1 + 1, index2) + 1, edit(str1, str2, index1, index2 + 1) + 1);
            return Math.min(result, edit(str1, str2, index1 + 1, index2 + 1) + 1);
        }

    }
}
