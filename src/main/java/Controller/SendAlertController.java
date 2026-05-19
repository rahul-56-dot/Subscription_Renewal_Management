package Controller;

import java.io.IOException;

import DAO.MailUtil;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sendAlert")
public class SendAlertController extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {

        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String plan = request.getParameter("plan");

        try {
        	
            MailUtil.sendExpiryAlert(email, username, plan);
            response.sendRedirect(
                "adminDashboard?msg=mailSent");

        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect(
                "adminDashboard?msg=mailError");
        }
    }
}
