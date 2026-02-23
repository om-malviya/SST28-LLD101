public class InvoiceBuilder {

    public String build(String invId, BillData data) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invId).append("\n");
        for (String line : data.lineDescriptions) {
            out.append(line).append("\n");
        }
        out.append(String.format("Subtotal: %.2f\n", data.subtotal));
        out.append(String.format("Tax(%.0f%%): %.2f\n", data.taxPct, data.tax));
        out.append(String.format("Discount: -%.2f\n", data.discount));
        out.append(String.format("TOTAL: %.2f\n", data.total));
        return InvoiceFormatter.identityFormat(out.toString());
    }
}
