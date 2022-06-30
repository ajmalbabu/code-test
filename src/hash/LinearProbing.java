package hash;

import java.util.Arrays;
import java.util.stream.IntStream;

// Look at implementation of HashMap, how it is able to hash at linear time using key and & bit operation
// define bucket to be at a value equal to expected total keys (say "tot") and each key is anded (&) with "tot"
public class LinearProbing {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(linearProbing(10, IntStream.of(4, 14, 24, 44).toArray(), 4)));
        System.out.println(Arrays.toString(linearProbing(10, IntStream.of(9, 99, 999, 9999).toArray(), 4)));
    }

    static int[] linearProbing(int hash_size, int arr[], int sizeOfArray) {
        int[] hashes = new int[hash_size];
        Arrays.fill(hashes, -1);

        for (int e : arr) {

            int mod = e % hash_size;

            if (hashes[mod] == e) {
                continue;
            }

            int count = 0;
            while (count < hash_size) {

                if (hashes[mod] == -1) {
                    hashes[mod] = e;
                    break;
                } else {
                    mod = ++mod % hash_size;
                    if (hashes[mod] == e) {
                        break;
                    }

                    count++;
                }
            }
            if (count == hash_size) break;
        }
        return hashes;
    }
}
