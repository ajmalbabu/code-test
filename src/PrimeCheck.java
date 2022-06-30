import java.util.stream.IntStream;

public class PrimeCheck {

    public static boolean isPrime(int number) {

        return number > 1 && IntStream.range(2, number).noneMatch(i -> number % i == 0);

    }

    public static void main(String[] args) {
        System.out.println(isPrime(7));
    }

}
