package command;

import java.util.ArrayList;
import java.util.List;

public class MathCommand {

    public List<Object> takeDecision(Double startValue, Double lastValue, Double currentValue, String coin){

        List<Object> arrayDecision = new ArrayList<>();
        String message = "";

        if (currentValue <= lastValue) {
            //continue;
        } else if (currentValue > lastValue) {
            if ((100 * (startValue - currentValue)) / startValue > 5) {
                Double percentage = (100 * (startValue - currentValue)) / startValue;
                message = "Buy " + coin + ", the current price is " + currentValue + " USD. It is lower than " + startValue + " with " + percentage + "%.";
                startValue = currentValue;
                lastValue = currentValue;
            }
        }

        if (currentValue >= lastValue) {
            //continue;
        } else if (currentValue < lastValue) {
            if ((100 * (currentValue - startValue)) / currentValue > 5) {
                Double percentage = (100 * (currentValue - startValue)) / currentValue;
                message = "Sell " + coin + ", the current price is " + currentValue + " USD. It is higher than " + startValue + " with " + percentage + "%.";
                startValue = currentValue;
                lastValue = currentValue;
            }
        }

        lastValue = currentValue;

        arrayDecision.add(startValue);
        arrayDecision.add(lastValue);
        arrayDecision.add(message);
        return arrayDecision;
    }
}
