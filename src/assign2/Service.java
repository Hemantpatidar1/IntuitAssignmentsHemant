package assign2;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Service {

    public double total(List<SalesRecord> list) {
        return list.stream().mapToDouble(SalesRecord::revenue).sum();
    }

    public Map<String, Double> byRegion(List<SalesRecord> list) {
        return list.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::region,
                        Collectors.summingDouble(SalesRecord::revenue)
                ));
    }

    public Map<String, Long> byProduct(List<SalesRecord> list) {
        return list.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::product,
                        Collectors.summingLong(SalesRecord::qty)
                ));
    }

    public Map<String, Double> avgPrice(List<SalesRecord> list) {
        return list.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::region,
                        Collectors.averagingDouble(SalesRecord::price)
                ));
    }

    public List<String> top(List<SalesRecord> list, int limit) {
        return list.stream()
                .collect(Collectors.groupingBy(
                        SalesRecord::product,
                        Collectors.summingDouble(SalesRecord::revenue)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue(Comparator.reverseOrder()))
                .limit(limit)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public Map<Month, Double> byMonth(List<SalesRecord> list) {
        return list.stream()
                .collect(Collectors.groupingBy(
                        r -> r.date().getMonth(),
                        Collectors.summingDouble(SalesRecord::revenue)
                ));
    }
}
