package command;

import util.AppReadProperties;
import util.MailUtil;
import util.UserReadProperties;

public class GmailCommends {

    private AppReadProperties appReadProperties = new AppReadProperties();
    private UserReadProperties userReadProperties = new UserReadProperties();
    private MailUtil mailUtil = new MailUtil();

    public void sendMail(){
        mailUtil.sendMail(userReadProperties.getGmailAccount(), appReadProperties.getGmailUsername(), appReadProperties.getGmailPassword());
    }
}
