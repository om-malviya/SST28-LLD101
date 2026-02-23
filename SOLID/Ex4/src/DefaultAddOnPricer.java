public class DefaultAddOnPricer implements AddOnPricer {
    @Override
    public double getPrice(AddOn a) {
        if (a == AddOn.MESS) return 500.0;
        if (a == AddOn.LAUNDRY) return 500.0;
        if (a == AddOn.GYM) return 300.0;
        return 0.0;
    }
}
