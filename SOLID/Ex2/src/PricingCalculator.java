import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PricingCalculator {
    private final TaxPolicy taxPolicy;
    private final DiscountPolicy discountPolicy;

    public PricingCalculator(TaxPolicy taxPolicy, DiscountPolicy discountPolicy) {
        this.taxPolicy = taxPolicy;
        this.discountPolicy = discountPolicy;
    }

    public BillData compute(Map<String, MenuItem> menu, List<OrderLine> lines, String customerType) {
        List<String> lineDescriptions = new ArrayList<>();
        double subtotal = 0.0;
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            subtotal += lineTotal;
            lineDescriptions.add(String.format("- %s x%d = %.2f", item.name, l.qty, lineTotal));
        }
        double taxPct = taxPolicy.taxPercent(customerType);
        double tax = subtotal * (taxPct / 100.0);
        double discount = discountPolicy.discountAmount(customerType, subtotal, lines.size());
        double total = subtotal + tax - discount;
        return new BillData(lineDescriptions, subtotal, taxPct, tax, discount, total);
    }
}
