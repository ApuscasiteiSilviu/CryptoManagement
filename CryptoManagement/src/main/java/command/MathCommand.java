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
            if ((100 * (startValue - currentValue)) / startValue > 2) {
                // gmailCommends.sendMail();
                Double percentage = (100 * (startValue - currentValue)) / startValue;
                //System.out.println("make trade (price is lower) " + (100 * (startValue - currentValue)) / startValue);
                message = "Buy " + coin + ", price is lower than " + startValue + " with " + percentage + "%";
                startValue = currentValue;
                lastValue = currentValue;
                //System.out.println("start value = " + startValue);
            }
        }

        if (currentValue >= lastValue) {
            //continue;
        } else if (currentValue < lastValue) {
            if ((100 * (currentValue - startValue)) / currentValue > 2) {
                Double percentage = (100 * (currentValue - startValue)) / currentValue;
                //gmailCommends.sendMail();
                //System.out.println("make trade (price is higher) " + (100 * (currentValue - startValue)) / currentValue);
                message = "Sell " + coin + ", price is higher than " + startValue + " with " + percentage + "%";
                startValue = currentValue;
                lastValue = currentValue;
               // System.out.println("start value = " + startValue);
            }
        }

        lastValue = currentValue;

        arrayDecision.add(startValue);
        arrayDecision.add(lastValue);
        arrayDecision.add(message);
        return arrayDecision;
    }
}
