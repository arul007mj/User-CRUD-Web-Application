<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="./saveuser.css">
</head>

<body>
<main>
<div class="left">
<img alt="img" src="https://img.freepik.com/premium-vector/add-user-icon_1076610-24955.jpg?semt=ais_incoming&w=740&q=80">
</div>
<div class="right">
<form action="save_user" method="post">
<div class="add">
<h1>ADD NEW USER </h1>
<label>ENTER THE ID</label>
<input type="number" name="id"><br><br>
<label>ENTER THE FIRST NAME </label>
<input type="text" name="fname"><br><br>
<label>ENTER THE LAST NAME </label>
<input type="text" name="lname"><br><br>
<label>ENTER THE EMAIL </label>
<input type="text" name="email"><br><br>
<label>ENTER THE PASSWORD	 </label>
<input type="text" name="password"><br><br>
<label>ENTER THE PHONE NUMBER </label>
<input type="tel" name="ph_no"><br><br>
<button type="submit">SUBMIT</button>
</div>
</form>
</div> 
</main>
</body>
</html>