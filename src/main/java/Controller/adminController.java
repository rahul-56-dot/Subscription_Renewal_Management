package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/adminController")
public class adminController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname="Koushik";
		String pswd="koushik123";
		PrintWriter out=response.getWriter();
		
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
		
		if (user.equals(uname)&& pass.equals(pswd)) {
			HttpSession session=request.getSession();
			session.setAttribute("username", user);

			response.sendRedirect("admin-dashboard.html");
			
			
		}
		else {
			out.println("<script>");
			out.println("alert('Invalid Username! OR Password! Please try again');");
			out.println("window.location='login.html';");
			out.println("</script>");
		}
	}

}
