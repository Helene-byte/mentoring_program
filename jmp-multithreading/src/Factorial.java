import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class Factorial extends RecursiveTask<BigInteger>{
    private BigInteger start;
    private BigInteger end;

    public static final BigInteger threshold = BigInteger.valueOf(5);

    public Factorial(BigInteger number) {
        this(BigInteger.ONE, number);
    }

    private Factorial(BigInteger start, BigInteger end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected BigInteger compute() {
        BigInteger length;
        length = (end.subtract(start)).add(BigInteger.ONE);
        if (length.compareTo(threshold)<= 0) {
            return factorial();
        }

        BigInteger mid = length.divide(BigInteger.valueOf(2));
        Factorial firstTask = new Factorial(start, start.add(mid));
        Factorial secondTask = new Factorial(start.add(mid).add(BigInteger.ONE), end);
        firstTask.fork();
        return secondTask.compute().multiply(firstTask.join());

    }

    private BigInteger factorial() {
        BigInteger result = BigInteger.ONE;
        for (BigInteger i = start; i.compareTo(end)<= 0; i=i.add(BigInteger.ONE)) {
            result =result.multiply(i);
        }
        return result;
    }


    public static void main(String[] args) {

        ForkJoinTask<BigInteger> task = new Factorial(BigInteger.valueOf(500));
        long start = System.nanoTime();
        System.out.println(ForkJoinPool.commonPool().invoke(task));
        long end = System.nanoTime();
        System.out.println((end - start) + " nanoseconds for FJP");
    }

}

class SequentialFactorial {

    public static void main(String[] args) {
        long start = System.nanoTime();
        System.out.println(calculateFactorial(BigInteger.valueOf(500)));
        long end = System.nanoTime();
        System.out.println((end - start) + " nanoseconds for sequential");
    }

    private static BigInteger calculateFactorial(BigInteger n) {
        if (n.compareTo(BigInteger.valueOf(2)) <= 0) {
            return n;
        }

        return n.multiply(calculateFactorial(n.subtract(BigInteger.ONE)));
    }
}
