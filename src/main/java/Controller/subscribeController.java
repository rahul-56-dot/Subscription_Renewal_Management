package Controller;

import java.io.IOException;
import java.time.LocalDate;

import DAO.dao;
import MODEL.OTTPlatform;
import MODEL.model;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/subscribe")
public class subscribeController extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);
        if (session == null || session.getAttribute("username") == null) {
            res.sendRedirect("login.html");
            return;
        }

        String username = (String) session.getAttribute("username");

        int platformId = Integer.parseInt(req.getParameter("platform"));
        String planName = req.getParameter("planName");

        System.out.println("Subscribe: username=" + username
            + " | platformId=" + platformId
            + " | planName=" + planName);

        dao d = new dao();

        OTTPlatform platformObj = d.getPlatformById(platformId);
        if (platformObj == null) {
            System.out.println("Platform not found for id: " + platformId);
            throw new IllegalArgumentException("Platform not found: " + platformId);
        }
        System.out.println("Platform found: " + platformObj.getName());

        OTTPlatform plan = d.getPlanByPlatformAndName(platformId, planName);
        if (plan == null) {
            System.out.println("Plan not found: " + planName);
            throw new IllegalArgumentException("Plan not found: " + planName);
        }
        System.out.println("Plan found: " + plan.getName() + " duration=" + plan.getDuration());

        int days;
        try {
            days = Integer.parseInt(plan.getDuration());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid duration: " + plan.getDuration());
        }

        LocalDate startDate = LocalDate.now();
        LocalDate endDate = startDate.plusDays(days);

        model m = new model();
        m.setUsername(username);
        m.setPlatform(platformObj.getName());
        m.setPlanName(planName);
        m.setStartDate(startDate);
        m.setEndDate(endDate);

        System.out.println("Saving: platform=" + m.getPlatform()
            + " | planName=" + m.getPlanName());

        boolean subscribed = d.addSubscription(m);

        if (!subscribed) {
            System.out.println("Already subscribed to: " + m.getPlatform());
            req.setAttribute("error",
                "You already have an active subscription for this platform");
            req.getRequestDispatcher("dashboard.jsp").forward(req, res);
            return;
        }

        System.out.println("Subscription saved successfully!");
        res.sendRedirect("currentPlan");
    }
}