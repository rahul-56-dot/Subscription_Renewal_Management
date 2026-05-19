package Controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

import DAO.dao;
import MODEL.model;

@WebServlet("/currentPlan")
public class CurrentPlanController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // ✅ Check session null first
        HttpSession session = request.getSession(false);
        if (session == null) {
            response.sendRedirect("login.html");
            return;
        }

        String username = (String) session.getAttribute("username");
        System.out.println("Logged user: " + username);

        // ✅ Then check username null
        if (username == null) {
            response.sendRedirect("login.html");
            return;
        }

        dao d = new dao();
        List<model> plans = null;

        try {
            plans = d.getAllSubscriptions(username);
        } catch (Exception e) {
            e.printStackTrace();
        }

        request.setAttribute("plans", plans);
        RequestDispatcher rd = request.getRequestDispatcher("currentplan.jsp");
        rd.forward(request, response);
    }
}