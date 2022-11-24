package example;

public class ThreadExample implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("index : "+i+" Thread executing "+Thread.currentThread().getName()+" Thread id: "+ Thread.currentThread().getId());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Exit run method for thread"+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread threadExample1 = new Thread(new ThreadExample());
        threadExample1.start();

        Thread threadExample2 = new Thread(new ThreadExample());
        threadExample2.start();
    }
}