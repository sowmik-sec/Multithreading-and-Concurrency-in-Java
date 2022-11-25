package wait_notify_notifyAll;

public class Client implements Runnable{
    private Message msg;

    public Client(Message msg) {
        this.msg = msg;
    }

    @Override
    public void run() {
        try {
            // Simulate that we did some operations
            Thread.sleep(2000);
            synchronized (msg) {
                System.out.println("The client "+Thread.currentThread().getName()+" notifies the waiter");
                msg.setMessage(Thread.currentThread().getName()+" done notification");
                msg.notifyAll();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
