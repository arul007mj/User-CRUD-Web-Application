package Controler_layer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model_layer.User;
import Model_layer.UserDao;

@WebServlet("/save_user")
public class save_userservlet extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter out=resp.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		long ph_no=Long.parseLong(req.getParameter("ph_no"));
		
		User u=new User(id, fname, lname, email, pass, ph_no);
		
		UserDao dao=new UserDao();
		
		dao.Add_user(u);
		resp.sendRedirect("Fetchall");
	
	}
	
}
