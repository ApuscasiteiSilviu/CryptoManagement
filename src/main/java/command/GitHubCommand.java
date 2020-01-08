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

    public void login(){
        gitHubHomePage = PageFactory.initElements(webDriverBuilder.webDriver, GitHubHomePage.class);
        gitHubLoginPage = gitHubHomePage.clicktoSignInButton();
        gitHubLoginPage.setTextToUsernameInput(appReadProperties.getGitHubUsername());
        gitHubLoginPage.setTextToPasswordInput(appReadProperties.getGitHubPassword());
        gitHubUserPage = gitHubLoginPage.clickToSignInButton();
    }

    public void deleteFile(){
        gitHubRepositoryPage = gitHubUserPage.clickToRepository();
        gitHubRepositoryPage.clickToDeleteFile();
    }

    public void createNewFile(String cryptoCoin, String gmailAccount){
        gitHubRepositoryPage.clickToCreateNewFile();
        gitHubRepositoryPage.setTextToNewNameInput("user.properties");
        writeFile(cryptoCoin, gmailAccount);
        gitHubRepositoryPage.setTextToCommitMessageInput("Update user.properties file for the new user");
        gitHubRepositoryPage.commitChanges();
    }

    public void writeFile(String cryptoCoin, String gmailAccount){
        gitHubRepositoryPage.writeText(UserCredentialConstants.CRYPTO_COIN + "=" + cryptoCoin + "\n"
                                        + UserCredentialConstants.GMAIL_ACCOUNT + "=" + gmailAccount + "\n");

    }

}
