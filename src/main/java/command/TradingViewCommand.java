package command;

import driver.WebDriverBuilder;
import org.openqa.selenium.support.PageFactory;
import page.tradingView.*;
import util.AppReadProperties;
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
    AppReadProperties appReadProperties = new AppReadProperties();

    public TradingViewCommand() {
        webDriverBuilder.set("tradingview");
    }

    public void login(){

        tradingViewHomePage = PageFactory.initElements(webDriverBuilder.webDriver, TradingViewHomePage.class);
        tradingViewHomePage.closePopup();
        tradingViewLoginPage = tradingViewHomePage.clicktoSignInButton();
        tradingViewLoginPage.setTextToEmailInput(appReadProperties.getUsernameApplication());
        tradingViewLoginPage.setTextToPasswordInput(appReadProperties.getPasswordApplication());
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
