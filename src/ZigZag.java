import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/zigzag-conversion/
public class ZigZag {

    public static void main(String[] args) {
//        System.out.println(new ZigZag().convert("PAYPALISHIRING", 3));
        System.out.println(new ZigZag().convert("PAYPALISHIRING", 4));
    }

    public String convert(String s, int rows) {
        if (s.length() == 0) return s;
        if (rows == 1) return s;
        int i = 0;
        int currentrow = 0;
        boolean dir = false;
        List<StringBuilder> sbList = new ArrayList<StringBuilder>();
        while (i < rows) {
            sbList.add(new StringBuilder());
            i++;
        }
        for (Character c : s.toCharArray()) {
            sbList.get(currentrow).append(c);
            if (currentrow == 0 || currentrow == rows - 1)
                dir = !dir;
            currentrow += dir ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < rows; j++) {
            sb.append(sbList.get(j).toString());
        }
        return sb.toString();
    }
}


