import java.nio.charset.StandardCharsets;

public class PdfExporter extends Exporter {
    private static final int MAX_BODY_LENGTH = 20;

    @Override
    public ExportResult export(ExportRequest req) {
        if (req == null) {
            return new ExportResult("application/pdf", new byte[0], "request must not be null");
        }
        if (req.body != null && req.body.length() > MAX_BODY_LENGTH) {
            return new ExportResult("application/pdf", new byte[0], "PDF cannot handle content > 20 chars");
        }
        String body = req.body == null ? "" : req.body;
        String fakePdf = "PDF(" + req.title + "):" + body;
        return new ExportResult("application/pdf", fakePdf.getBytes(StandardCharsets.UTF_8));
    }
}
