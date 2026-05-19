package Controller;

import DAO.dao;
import MODEL.OTTPlatform;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/DashboardController")
public class DashboardController extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        dao d = new dao();
        List<OTTPlatform> platforms = d.getAllPlatforms();

        req.setAttribute("platforms", platforms);
        RequestDispatcher rd = req.getRequestDispatcher("dashboard.jsp");
        rd.forward(req, res);
    }
}
