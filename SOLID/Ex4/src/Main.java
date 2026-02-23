import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        MonthlyFeeCalculator feeCalculator = new MonthlyFeeCalculator(new DefaultRoomPricer(), new DefaultAddOnPricer());
        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo(), feeCalculator);
        calc.process(req);
    }
}
