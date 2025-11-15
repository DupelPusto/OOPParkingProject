package project.utilities;

public class Water extends PublicUtilities {

    private static final double LIMIT = 35;
    private static final String UNIT = "m3";
    private static final String TYPE = "Water";


    public Water() {
        setUtilType(TYPE);
        setConsumeLimit(LIMIT);
        setUtilPrice(29.3);
    }

    @Override
    protected String generateConsumptionReport() {
        if (consumed > LIMIT) {
            return String.format(
                    "Water Report: OVER LIMIT! Consumption (%.3f %s) exceeds the limit (%.3f %s). Surcharge might apply.",
                    consumed, UNIT, LIMIT, UNIT
            );
        } else {
            return String.format(
                    "Water Report: Consumption (%.3f %s) is healthy. You have %.3f %s remaining.",
                    consumed, UNIT, (LIMIT - consumed), UNIT
            );
        }
    }

    @Override
    public String computePayment() {
        double res = getUtilPrice() * consumed;
        return String.format("Payment size is %.3f UAH for %.3f %s", res, consumed, UNIT);
    }

    @Override
    public String limitRemainingCompute() {
        double res = LIMIT - consumed;
        return String.format("%.3f %s is remaining for present period", res, UNIT);
    }
}
