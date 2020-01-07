package command;

import driver.WebDriverBuilder;
import org.openqa.selenium.support.PageFactory;
import page.github.GitHubHomePage;
import page.github.GitHubLoginPage;
import page.github.GitHubRepositoryPage;
import page.github.GitHubUserPage;
import util.AppReadProperties;
import util.UserCredentialConstants;

public class GitHubCommand {

    GitHubHomePage gitHubHomePage;
    GitHubLoginPage gitHubLoginPage;
    GitHubUserPage gitHubUserPage;
    GitHubRepositoryPage gitHubRepositoryPage;
    WebDriverBuilder webDriverBuilder = new WebDriverBuilder();
    AppReadProperties appReadProperties = new AppReadProperties();

    public GitHubCommand() {
        webDriverBuilder.set("github");
    }

    public void login() throws InterruptedException {
        gitHubHomePage = PageFactory.initElements(webDriverBuilder.webDriver, GitHubHomePage.class);
        gitHubLoginPage = gitHubHomePage.clicktoSignInButton();
        gitHubLoginPage.setTextToUsernameInput(appReadProperties.getGitHubUsername());
        gitHubLoginPage.setTextToPasswordInput(appReadProperties.getGitHubPassword());
        gitHubUserPage = gitHubLoginPage.clickToSignInButton();
    }

    public void deleteFile() throws InterruptedException {
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
        gitHubRepositoryPage.writeText(UserCredentialConstants.CRYPTO_COIN + "=" + cryptoCoin + "\n"
                                        + UserCredentialConstants.GMAIL_ACCOUNT + "=" + gmailAccount + "\n");

    }

}
