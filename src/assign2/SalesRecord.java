package assign2;

import java.time.LocalDate;

public class SalesRecord {

    private final String region;
    private final String product;
    private final int qty;
    private final double price;
    private final LocalDate date;

    public SalesRecord(String region, String product, int qty, double price, LocalDate date) {
        this.region = region;
        this.product = product;
        this.qty = qty;
        this.price = price;
        this.date = date;
    }

    public String region() { return region; }
    public String product() { return product; }
    public int qty() { return qty; }
    public double price() { return price; }
    public LocalDate date() { return date; }

    public double revenue() {
        return qty * price;
    }
}

