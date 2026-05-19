package Controller;

import java.io.IOException;

import DAO.dao;
import MODEL.OTTPlatform;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addPlan")
public class AddPlanController extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        int platformId = Integer.parseInt(req.getParameter("platformId"));

        OTTPlatform plan = new OTTPlatform();
        plan.setPlatform(Integer.parseInt(req.getParameter("platformId")));
        plan.setName(req.getParameter("planName"));
        plan.setPrice(Double.parseDouble(req.getParameter("price")));
        plan.setDuration(req.getParameter("duration")); // e.g., "1 month"

        dao d = new dao();
        d.addPlan(plan);  // Make sure dao.addPlan(OTTPlan plan) exists

        // Redirect back to manage plans for this platform
        res.sendRedirect("managePlans.jsp?platformId=" + platformId);
    }
}
