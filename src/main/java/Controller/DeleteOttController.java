package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.dao;
import java.io.IOException;

@WebServlet("/deleteOtt")
public class DeleteOttController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        dao d = new dao();
        d.deleteOttPlatform(id);

        // Redirect back to list page
        response.sendRedirect(request.getContextPath() + "/manageOtt");
    }
}
