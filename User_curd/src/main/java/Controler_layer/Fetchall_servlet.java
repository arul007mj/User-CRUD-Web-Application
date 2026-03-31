package Controler_layer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model_layer.User;
import Model_layer.UserDao;
@WebServlet("/Fetchall")
public class Fetchall_servlet  extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession(false);
		if (session != null) {
			UserDao dao=new UserDao();
			ArrayList< User> list=new ArrayList<User>();
			try {
				list=dao.Fetch_all();
				req.setAttribute("list", list);
				RequestDispatcher Dispatcher=req.getRequestDispatcher("Fetchall.jsp");
				Dispatcher.forward(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			out.print("<h1> LOGIN FIRST ..............</h1>");
			RequestDispatcher Dispatcher=req.getRequestDispatcher("Login.jsp");
			Dispatcher.include(req, resp);
			
		}
	}
}
