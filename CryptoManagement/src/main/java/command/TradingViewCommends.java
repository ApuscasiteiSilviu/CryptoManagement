package command;

import builder.WebDriverBuilder;
import data.AppReadProperties;
import org.openqa.selenium.support.PageFactory;
import page.tradingView.*;

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

    public TradingViewCommends() {
        webDriverBuilder.set("tradingview");
    }

    public void login() throws InterruptedException {

        tradingViewHomePage = PageFactory.initElements(webDriverBuilder.webDriver, TradingViewHomePage.class);
        tradingViewLoginPage = tradingViewHomePage.clicktoSignInButton();

        Thread.sleep(2000);
        tradingViewLoginPage.setTextToEmailInput(appReadProperties.getUsername());
        tradingViewLoginPage.setTextToPasswordInput(appReadProperties.getPassword());
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
        tradingViewItemPage = tradingViewCryptoPricesPage.clickToItem(appReadProperties.getCryptoCoin());
    }

    public double calculatePercentage(){
        return ((double)100*(Double.parseDouble(tradingViewItemPage.takeValue()) - Double.parseDouble(appReadProperties.getLastPrice())))/Double.parseDouble(appReadProperties.getLastPrice());
    }
}
