package fibonacciobserver;

import java.util.ArrayList;
import java.util.List;

public class FibonacciTask extends Thread {

    private long tal, n;
    List<FibonacciObserver> observers = new ArrayList();

    public void registerFibonacciObserver(FibonacciObserver o) {
        observers.add(o);
    }

    public FibonacciTask(long n) {
        this.tal = n;
    }

    @Override
    public void run() {
        long result = fib(tal);
//        long tal = fib(n);
        for (FibonacciObserver observer : observers) {
            observer.dataReady(tal);
        }
    }

    static long fib(long n) {
        if ((n == 0) || (n == 1)) {
            return n;
        } else {
            return fib(n - 1) + fib(n - 2);
        }
    }
}
