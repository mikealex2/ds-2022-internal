<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width,initial-scale=1.0">
	<link href="https://fonts.googleapis.com/css?family=Nunito+Sans:300i,400,700&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/css/bootstrap.min.css">
    <title>Menu</title>
	<style>
		form{
			text-align: center;
		}
		*{
			text-align: center;
		}
		.navigation {
			height: 70px;
			background:rgb(29, 161, 242);
		}
		.brand {
			position: absolute;
			padding-left: 20px;
			float: left;
			line-height: 70px;
			text-transform: uppercase;
			font-size: 1.4em;
		}
		.brand a,
		.brand a:visited {
			color: #ffffff;
			text-decoration: none;
		}
		.nav-container {
			max-width: 1000px;
			margin: 0 auto;
		}
		nav {
			float: right;
		}
		nav ul {
			list-style: none;
			margin: 0;
			padding: 0;
		}
		nav ul li {
			float: left;
			position: relative;
		}
		nav ul li a,
		nav ul li a:visited {
			display: block;
			padding: 0 20px;
			line-height: 70px;
			background: rgb(29, 161, 242);
			color: #ffffff;
			text-decoration: none;
		}
		nav ul li a:hover,
		nav ul li a:visited:hover {
			background: #2581dc;
			color: #ffffff;
		}
		nav ul li a:not(:only-child):after,
		nav ul li a:visited:not(:only-child):after {
			padding-left: 4px;
			content: " ▾";
		}
		nav ul li ul li {
			min-width: 190px;
		}
		nav ul li ul li a {
			padding: 15px;
			line-height: 20px;
		}
		dy {
			font-family: "Nunito Sans";
		}
		h3 {
			padding-left: 30px;
			padding-right: 20px;
			font-weight: 700;
		}
		label {
			padding-top: 4px;
			padding-left: 4px;
		}
		.btn-custom {
			background-color: #1877f2;
		}
		a {
			text-decoration: none;
			color: rgb(27, 149, 224);
		}
		a:hover {
			text-decoration: underline;
			color: rgb(27, 149, 224);
		}
	</style>
</head>
<body>
 <section class="navigation">
	<div class="nav-container">
		<div class="brand">
			<a href="#">Army Application</a>
		</div>
		<nav>
			<ul class="nav-list">
				<li>
					<a style="color: white;">${username}</a>
				</li>
				<li>
					<a href='<c:url value="/logout" />'>Sign out</a>
				</li>
			</ul>
		</nav>
	</div>
 </section>
	<sec:authorize access="hasRole('ADMIN')">
		<h1>Connected as ADMIN</h1>
		<h3>Register</h3>
		<form action="register" method="post" style="text-align: center">
			<label>Username</label><br>
			<input type="text" name="mUsername" required><br><br>
			<label>Password</label><br>
			<input type="password" name="mPassword" required><br><br>
			<label>Role (admin, officer, worker)</label><br>
			<input type="text" name="role" required><br><br>
			</div>
			<input type="submit" class="btn btn-custom" value="Register">
		</form><br>
		<h3>Users</h3><br>
		<table style="margin-left: 45%">
		<tr>
			<th>Username</th>
			<th>Role</th>
		</tr>
		<c:forEach items="${users}" var="user">
			<tr>
				<td>${user.username}</td>
				<td>${user.authority}</td>
			</tr>
		</c:forEach>
		</table><br><br>
		<h3>Delete</h3>
		<form action="delete" method="post" style="text-align: center">
			<label>Username</label><br>
			<input type="text" name="deleteUsername" required><br><br>
			<input type="submit" class="btn btn-custom" value="Delete">
		</form>
	</sec:authorize>
	<sec:authorize access="hasRole('OFFICER')">
		<h1>Connected as Army Officer</h1><br>
		<h2>Validated Applications</h2><br>
		<c:forEach items="${validatedApplications}" var="validatedApplications">
			<ul>
                <li>${validatedApplications.toString()}</li>
			</ul>
		</c:forEach>
		<br>
		<h2>Final Applications</h2><br>
		<c:forEach items="${finalApplications}" var="finalApplications">
			<ul>
				<li>${finalApplications.toString()}</li>
			</ul>
		</c:forEach>
		<h3>Approve a validated Application</h3>
		<form action="approveValidated" method="post">
			<label for="fcitizenUserName">Citizen Username:</label><br>
			<input id="fcitizenUserName" type="text" name="fcitizenUserName"><br>
            <label for="fcitizenFirstName">Citizen First Name:</label><br>
		    <input id="fcitizenFirstName" type="text" name="fcitizenFirstName"><br>
		    <label for="fcitizenLastName">Citizen Last Name:</label><br>
		    <input id="fcitizenLastName" type="text" name="fcitizenLastName"><br>
			<label for="fcitizenEmail">Citizen Email:</label><br>
			<input id="fcitizenEmail" type="text" name="fcitizenEmail"><br>
			<label for="fcitizenAmka">Citizen Amka:</label><br>
			<input id="fcitizenAmka" type="text" name="fcitizenAmka"><br>
			<label for="fcitizenStratNumber">Citizen Stratological Number:</label><br>
			<input id="fcitizenStratNumber" type="text" name="fcitizenStratNumber"><br>
			<label for="age">Citizen Age of Army presentation:</label><br>
			<input id="age" type="text" name="age"><br>
		    <input type="submit" value="validate" class="btn-custom btn">
		</form>
	</sec:authorize>
	<sec:authorize access="hasRole('WORKER')">
		<h1>Connected as Office Worker</h1>
		<h2>Applications</h2><br>
		<c:forEach items="${applications}" var="application">
			<ul>
				<li>${application.toString()}</li>
			</ul>
		</c:forEach>
		<h2>Validated Applications</h2><br>
		<c:forEach items="${validatedApplications}" var="validatedApplications">
			<ul>
				<li>${validatedApplications.toString()}</li>
			</ul>
		</c:forEach>
		<h3>Approve an Application</h3>
		<form action="approveApplication" method="post">
			<label for="citizenUserName">Citizen Username:</label><br>
			<input id="citizenUserName" type="text" name="citizenUserName"><br>
			<label for="citizenFirstName">Citizen First Name:</label><br>
			<input id="citizenFirstName" type="text" name="citizenFirstName"><br>
			<label for="citizenLastName">Citizen Last Name:</label><br>
			<input id="citizenLastName" type="text" name="citizenLastName"><br>
			<label for="citizenEmail">Citizen Email:</label><br>
			<input id="citizenEmail" type="text" name="citizenEmail"><br>
			<label for="citizenAmka">Citizen Amka:</label><br>
			<input id="citizenAmka" type="text" name="citizenAmka"><br>
			<label for="citizenStratNumber">Citizen Stratological Number:</label><br>
			<input id="citizenStratNumber" type="text" name="citizenStratNumber"><br>
			<label for="reason">Reason and time of delay:</label><br>
			<input id="reason" type="text" name="reason"><br>
			<input type="submit" value="validate" class="btn-custom btn">
		</form>
	</sec:authorize>
</body>
</html>