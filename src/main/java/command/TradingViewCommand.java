package command;

import driver.WebDriverBuilder;
import org.openqa.selenium.support.PageFactory;
import page.tradingView.*;
import util.UserReadProperties;

public class TradingViewCommand {

    TradingViewHomePage tradingViewHomePage;
    TradingViewLoginPage tradingViewLoginPage;
    TradingViewSearchPage tradingViewSearchPage;
    TradingViewMarketPage tradingViewMarketPage;
    TradingViewCryptocurrencyMarketPage tradingViewCryptocurrencyMarketPage;
    TradingViewCryptoPricesPage tradingViewCryptoPricesPage;
    TradingViewItemPage tradingViewItemPage;
    WebDriverBuilder webDriverBuilder = new WebDriverBuilder();
    UserReadProperties userReadProperties = new UserReadProperties();

    public TradingViewCommand() {
        webDriverBuilder.set("tradingview");
    }

    public void login(){

        tradingViewHomePage = PageFactory.initElements(webDriverBuilder.webDriver, TradingViewHomePage.class);
        tradingViewLoginPage = tradingViewHomePage.clicktoSignInButton();
        tradingViewLoginPage.setTextToEmailInput(userReadProperties.getUsernameApplication());
        tradingViewLoginPage.setTextToPasswordInput(userReadProperties.getPasswordApplication());
        tradingViewSearchPage = tradingViewLoginPage.clickToLoginButton();
    }

    public void goToCurrency(String coin){
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
}
