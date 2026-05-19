package Controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import DAO.dao;


@WebServlet("/deactivatePlan")
public class DeactivatePlanController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        HttpSession session = request.getSession(false);

        // Admin security check
        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("admin-login.html");
            return;
        }

        int subId = Integer.parseInt(request.getParameter("subId"));

        try {
            dao d = new dao();
            d.deactivatePlan(subId);
            response.sendRedirect("adminDashboard");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
