package Model_layer;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserDao {

	String name="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/user_db";
	String user="root";
	String pass="root";
		
	
	
	public  Connection Getconnection() {
		Connection c=null;
	try {
	 Class.forName(name);
	 c=DriverManager.getConnection(url,user,pass);
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return c;	
	}
	
	public void Add_user(User u) {
		Connection c=Getconnection();
		
		PreparedStatement ps;
		try {
			ps = c.prepareStatement("insert into Users_table values(?,?,?,?,?,?)");
			ps.setInt(1,u.getId());
			ps.setString(2,u.getFname());
			ps.setString(3,u.getLname());
			ps.setString(4,u.getEmail());
			ps.setString(5,u.getPassword());
			ps.setLong(6,u.getPh_no());
			ps.executeUpdate();
			

			
			System.out.println("\t\t\t ========== DATA INSERTED =============");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ArrayList<User> Fetch_all() throws SQLException{
		
		Connection c=Getconnection();
		PreparedStatement ps=c.prepareStatement("select * from users_table");
		ResultSet rs=ps.executeQuery();
		User u;
		ArrayList< User> list= new ArrayList<User>();
		while (rs.next()) {
			int id=rs.getInt(1);
			String fname=rs.getString(2);
			String lname=rs.getString(3);
			String email=rs.getString(4);
			String password=rs.getString(5);
			long ph_no=rs.getLong(6);
			
			u=new User(id, fname, lname, email, password,ph_no );
			list.add(u);
		}
		return list;	
	}
	
	public User Fetchby_id (int u_id) throws Exception {
		Connection c=Getconnection();
		PreparedStatement ps=c.prepareStatement("Select * from Users_table where id=?");
		ps.setInt(1, u_id);
		User u=null;
		ResultSet rs=ps.executeQuery();
		 if (rs.next()) {
				int id=rs.getInt(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				String email=rs.getString(4);
				String password=rs.getString(5);
				long ph_no=rs.getLong(6);
				
				  u=new User(id, fname, lname, email, password,ph_no );
			
			}
		return u;
	}
	
	public User Fetchby_email (String u_email) throws Exception {
		Connection c=Getconnection();
		PreparedStatement ps=c.prepareStatement("Select * from Users_table where email=?");
		ps.setString(1, u_email);
		User u=null;
		ResultSet rs=ps.executeQuery();
		 if (rs.next()) {
				int id=rs.getInt(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				String email=rs.getString(4);
				String password=rs.getString(5);
				long ph_no=rs.getLong(6);
				
			 u=new User(id, fname, lname, email, password,ph_no );
			
			}else {
				u=null;
			}
		return u;
	}
	
	public  void Delete( int u_id) throws SQLException {
		Connection c=Getconnection();
		PreparedStatement ps=c.prepareStatement("delete from users_table where id=?");
		ps.setInt(1, u_id);
		ps.executeUpdate();
		System.out.println("\t\t\t ========== DATA DELETED =============");
	}
	
	public  boolean Update(User u) throws SQLException {
		boolean res=false;
		Connection c=Getconnection();
		PreparedStatement ps=c.prepareStatement("update users_table set name=?,lname=?,email=?,password=?,ph_no=?  where id=?");
		ps.setInt(6, u.getId());
		ps.setString(1, u.getFname());
		ps.setString(2, u.getLname());
		ps.setString(3, u.getEmail());
		ps.setString(4, u.getPassword());
		ps.setLong(5, u.getPh_no());
		int rows=ps.executeUpdate();
		if (rows>0) {
			res=true;
		}
		return res;
	}
	
	public ArrayList<User> find(String u_input) throws Exception {
		Connection c=Getconnection();
		PreparedStatement ps=c.prepareStatement("Select * from Users_table where email like ? or name like ?");
		ps.setString(1, u_input+"%%");
		ps.setString(2, u_input+"%%");
		
		ArrayList<User> li=new ArrayList<User>();
		ResultSet rs=ps.executeQuery();
		 while(rs.next()) {
				int id=rs.getInt(1);
				String fname=rs.getString(2);
				String lname=rs.getString(3);
				String email=rs.getString(4);
				String password=rs.getString(5);
				long ph_no=rs.getLong(6);
				
			  User u=new User(id, fname, lname, email, password,ph_no );
			li.add(u);
			}
		return li;
	}
}
