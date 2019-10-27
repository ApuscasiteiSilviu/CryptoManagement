package command;

import data.AppReadProperties;
import gmail.MailUtil;

public class GmailCommends {

    private AppReadProperties appReadProperties = new AppReadProperties();
    private MailUtil mailUtil = new MailUtil();

    public void sendMail(){
        mailUtil.sendMail(appReadProperties.getGmailAccount());
    }
}
