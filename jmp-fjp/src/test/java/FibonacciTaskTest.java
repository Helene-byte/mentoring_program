import org.junit.Test;

import java.util.concurrent.ForkJoinPool;

import static org.junit.Assert.assertEquals;

public class FibonacciTaskTest {
    @Test
    public void testFibonacciTask() {
        FibonacciTask task = new FibonacciTask(45);
        long result = new ForkJoinPool().invoke(task);
        assertEquals(1134903170L, result);
    }
}
