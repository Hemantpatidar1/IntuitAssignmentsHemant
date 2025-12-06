package assign1;

import java.util.List;

public class Producer implements Runnable {

    private final Share<String> buffer;
    private final List<String> source;
    private final String stopSignal;

    public Producer(Share<String> buffer, List<String> source, String stopSignal) {
        this.buffer = buffer;
        this.source = source;
        this.stopSignal = stopSignal;
    }

    @Override
    public void run() {
        try {
            for (String item : source) {
                System.out.println("[Producer] Producing: " + item);
                buffer.put(item);
            }
            buffer.put(stopSignal);
            System.out.println("[Producer] Sent stop signal.");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("[Producer] Interrupted: " + e.getMessage());
        }
    }
}
