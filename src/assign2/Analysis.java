package assign2;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Analysis {

    public static void main(String[] args) throws IOException {
        Path file = args.length > 0 ? Path.of(args[0]) : Path.of("sales.csv");

        CsvReader reader = new CsvReader();
        List<SalesRecord> data = reader.load(file);

      Service s = new Service();

        System.out.println("Total: " + s.total(data));
        System.out.println("By Region: " + s.byRegion(data));
        System.out.println("By Product: " + s.byProduct(data));
        System.out.println("Avg Price: " + s.avgPrice(data));
        System.out.println("By Month: " + s.byMonth(data));
        System.out.println("Top Products: " + s.top(data, 3));
    }
}

