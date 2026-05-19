package Controller;

import java.io.IOException;
import java.util.List;

import DAO.dao;
import MODEL.OTTPlatform;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/manageOtt")
public class ManageOttController extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        dao d = new dao();
        List<OTTPlatform> platforms = d.getAllPlatforms();

        request.setAttribute("platforms", platforms);

        // ✅ FORWARD to JSP
        request.getRequestDispatcher("manage-ott.jsp")
               .forward(request, response);
    }
}
