package dp;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

// 3,5,10
public class ReachAGivenScore {

    public static void main(String[] args) {
        Set<Set<Integer>> accu = new HashSet<>();
        System.out.println(count(50, new TreeSet<Integer>(), accu));
        System.out.println(accu);
        System.out.println(count);

    }

    static int count;
    public static int count(int n, Set<Integer> curr, Set<Set<Integer>> accu) {

        count++;;
        if (n >= 0) {
            if (!accu.contains(curr)) {
                if (n == 0) {
                    accu.add(curr);
                } else {
                    count(n - 3, incrBy(curr, 3), accu);
                    count(n - 5, incrBy(curr, 5), accu);
                    count(n - 10, incrBy(curr, 10), accu);
                }
            }
        }
        return accu.size();
    }

    private static Set<Integer> incrBy(Set<Integer> curr, int val) {
        Set<Integer> temp = new TreeSet<>(curr);
        temp.add(val);
        return temp;
    }
}
