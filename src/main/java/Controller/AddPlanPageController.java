package Controller;

import DAO.dao;
import MODEL.OTTPlatform;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;
import java.io.IOException;

@WebServlet("/showAddPlan")
public class AddPlanPageController extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        dao d = new dao();

        // 1. Get platformId from request parameter
        String platformIdStr = req.getParameter("platform");
        if (platformIdStr == null || platformIdStr.isEmpty()) {
            res.getWriter().println("Error: Platform ID is missing!");
            return;
        }

        int platformId;
        try {
            platformId = Integer.parseInt(platformIdStr);
        } catch (NumberFormatException e) {
            res.getWriter().println("Error: Invalid Platform ID!");
            return;
        }

        // 2. Fetch platform from DB
        OTTPlatform platform = (OTTPlatform) d.getPlansByPlatformId(platformId);
        if (platform == null) {
            res.getWriter().println("Error: Platform not found!");
            return;
        }

        // 3. Put platform in request scope and forward to JSP
        req.setAttribute("platform", platform);
        req.getRequestDispatcher("manage-plans.html").forward(req, res);
    }
}
