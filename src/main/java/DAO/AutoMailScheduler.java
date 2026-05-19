package DAO;

import java.util.List;
import MODEL.model;

public class AutoMailScheduler implements Runnable {

    @Override
    public void run() {
        try {
            dao d = new dao();

            List<model> list = d.getSubscriptionsForAlert();

            for (model m : list) {

                // Send alert mail
                MailUtil.sendExpiryAlert(
                    m.getEmail(),
                    "Subscription Expiry Alert",
                    "Dear User,\n\nYour subscription plan \""
                            + m.getPlanName()
                            + "\" will expire on "
                            + m.getEndDate()
                            + ".\n\nPlease renew to avoid interruption.\n\nThank you."
                );

                // Mark alert as sent (VERY IMPORTANT)
                d.markAlertSent(m.getSubId());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
