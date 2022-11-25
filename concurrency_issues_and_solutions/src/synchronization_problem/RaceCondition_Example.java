package synchronization_problem;

public class RaceCondition_Example implements Runnable{
    int counter;

    public int getCounter() {
        return counter;
    }

    public void increment() throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread.sleep(100);
            synchronized (this) {
                counter++;
            }
        }
    }

    @Override
    public void run() {
        try {
            increment();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        RaceCondition_Example rc = new RaceCondition_Example();
        Thread t1 = new Thread(rc);
        Thread t2 = new Thread(rc);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("The counter value is "+rc.getCounter());

    }
}
