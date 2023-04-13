import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

import static org.junit.Assert.assertEquals;

public class FibonacciTask extends RecursiveTask<Long> {
    static final int THRESHOLD = 10;
    private int n;

    public FibonacciTask(int n) {
        this.n = n;}

    @Override
    protected Long compute() {
        if (n <= 1) {
            return (long) n;
        } else if (n <= THRESHOLD) {
            // Use linear algorithm if granularity is small enough
            long a = 0, b = 1, c;
            for (int i = 2; i <= n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return b;
        } else {
            FibonacciTask f1 = new FibonacciTask(n - 1);
            f1.fork();
            FibonacciTask f2 = new FibonacciTask(n - 2);
            return f2.compute() + f1.join();
        }
    }
    }

