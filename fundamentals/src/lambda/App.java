package lambda;

public class App {
    public static void main(String[] args) {
        Runnable a = new Runnable() {
            @Override
            public void run() {
                System.out.println("Using Anonymous class");
            }
        };
        new Thread(a).start();

        Runnable t = () -> {
            System.out.println("Using lambda expression");
        };

        new Thread(t).start();
    }
}