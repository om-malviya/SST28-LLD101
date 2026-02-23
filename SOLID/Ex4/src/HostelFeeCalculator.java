import java.util.Random;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final MonthlyFeeCalculator feeCalculator;

    public HostelFeeCalculator(FakeBookingRepo repo, MonthlyFeeCalculator feeCalculator) {
        this.repo = repo;
        this.feeCalculator = feeCalculator;
    }

    public void process(BookingRequest req) {
        Money monthly = feeCalculator.calculate(req);
        Money deposit = new Money(5000.00);
        ReceiptPrinter.print(req, monthly, deposit);
        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }
}
