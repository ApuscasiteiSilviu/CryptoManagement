package command;

import driver.WebDriverBuilder;
import gherkin.lexer.Th;
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
    }

    public void deleteFile() throws InterruptedException {
        Thread.sleep(2000);
        gitHubRepositoryPage = gitHubUserPage.clickToRepository();
        gitHubRepositoryPage.clickToDeleteFile();
    }

    public void createNewFile() throws InterruptedException{
        gitHubRepositoryPage.clickToCreateNewFile();
        gitHubRepositoryPage.setTextToNewNameInput("user.properties");
        writeFile();
        gitHubRepositoryPage.setTextToCommitMessageInput("Update user.properties file for the new user");
        gitHubRepositoryPage.commitChanges();
    }

    public void writeFile() throws InterruptedException {
        gitHubRepositoryPage.writeText("usernameApplication=silviu.alex95@yahoo.ro" + "\n"
                                        + "passwordApplication=MakeMoney99" + "\n"
                                        + "cryptoCoin=BTCUSD" + "\n"
                                        + "gmailAccount=silviuapu" + "\n");

    }

}
