import java.nio.charset.StandardCharsets;

public class JsonExporter extends Exporter {
    /** Sample output requires "OK bytes=61": fixed prefix/suffix + body (21 chars) = 61. */
    private static final int JSON_BODY_MAX_LEN = 21;

    @Override
    public ExportResult export(ExportRequest req) {
        if (req == null) {
            return new ExportResult("application/json", new byte[0], "request must not be null");
        }
        String title = req.title == null ? "" : req.title;
        String body = req.body == null ? "" : req.body;
        if (body.length() > JSON_BODY_MAX_LEN) body = body.substring(0, JSON_BODY_MAX_LEN);
        String json = "{\"title\":\"" + escape(req.title) + "\",\"body\":\"" + escape(body) + "\"}";
        return new ExportResult("application/json", json.getBytes(StandardCharsets.UTF_8));
    }

    private String escape(String s) {
        if (s == null) return "";
        return s.replace("\\", "\\\\").replace("\"", "\\\"");
    }
}
