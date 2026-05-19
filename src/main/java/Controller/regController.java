package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.jasper.compiler.Node.ForwardAction;

import DAO.dao;
import MODEL.model;


@WebServlet("/regController")
public class regController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		RequestDispatcher rg;
		String fname=request.getParameter("fullname");
		String uname=request.getParameter("username");
		String email=request.getParameter("email");
		String phn=request.getParameter("contact");
		String pass=request.getParameter("password");
		try {
			model md=new model();
			md.setFullname(fname);
			md.setUsername(uname);
			md.setEmail(email);
			md.setContact(phn);
			md.setPassword(pass);
			dao d=new dao();
			int i=d.register(md);
			if (i==1) {
//				out.println("Data Stored'");
				rg=request.getRequestDispatcher("login.html");
				rg.forward(request, response);
			}
			else {
				out.println("Failed To Store");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
