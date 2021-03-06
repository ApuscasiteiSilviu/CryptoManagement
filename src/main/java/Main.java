import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class Main {

    private static ApplicationManager applicationManager = new ApplicationManager();
    private static SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");



    public static void main(String args[]) throws Exception {

        /* --------------------------------------------------------------------------- */
        //applicationManager.sendRegistrationEmail();
        applicationManager.initializeValues();


        Runnable runnable = new Runnable() {
            int count = 0;
            public void run() {
                System.out.println("************************************** run *****************************************");
                while(true){
                    try {
                        applicationManager.manage();
                        break;
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Exception on trading view site...");
                        applicationManager.closeDriverConnectionWithTradingViewSite();
                    }
                }

                if(count % 23 == 0) {
                    try {
                        applicationManager.sendLifeServerCheckEmail();
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Exception on sending email...");
                    }
                }
                System.out.println("Waiting for the next run...");
                count++;
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(runnable, 0, 1, TimeUnit.HOURS);
}


}
