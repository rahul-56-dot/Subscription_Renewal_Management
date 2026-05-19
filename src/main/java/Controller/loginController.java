package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import DAO.dao;
import MODEL.model;



@WebServlet("/loginController")
public class loginController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	PrintWriter out=response.getWriter();
	RequestDispatcher rg;
	String uname=request.getParameter("username");
	String pwd=request.getParameter("password");
	try {
		model m=new model();
		m.setUsername(uname);
		m.setPassword(pwd);
		dao d=new dao();
		boolean result=d.login(m);
		if (result) {
			HttpSession session=request.getSession();
			session.setAttribute("username", uname);
//			session.setAttribute("password", pwd);
//			out.println("LoginSucces");
//			 rg=request.getRequestDispatcher("/DashboardController");
//			 rg.forward(request, response);
			response.sendRedirect("DashboardController");
			
			
		}
		else {
			out.println("<script>");
			out.println("alert('Invalid Username! OR Password! Please try again');");
			out.println("window.location='login.html';");
			out.println("</script>");
		}
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	}

}
