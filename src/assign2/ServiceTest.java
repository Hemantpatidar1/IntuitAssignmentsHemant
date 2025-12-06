package assign2;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ServiceTest {

    private List<SalesRecord> data() {
        return Arrays.asList(
                new SalesRecord("North", "Phone", 10, 100, LocalDate.of(2024, 1, 10)),
                new SalesRecord("North", "Laptop", 5, 500, LocalDate.of(2024, 1, 12)),
                new SalesRecord("South", "Phone", 8, 110, LocalDate.of(2024, 2, 5)),
                new SalesRecord("South", "Tablet", 4, 300, LocalDate.of(2024, 2, 15))
        );
    }

    @Test
    void totalTest() {
      Service s = new Service();
        assertEquals(10 * 100 + 5 * 500 + 8 * 110 + 4 * 300, s.total(data()));
    }

    @Test
    void regionTest() {
        Service s = new Service();
        Map<String, Double> m = s.byRegion(data());
        assertEquals(10 * 100 + 5 * 500, m.get("North"));
        assertEquals(8 * 110 + 4 * 300, m.get("South"));
    }

    @Test
    void productTest() {
        Service s = new Service();
        Map<String, Long> m = s.byProduct(data());
        assertEquals(18L, m.get("Phone"));
        assertEquals(5L, m.get("Laptop"));
        assertEquals(4L, m.get("Tablet"));
    }

    @Test
    void monthTest() {
        Service s = new Service();
        Map<Month, Double> m = s.byMonth(data());
        assertEquals(10 * 100 + 5 * 500, m.get(Month.JANUARY));
        assertEquals(8 * 110 + 4 * 300, m.get(Month.FEBRUARY));
    }
}
