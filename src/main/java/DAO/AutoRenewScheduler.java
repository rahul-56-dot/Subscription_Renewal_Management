package DAO;

import java.util.List;
import MODEL.model;

public class AutoRenewScheduler implements Runnable {

    @Override
    public void run() {
        try {
            dao d = new dao();

            List<model> list = d.getAutoRenewPlans();

            for (model m : list) {

                // Renew subscription
                d.autoRenewSubscription(m.getSubId());

                // Send confirmation mail
                MailUtil.sendExpiryAlert(
                    m.getEmail(),
                    "Subscription Renewed Successfully",
                    "Dear User,\n\nYour subscription has been auto-renewed successfully."
                            + "\n\nThank you for staying with us."
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
