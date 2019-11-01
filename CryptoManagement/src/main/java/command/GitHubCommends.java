package command;

import driver.WebDriverBuilder;
import org.openqa.selenium.support.PageFactory;
import page.github.GitHubHomePage;
import page.github.GitHubLoginPage;
import page.github.GitHubRepositoryPage;
import page.github.GitHubUserPage;
import util.AppReadProperties;

public class GitHubCommends {

    GitHubHomePage gitHubHomePage;
    GitHubLoginPage gitHubLoginPage;
    GitHubUserPage gitHubUserPage;
    GitHubRepositoryPage gitHubRepositoryPage;
    WebDriverBuilder webDriverBuilder = new WebDriverBuilder();
    AppReadProperties appReadProperties = new AppReadProperties();

    public GitHubCommends() {
        webDriverBuilder.set("github");
    }

    public void login() throws InterruptedException {
        gitHubHomePage = PageFactory.initElements(webDriverBuilder.webDriver, GitHubHomePage.class);
        gitHubLoginPage = gitHubHomePage.clicktoSignInButton();
        Thread.sleep(2000);
        gitHubLoginPage.setTextToUsernameInput(appReadProperties.getGitHubUsername());
        gitHubLoginPage.setTextToPasswordInput(appReadProperties.getGitHubPassword());
        gitHubUserPage = gitHubLoginPage.clickToSignInButton();
        Thread.sleep(2000);
        gitHubRepositoryPage = gitHubUserPage.clickToRepository();
        gitHubRepositoryPage.openFile();
    }

}
