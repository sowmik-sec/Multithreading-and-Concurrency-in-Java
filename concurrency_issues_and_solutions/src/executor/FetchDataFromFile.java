package executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FetchDataFromFile implements Runnable{
    private String fileName;

    public FetchDataFromFile(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    @Override
    public void run() {
        System.out.println("Fetching data from "+fileName+" by Thread "+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File read successfully "+fileName+" by Thread "+Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        ExecutorService ex = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 10; i++) {
            FetchDataFromFile fd = new FetchDataFromFile("File"+i);
            ex.submit(fd);
        }
    }
}
