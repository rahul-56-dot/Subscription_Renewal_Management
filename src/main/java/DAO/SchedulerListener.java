package DAO;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class SchedulerListener implements ServletContextListener {

    private ScheduledExecutorService scheduler;

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        scheduler = Executors.newSingleThreadScheduledExecutor();

        // Auto Alert Scheduler (runs once per day)
        scheduler.scheduleAtFixedRate(
                new AutoMailScheduler(),
                0,
                1,
                TimeUnit.DAYS
        );

        // Auto Renew Scheduler (runs once per day)
        scheduler.scheduleAtFixedRate(
                new AutoRenewScheduler(),
                0,
                1,
                TimeUnit.DAYS
        );

        System.out.println("Schedulers started successfully");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

        if (scheduler != null) {
            scheduler.shutdown();
        }

        System.out.println("Schedulers stopped");
    }
}
