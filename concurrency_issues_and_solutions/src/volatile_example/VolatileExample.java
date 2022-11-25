package volatile_example;

public class VolatileExample {
    static volatile int counter = 0;

    public static void main(String[] args) {
        new ReadData().start();
        new WriteData().start();
    }

    static class ReadData extends Thread {
        @Override
        public void run() {
            int num = counter;
            while (num < 3) {
                if (num != counter) {
                    System.out.println("New value is: " + counter);
                    num = counter;
                }
            }
        }
    }
    static class WriteData extends Thread {
        @Override
        public void run() {
            int num = counter;
            while (num < 3) {
                System.out.println("Increment value: " + (num + 1));
                counter = ++num;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
