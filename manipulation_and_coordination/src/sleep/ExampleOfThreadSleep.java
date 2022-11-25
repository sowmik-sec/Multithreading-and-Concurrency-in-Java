package sleep;

public class ExampleOfThreadSleep extends Thread{
    public ExampleOfThreadSleep(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" Started");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName()+" Finished");
    }

    public static void main(String[] args) {
        ExampleOfThreadSleep t1 = new ExampleOfThreadSleep("First thread");
        ExampleOfThreadSleep t2 = new ExampleOfThreadSleep("Second thread");

        System.out.println(t1.getName()+" State = "+t1.getState());
        t1.start();
        System.out.println(t1.getName()+" State = "+t1.getState());

        System.out.println(t2.getName()+" State = "+t2.getState());
        t2.start();
        System.out.println(t2.getName()+" State = "+t2.getState());
    }
}
