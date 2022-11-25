package join;

public class App implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Started");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName()+" Finished");
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new App(), "Thread1");
        Thread t2 = new Thread(new App(), "Thread2");
        Thread t3 = new Thread(new App(), "Thread3");

        t1.start();
        t1.join();
        t2.start();
        t2.join();
        t3.start();

    }

}
