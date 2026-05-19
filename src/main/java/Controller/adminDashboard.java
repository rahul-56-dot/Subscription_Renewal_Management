package Controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

import DAO.dao;



@WebServlet("/adminDashboard")
public class adminDashboard extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            response.sendRedirect("admin.html");
            return;
        }

        try {
            dao d = new dao();
            request.setAttribute("plans", d.getAllUserSubscriptions());

            RequestDispatcher rd =
                    request.getRequestDispatcher("admin-dashboard.jsp");
            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
