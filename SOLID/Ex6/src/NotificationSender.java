/**
 * Base contract for notification senders (LSP-friendly):
 * - Precondition: n is non-null.
 * - Postcondition: send() never throws; delivery is best-effort per channel.
 * - Invalid channel-specific data (e.g. bad phone format) is handled internally (log/audit, optional console message).
 * - No subtype may tighten preconditions or throw.
 */
public abstract class NotificationSender {
    protected final AuditLog audit;
    protected NotificationSender(AuditLog audit) { this.audit = audit; }
    public abstract void send(Notification n);
}
