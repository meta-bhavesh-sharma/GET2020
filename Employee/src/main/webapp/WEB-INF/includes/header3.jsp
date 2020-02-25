<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="/lib/bootstrap-4.1.3-dist/css/bootstrap.min.css">
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="#">Metacube</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div id="navbarNavDropdown" class="navbar-collapse collapse">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/userhome">Home</a></li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link " href="/employees">Friends</a>
				</li>
				<li class="nav-item"><a class="nav-link " href="/logout">Log
						Out</a></li>
			</ul>
		</div>
	</nav>

	<div class="container">