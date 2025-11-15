package project.utilities;

public class Energy extends PublicUtilities {

    private static final String UNIT = "kW";
    private static final String TYPE = "Energy";
    private static final double LIMIT = 300;


    public Energy() {
        setUtilType(TYPE);
        setConsumeLimit(LIMIT);
        setUtilPrice(4.3);
    }


    @Override
    protected String generateConsumptionReport() {
        if (consumed > LIMIT * 0.9) {
            return String.format(
                    "Energy Report: WARNING! Consumption (%.3f %s) is nearing the limit (%.3f %s). Consider immediate savings!",
                    consumed, UNIT, LIMIT, UNIT
            );
        } else {
            return String.format(
                    "Energy Report: Consumption (%.3f %s) is stable. %.1f%% of limit used.",
                    consumed, UNIT, (consumed / LIMIT) * 100
            );
        }
    }

    @Override
    public String computePayment() {

        double res = getUtilPrice() * consumed;
        return String.format("Payment size is %.3f UAH for %.3f %s", res, consumed, UNIT);
    }


    @Override
    protected String limitRemainingCompute() {
        double res = LIMIT - consumed;
        return String.format("%.3f %s is remaining for present period", res, UNIT);
    }
}
