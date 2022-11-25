package deadlock;

public class App {
    private static Object obj1 = new Object();
    private static Object obj2 = new Object();
    public static class Thread1 extends Thread {
        @Override
        public void run() {
            synchronized (obj1) {
                System.out.println("Thread "+this.getName() + " is holding the lock object 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread " + this.getName() + " is waiting the lock Object 2 ...");
                synchronized (obj2) {
                    System.out.println("Thread "+this.getName() + " is holding the lock object 2");
                }
            }
        }
    }
    public static class Thread2 extends Thread {
        @Override
        public void run() {
            synchronized (obj1) {
                System.out.println("Thread "+this.getName() + " is holding the lock object 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread " + this.getName() + " is waiting the lock Object 2 ...");
                synchronized (obj2) {
                    System.out.println("Thread "+this.getName() + " is holding the lock object 2");
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();
        t1.start();
        t2.start();
    }
}
