import java.util.*;

public class CafeteriaSystem {
    private final Map<String, MenuItem> menu = new LinkedHashMap<>();
    private final InvoiceStore store;
    private final PricingCalculator calculator;
    private final InvoiceBuilder invoiceBuilder;
    private int invoiceSeq = 1000;

    public CafeteriaSystem(InvoiceStore store, PricingCalculator calculator, InvoiceBuilder invoiceBuilder) {
        this.store = store;
        this.calculator = calculator;
        this.invoiceBuilder = invoiceBuilder;
    }

    public void addToMenu(MenuItem i) { menu.put(i.id, i); }

    public void checkout(String customerType, List<OrderLine> lines) {
        String invId = "INV-" + (++invoiceSeq);
        BillData data = calculator.compute(menu, lines, customerType);
        String printable = invoiceBuilder.build(invId, data);
        System.out.print(printable);
        store.save(invId, printable);
        System.out.println("Saved invoice: " + invId + " (lines=" + store.countLines(invId) + ")");
    }
}
