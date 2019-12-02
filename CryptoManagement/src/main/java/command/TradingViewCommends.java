package command;

import driver.WebDriverBuilder;
import util.AppReadProperties;
import org.openqa.selenium.support.PageFactory;
import page.tradingView.*;
import util.UserReadProperties;

public class TradingViewCommends {

    TradingViewHomePage tradingViewHomePage;
    TradingViewLoginPage tradingViewLoginPage;
    TradingViewSearchPage tradingViewSearchPage;
    TradingViewMarketPage tradingViewMarketPage;
    TradingViewCryptocurrencyMarketPage tradingViewCryptocurrencyMarketPage;
    TradingViewCryptoPricesPage tradingViewCryptoPricesPage;
    TradingViewItemPage tradingViewItemPage;
    WebDriverBuilder webDriverBuilder = new WebDriverBuilder();
    AppReadProperties appReadProperties = new AppReadProperties();
    UserReadProperties userReadProperties = new UserReadProperties();

    public TradingViewCommends() {
        webDriverBuilder.set("tradingview");
    }

    public void login(){

        tradingViewHomePage = PageFactory.initElements(webDriverBuilder.webDriver, TradingViewHomePage.class);
        tradingViewLoginPage = tradingViewHomePage.clicktoSignInButton();

        tradingViewLoginPage.setTextToEmailInput(userReadProperties.getUsernameApplication());
        tradingViewLoginPage.setTextToPasswordInput(userReadProperties.getPasswordApplication());
        tradingViewSearchPage = tradingViewLoginPage.clickToLoginButton();
    }


    public void goToCurrency(String coin) throws Exception{
        tradingViewMarketPage = tradingViewSearchPage.clickToMarketButton();
        tradingViewCryptocurrencyMarketPage = tradingViewMarketPage.clickToCryptocurrencyButton();
        tradingViewCryptoPricesPage = tradingViewCryptocurrencyMarketPage.clickToMoreCryptocurrenciesButton();
        tradingViewItemPage = tradingViewCryptoPricesPage.clickToItem(coin);
    }

    public String getCurrentPrice(){
        return tradingViewItemPage.takeValue();
    }

    public void closeThePage(){
        webDriverBuilder.tearDown();
    }

//    public double calculatePercentage(){
//        return ((double)100*(Double.parseDouble(tradingViewItemPage.takeValue()) - Double.parseDouble(appReadProperties.getLastPrice())))/Double.parseDouble(appReadProperties.getLastPrice());
//    }
}
