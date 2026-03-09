package com.example.reports;

import java.util.Objects;

public class ReportProxy implements Report {

    private final String reportId;
    private final String title;
    private final String classification;
    private final AccessControl accessControl = new AccessControl();
    private RealReport realReport;

    public ReportProxy(String reportId, String title, String classification) {
        this.reportId = Objects.requireNonNull(reportId, "reportId");
        this.title = Objects.requireNonNull(title, "title");
        this.classification = Objects.requireNonNull(classification, "classification");
    }

    @Override
    public void display(User user) {
        if (!accessControl.canAccess(user, classification)) {
            System.out.println("ACCESS DENIED: " + user.getName()
                    + " cannot access report " + reportId + " (classification=" + classification + ")");
            return;
        }
        if (realReport == null) {
            System.out.println("[proxy] lazy-loading real report " + reportId + " ...");
            realReport = new RealReport(reportId, title, classification);
        } else {
            System.out.println("[proxy] reusing cached real report " + reportId);
        }
        realReport.display(user);
    }
}