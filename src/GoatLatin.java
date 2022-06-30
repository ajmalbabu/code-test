// https://leetcode.com/problems/goat-latin/
public class GoatLatin {

    public static void main(String[] args) {
//        System.out.println(new GoatLatin().toGoatLatin("I speak Goat Latin"));
        System.out.println(new GoatLatin().toGoatLatin("The quick brown fox jumped over the lazy dog"));
    }

    public String toGoatLatin(String s) {

        int repeater = 1;
        StringBuilder result = new StringBuilder();
        boolean atWordStart = true;
        char startChar = 0;

        for (int i = 0; i < s.length(); i++) {

            char charAt = s.charAt(i);

            if (atWordStart) {
                if ((charAt == 'a' || charAt == 'A' || charAt == 'e' || charAt == 'E' || charAt == 'i' || charAt == 'I' || charAt == 'o' || charAt == 'O' || charAt == 'u' || charAt == 'U')) {
                    result.append(charAt);
                } else {
                    startChar = charAt;
                }
                atWordStart = false;
            } else if (charAt == ' ') {

                if (startChar != 0) {
                    result.append(startChar);
                    startChar = 0;
                }
                result.append("ma");

                for (int j = 0; j < repeater; j++) {
                    result.append('a');
                }

                result.append(' ');
                repeater++;
                atWordStart = true;
            } else {
                result.append(charAt);
            }

        }
        if (startChar != 0) {
            result.append(startChar);
        }
        result.append("ma");

        for (int j = 0; j < repeater; j++) {
            result.append('a');
        }

        return result.toString();
    }
}
