package interruption;

public class InterruptThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Thread "+Thread.currentThread().getName()+" is doing task...."+i);
        }
    }

    public static void main(String[] args) {
        InterruptThread t1 = new InterruptThread();
        InterruptThread t2 = new InterruptThread();

        t1.start();
        t2.start();

        System.out.println("is t1 interrupted "+t1.isInterrupted());
        System.out.println("is t2 interrupted "+t2.isInterrupted());

        t1.interrupt();

        System.out.println("is t1 interrupted "+t1.isInterrupted());
        System.out.println("is t2 interrupted "+t2.isInterrupted());

    }
}
