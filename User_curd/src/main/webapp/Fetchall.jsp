<%@page import="java.util.ArrayList"%>
<%@page import="Model_layer.User"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./home.css">
</head>
<body>

<main>
<nav>
<div class="app"><h1>user management app <em>user</em></h1></div>
<div class="log">
<ul>
<li><a href="./Login.jsp" >LOGIN</a></li>
<li><a href="Logout">LOGOUT</a></li>
</ul>
</div>
</nav>
	<h1>list of users </h1> 
	<div class="line"></div>
	<br>
	<section>
	
				
	<div class="btn"><a href="Saveuser.jsp"><button>add new user</button></a></div>
	<div class="find"><form action="find" method="get">
	<input type="text" placeholder="Enter The Name Or Email" name="find"><button type="submit">Search</button>
	</form></div>
	<div class="tab">
 	<table border="1.5px">
				<tr>
				<th> ID </th>
				<th> FIRST NAME </th>
				<th> LAST NAME </th>
				<th> EMAIL </th>
				<th> PASSWORD </th>
				<th> PHONE NUMBER</th>
				<th> DELETE COLUMN </th>
				<th> UPDATE COLUMN</th>
				</tr>
				<%ArrayList<User> list=(ArrayList<User>)request.getAttribute("list");
				for(User u:list){%>
				<form action="Update?id=<%=u.getId()%>" method="post">
				<tr>
				<td><%= u.getId() %></td>
				<td><input type="text" value="<%= u.getFname()%>" name="fname"></td>
				<td><input type="text" value="<%= u.getLname() %>" name="lname"></td>
				<td><input type="text" value="<%= u.getEmail() %>" name="email"></td>
				<td><input type="text" value="<%= u.getPassword()%>"name="password" ></td>
				<td><input type="text" value="<%= u.getPh_no() %>" name="ph_no" ></td>
				<td><a href="Delete?id=<%=u.getId()%>" style="text-decoration:none;">DELETE</a></td>
				<td><button type="submit">Update</button></td>
				</tr>
				</form>
				<%} %>
		</table>
		</div>
		</section>		
</main> 
</body>
</html>