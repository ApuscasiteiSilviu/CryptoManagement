package command;

import util.AppReadProperties;
import util.MailUtil;

public class GmailCommends {

    private AppReadProperties appReadProperties = new AppReadProperties();
    private MailUtil mailUtil = new MailUtil();

    public void sendMail(){
        mailUtil.sendMail(appReadProperties.getGmailAccount());
    }
}
