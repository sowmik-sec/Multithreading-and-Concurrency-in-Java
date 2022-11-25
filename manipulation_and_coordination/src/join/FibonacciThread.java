package join;

import java.util.ArrayList;
import java.util.List;

public class FibonacciThread extends Thread{
    private int count;
    private int n1 = 0;
    private int n2 = 1;
    private int n3;
    private boolean isFinished = false;

    public FibonacciThread( int count) {
        this.count = count;
    }

    @Override
    public void run() {
        calculatingFibonacciSeries();
        this.isFinished = true;
    }

    public void calculatingFibonacciSeries() {
        for (int i = 0; i < count; i++) {
            n3 = n1+n2;
            System.out.print(" "+n3);
            n1 = n2;
            n2 = n3;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(20);
        numbers.add(500);
        numbers.add(1000);

        List<FibonacciThread> threads = new ArrayList<>();
        numbers.forEach(number -> threads.add(new FibonacciThread(number)));

        threads.forEach(FibonacciThread::start);

        threads.forEach(thread -> {
            try {
                thread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        for (int i = 0; i < numbers.size(); i++) {
            FibonacciThread fibonacciThread = threads.get(i);
            if(fibonacciThread.isFinished) {
                System.out.println("Main thread says that thread " + fibonacciThread.getName()+" has finished calculating fibonacci series of "+numbers.get(i));
            }
            else {
                System.out.println("Main thread says that thread " + fibonacciThread.getName()+" has not finished calculating fibonacci series of "+numbers.get(i));
            }
        }
    }
}
