public class Main {
    public static void main(String[] args) {
        System.out.println("=== Export Demo ===");

        ExportRequest req = new ExportRequest("Weekly Report", SampleData.longBody());
        Exporter pdf = new PdfExporter();
        Exporter csv = new CsvExporter();
        Exporter json = new JsonExporter();

        System.out.println("PDF: " + formatResult(pdf.export(req)));
        System.out.println("CSV: " + formatResult(csv.export(req)));
        System.out.println("JSON: " + formatResult(json.export(req)));
    }

    private static String formatResult(ExportResult out) {
        if (out.error != null) {
            return "ERROR: " + out.error;
        }
        return "OK bytes=" + out.bytes.length;
    }
}
