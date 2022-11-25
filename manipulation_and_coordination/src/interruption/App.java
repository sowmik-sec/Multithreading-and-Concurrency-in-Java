package interruption;

public class App implements Runnable{
    @Override
    public void run() {
        while(!Thread.interrupted()) {
            System.out.println("Thread "+Thread.currentThread().getName()+" is not interrupted");
        }
        System.out.println("Thread "+Thread.currentThread().getName()+" has stopped");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new App());
        t1.start();

        Thread.sleep(50);

        t1.interrupt();

        Thread.sleep(1000);

        System.out.println("Exiting main thread");
    }
}
