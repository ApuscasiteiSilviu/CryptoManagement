package command;

import driver.WebDriverBuilder;
import org.openqa.selenium.support.PageFactory;
import page.github.GitHubHomePage;
import page.github.GitHubLoginPage;
import page.github.GitHubRepositoryPage;
import page.github.GitHubUserPage;
import util.AppReadProperties;
import util.UserCredentialConstants;

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

    public void createNewFile(String username, String password, String cryptoCoin, String gmailAccount) throws InterruptedException{
        gitHubRepositoryPage.clickToCreateNewFile();
        gitHubRepositoryPage.setTextToNewNameInput("user.properties");
        writeFile(username, password, cryptoCoin, gmailAccount);
        gitHubRepositoryPage.setTextToCommitMessageInput("Update user.properties file for the new user");
        gitHubRepositoryPage.commitChanges();
    }

    public void writeFile(String username, String password, String cryptoCoin, String gmailAccount){
        gitHubRepositoryPage.writeText(UserCredentialConstants.USER_NAME + "=" + username + "\n"
                                        + UserCredentialConstants.PASSWORD + "=" + password + "\n"
                                        + UserCredentialConstants.CRYPTO_COIN + "=" + cryptoCoin + "\n"
                                        + UserCredentialConstants.GMAIL_ACCOUNT + "=" + gmailAccount + "\n");

    }

}
