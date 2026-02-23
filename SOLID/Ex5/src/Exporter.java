/**
 * Base contract for exporters (LSP-friendly):
 * - Precondition: req is non-null.
 * - Postcondition: returns non-null ExportResult; never throws.
 * - If the format cannot represent the request (e.g. size limit), return result with error set.
 * - No subtype may tighten preconditions or throw for valid non-null request.
 */
public abstract class Exporter {
    public abstract ExportResult export(ExportRequest req);
}
