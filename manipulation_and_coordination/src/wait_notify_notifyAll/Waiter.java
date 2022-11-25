package wait_notify_notifyAll;

public class Waiter implements Runnable{
    private Message msg;

    public Waiter(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        synchronized (msg) {
            System.out.println("Waiter "+Thread.currentThread().getName()+" is waiting to get notified");
        }
        try {
            msg.wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.err.println("The message from the notifier is "+msg.getMessage());
        System.out.println("Waiter"+Thread.currentThread().getName() + " is notified");
    }
}
