package assign1;

import java.util.List;

public class Consumer implements Runnable {

    private final Share<String> buffer;
    private final List<String> destination;
    private final String stopSignal;

    public Consumer(Share<String> buffer, List<String> destination, String stopSignal) {
        this.buffer = buffer;
        this.destination = destination;
        this.stopSignal = stopSignal;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String item = buffer.take();
                System.out.println("[Consumer] Consumed: " + item);

                if (item.equals(stopSignal)) {
                    System.out.println("[Consumer] Received stop signal. Exiting.");
                    break;
                }

                destination.add(item);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("[Consumer] Interrupted: " + e.getMessage());
        }
    }
}
