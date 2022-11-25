package thread_safety;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicExample implements Runnable{
    // int counter;
    AtomicInteger atomicCounter = new AtomicInteger();
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(100);
                atomicCounter.incrementAndGet();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        AtomicExample obj = new AtomicExample();
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("The counter value is "+obj.atomicCounter.get());
    }
}
