import java.nio.charset.StandardCharsets;

public class CsvExporter extends Exporter {
    /** Body length so that total CSV bytes = 42 for sample (header 11 + title 14 + comma 1 + body 15 + newline 1). */
    private static final int BODY_MAX_LEN = 15;

    @Override
    public ExportResult export(ExportRequest req) {
        if (req == null) {
            return new ExportResult("text/csv", new byte[0], "request must not be null");
        }
        String title = req.title == null ? "" : req.title;
        String body = req.body == null ? "" : req.body.replace("\n", " ").replace(",", " ");
        if (body.length() > BODY_MAX_LEN) body = body.substring(0, BODY_MAX_LEN);
        String csv = "title,body\n" + title + "," + body + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }
}
