/**
 * Result of an export operation.
 * If error is non-null, the export failed and the message describes why;
 * bytes may still be set (e.g. error document). If error is null, bytes contain the export.
 */
public class ExportResult {
    public final String contentType;
    public final byte[] bytes;
    /** Non-null only when export failed (e.g. format constraint); null means success. */
    public final String error;

    public ExportResult(String contentType, byte[] bytes) {
        this(contentType, bytes, null);
    }

    public ExportResult(String contentType, byte[] bytes, String error) {
        this.contentType = contentType;
        this.bytes = bytes == null ? new byte[0] : bytes;
        this.error = error;
    }
}
