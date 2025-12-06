package assign1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Test1 {

    @Test
    void allItemsShouldReachDestination() throws InterruptedException {
        List<String> source = Arrays.asList("A", "B", "C", "D", "E");
        List<String> destin = new ArrayList<>();
        String stop = "END";

        Share<String> buffer = new Share<>(2);

        Thread producer = new Thread(new Producer(buffer, source, stop));
        Thread consumer = new Thread(new Consumer(buffer, destin, stop));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        assertEquals(source, destin);
    }

    @Test
    void destinationShouldBeEmptyWhenSourceIsEmpty() throws InterruptedException {
        List<String> source = new ArrayList<>();
        List<String> destin = new ArrayList<>();
        String stop = "END";

        Share<String> buffer = new Share<>(1);

        Thread producer = new Thread(new Producer(buffer, source, stop));
        Thread consumer = new Thread(new Consumer(buffer, destin, stop));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        assertTrue(destin.isEmpty());
    }

    @Test
    void bufferShouldBeEmptyAfterCompletion() throws InterruptedException {
        List<String> source = Arrays.asList("X", "Y", "Z");
        List<String> destin = new ArrayList<>();
        String stop = "END";

        Share<String> buffer = new Share<>(1);

        Thread producer = new Thread(new Producer(buffer, source, stop));
        Thread consumer = new Thread(new Consumer(buffer, destin, stop));

        producer.start();
        consumer.start();

        producer.join();
        consumer.join();

        assertEquals(0, buffer.size());
        assertEquals(source, destin);
    }
}
