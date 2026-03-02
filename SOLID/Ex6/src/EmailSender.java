public class EmailSender extends NotificationSender {
    private static final int MAX_BODY_DISPLAY = 40;

    public EmailSender(AuditLog audit) { super(audit); }

    @Override
    public void send(Notification n) {
        if (n == null) return;
        String body = n.body == null ? "" : n.body;
        if (body.length() > MAX_BODY_DISPLAY) body = body.substring(0, MAX_BODY_DISPLAY);
        System.out.println("EMAIL -> to=" + n.email + " subject=" + n.subject + " body=" + body);
        audit.add("email sent");
    }
}
