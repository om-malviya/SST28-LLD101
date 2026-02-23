import java.util.List;

public class MonthlyFeeCalculator {
    private final RoomPricer roomPricer;
    private final AddOnPricer addOnPricer;

    public MonthlyFeeCalculator(RoomPricer roomPricer, AddOnPricer addOnPricer) {
        this.roomPricer = roomPricer;
        this.addOnPricer = addOnPricer;
    }

    public Money calculate(BookingRequest req) {
        double base = roomPricer.getBaseRate(req.roomType);
        double add = 0.0;
        for (AddOn a : req.addOns) {
            add += addOnPricer.getPrice(a);
        }
        return new Money(base + add);
    }
}
