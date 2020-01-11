import command.MathCommand;
import command.TradingViewCommand;
import cucumber.api.java.it.Ma;
import thirdParty.CryptoCompareGateway;
import thirdParty.CryptoPredictorGateway;
import thirdParty.Prediction;
import util.AppReadProperties;
import util.CryptoCoinMapping;
import util.MailUtil;
import util.UserReadProperties;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ApplicationManager {

    private UserReadProperties userReadProperties = new UserReadProperties();
    private AppReadProperties appReadProperties = new AppReadProperties();

    private TradingViewCommand tradingViewCommand;
    private MathCommand mathCommand = new MathCommand();
    private CryptoPredictorGateway cryptoPredictorGateway = new CryptoPredictorGateway();
    private CryptoCompareGateway cryptoCompareGateway = new CryptoCompareGateway();

    private Prediction prediction;


    private List<Double> startValue = new ArrayList<>();
    private List<Double> lastValue = new ArrayList<>();
    private List<String> coinList = Arrays.asList(userReadProperties.getCryptoCoin().split(","));

    public void initializeValues(){

        for (String coin:coinList){
            startValue.add(cryptoCompareGateway.getInitialValue(coin));
            lastValue.add(cryptoCompareGateway.getInitialValue(coin));
        }
    }

    public void manage(){

        /* --------------------------------------------------------- */
            // loop with all the crypto coins
                //take current value from the page for one crypto coin
                //take start and last value for that crypto coin
                //take decision
                //update values ( + send mail if its a good trade)

        /* -------------------------------------------------------- */

        tradingViewCommand = new TradingViewCommand();
        tradingViewCommand.login();

        System.out.println("Values before running");
        System.out.println("Start values: " + startValue.toString() + " and " + "Last values: " + lastValue.toString());
        System.out.println("");

        Integer index = 0;
       while (index < coinList.size()){

            //take current value from page
           tradingViewCommand.goToCurrency(CryptoCoinMapping.getAppValue(coinList.get(index)));
           System.out.println(coinList.get(index) + " current price: " + tradingViewCommand.getCurrentPrice() );

           prediction = cryptoPredictorGateway.getCoinPrediction(coinList.get(index));
           System.out.println("Prediction: " + prediction.getCoinPrice());

           // List<Object> list =  mathCommand.takeDecision(startValue.get(index), lastValue.get(index), prices[indexPricesList][index], coinList.get(index));
            List<Object> list =  mathCommand.takeDecision(startValue.get(index), lastValue.get(index), Double.valueOf(tradingViewCommand.getCurrentPrice()), coinList.get(index));

            //update values
            startValue.set(index, Double.valueOf(String.valueOf(list.get(0))));
            lastValue.set(index, Double.valueOf(String.valueOf(list.get(1))));

           //send mail
           if (list.get(2) != ""){
               System.out.println(list.get(2));
               try {
                   MailUtil.sendMail( userReadProperties.getGmailAccount(), appReadProperties.getApplicationGmailAccountName(), "It's time to make a trade" ,  list.get(2) + " Tomorrow, this value could be " + prediction.getCoinPrice() + " " + prediction.getCurrency());
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }

            index++;
       }

        System.out.println("");
        System.out.println("Values after running");
        System.out.println("Start values: " + startValue.toString() + " and " + "Last values: " + lastValue.toString());

       tradingViewCommand.closeThePage();
    }

    public void closeDriverConnectionWithTradingViewSite(){
        tradingViewCommand = new TradingViewCommand();
        tradingViewCommand.closeThePage();
    }

    public void sendRegistrationEmail(){
        try {
            MailUtil.sendMail(userReadProperties.getGmailAccount(), appReadProperties.getApplicationGmailAccountName(), "CryptoManagement registration", "Welcome to our team! :)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendLifeServerCheckEmail(){
        try {
            MailUtil.sendMail(appReadProperties.getApplicationGmailAccountName(), appReadProperties.getApplicationGmailAccountName(), "Server life cycle", "Hello sir, The server is still running! Thank you! :)");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
