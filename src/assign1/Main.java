package assign1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        List<String> source = Arrays.asList("M", "N", "O", "P", "Q");
        List<String> destin = new ArrayList<>();

        String stopSignal = "END";
        int bufferCapacity = 3;

        Share<String> buffer = new Share<>(bufferCapacity);

        Thread producerThread = new Thread(new Producer(buffer, source, stopSignal), "Producer-Thread");
        Thread consumerThread = new Thread(new Consumer(buffer, destin, stopSignal), "Consumer-Thread");

        producerThread.start();
        consumerThread.start();

        producerThread.join();
        consumerThread.join();

        System.out.println("Final destination content: " + destin);
        System.out.println("Buffer size after completion: " + buffer.size());
    }
}
