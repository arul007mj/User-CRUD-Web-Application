package Controler_layer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model_layer.User;
import Model_layer.UserDao;
@WebServlet("/Login")
public class Login_servlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		PrintWriter out=resp.getWriter();
		String email=req.getParameter("email");
		String pass=req.getParameter("password");
		UserDao dao=new UserDao();
		
		try {
			User u=dao.Fetchby_email(email);
			if (u!=null) {
				if (u.getPassword().equals(pass)) {
					out.print("<h1>  LOGIN SUCCESSFULLY  .........</h1> ");
					HttpSession session=req.getSession(true);
					RequestDispatcher dispatcher=req.getRequestDispatcher("Fetchall");
					dispatcher.forward(req, resp);
					
				}else {
					out.print("<h1> invalid password .........</h1> ");
					RequestDispatcher dispatcher=req.getRequestDispatcher("Login.jsp");
					dispatcher.include(req, resp);				}
			}else {
				out.print("<h1> invalid email .........</h1> ");
				RequestDispatcher dispatcher=req.getRequestDispatcher("Login.jsp");
				dispatcher.include(req, resp);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
