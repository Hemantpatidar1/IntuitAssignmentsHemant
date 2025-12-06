package assign2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CsvReader {

    public List<SalesRecord> load(Path path) throws IOException {
        return Files.lines(path)
                .skip(1)
                .map(this::toRecord)
                .collect(Collectors.toList());
    }

    private SalesRecord toRecord(String line) {
        String[] p = line.split(",");
        return new SalesRecord(
                p[0].trim(),
                p[1].trim(),
                Integer.parseInt(p[2].trim()),
                Double.parseDouble(p[3].trim()),
                LocalDate.parse(p[4].trim())
        );
    }
}

