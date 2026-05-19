package Controller;

import DAO.dao;
import MODEL.OTTPlatform;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/addOtt")
public class AddOttController extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        OTTPlatform p = new OTTPlatform();
        p.setId(Integer.parseInt(req.getParameter("id")));
        p.setName(req.getParameter("name"));
        p.setDescription(req.getParameter("description"));
        p.setImage(req.getParameter("image"));
     dao d=new dao();
    d.addPlatform(p);


    res.sendRedirect(req.getContextPath() + "/manageOtt");
    }
}