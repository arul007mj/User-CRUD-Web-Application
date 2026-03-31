package Controler_layer;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model_layer.User;
import Model_layer.UserDao;
@WebServlet("/Update")
public class Updateuser_servlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserDao dao=new UserDao();
		
		int id=Integer.parseInt(req.getParameter("id"));
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		long ph_no =Long.parseLong(req.getParameter("ph_no"));
		
		User u=new User();
		u.setId(id);
		u.setFname(fname);
		u.setLname(lname);
		u.setEmail(email);
		u.setPassword(pass);
		u.setPh_no(ph_no);
		try {
		if (dao.Update(u)) {
			resp.sendRedirect("Fetchall");
		}else {
			resp.getWriter().println("<h1>UPDATE FAILED .......</h1>");
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
}
