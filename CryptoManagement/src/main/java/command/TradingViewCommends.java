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

    public void login() throws InterruptedException {

        tradingViewHomePage = PageFactory.initElements(webDriverBuilder.webDriver, TradingViewHomePage.class);
        tradingViewLoginPage = tradingViewHomePage.clicktoSignInButton();

        Thread.sleep(2000);
        tradingViewLoginPage.setTextToEmailInput(userReadProperties.getUsernameApplication());
        tradingViewLoginPage.setTextToPasswordInput(userReadProperties.getPasswordApplication());
        tradingViewSearchPage = tradingViewLoginPage.clickToLoginButton();
    }


    public void goToCurrency() throws InterruptedException {
        Thread.sleep(4000);
        tradingViewMarketPage = tradingViewSearchPage.clickToMarketButton();
        Thread.sleep(3000);
        tradingViewCryptocurrencyMarketPage = tradingViewMarketPage.clickToCryptocurrencyButton();
        Thread.sleep(3000);
        tradingViewCryptoPricesPage = tradingViewCryptocurrencyMarketPage.clickToMoreCryptocurrenciesButton();
        Thread.sleep(3000);
        tradingViewItemPage = tradingViewCryptoPricesPage.clickToItem(userReadProperties.getCryptoCoin());
    }

    public double calculatePercentage(){
        return ((double)100*(Double.parseDouble(tradingViewItemPage.takeValue()) - Double.parseDouble(appReadProperties.getLastPrice())))/Double.parseDouble(appReadProperties.getLastPrice());
    }
}
