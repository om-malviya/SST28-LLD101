import java.util.List;

public class BillData {
    public final List<String> lineDescriptions;
    public final double subtotal;
    public final double taxPct;
    public final double tax;
    public final double discount;
    public final double total;

    public BillData(List<String> lineDescriptions, double subtotal, double taxPct, double tax, double discount, double total) {
        this.lineDescriptions = lineDescriptions;
        this.subtotal = subtotal;
        this.taxPct = taxPct;
        this.tax = tax;
        this.discount = discount;
        this.total = total;
    }
}
