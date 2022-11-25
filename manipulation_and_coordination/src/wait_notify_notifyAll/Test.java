package wait_notify_notifyAll;

public class Test {
    public static void main(String[] args) {
        Message msg = new Message("test");
        Thread waiter1 = new Thread(new Waiter(msg));
        Thread waiter2 = new Thread(new Waiter(msg));
        waiter1.start();
        waiter2.start();
        Thread notifier = new Thread(new Client(msg));
        notifier.start();
    }
}
