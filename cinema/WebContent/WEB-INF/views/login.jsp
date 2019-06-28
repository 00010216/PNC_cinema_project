<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cinema XYZ - Iniciar sesión</title>
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-material-design.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loginstyle.css">
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">
</head>
<body class="text-center">
	<form class="form-signin" action="${pageContext.request.contextPath}/perform_login" method="POST">
		<img class="mb-4 img-fluid" src="${pageContext.request.contextPath}/resources/img/logoxyz.png" alt="" width="100">
		<h1 class="h3 mb-3 font-weight-normal">Iniciar sesión</h1>
		
		<label for="inputEmail" class="sr-only">Ingrese su usuario</label>
		<input type="text" id="inputEmail" class="form-control" name="username" placeholder="Ingrese su usuario" required autofocus>
		
		<label for="inputPassword" class="sr-only">Ingrese su contraseña</label>
		<input type="password" id="inputPassword" class="form-control" name="password" placeholder="Ingrese su contraseña" required>
		
		<button class="btn btn-lg btn-outline-dark btn-block mt-4" type="submit">Ingresar</button>
		<a href = "${pageContext.request.contextPath}/admin/userForm" style = "color: #CC3333;">¿No tienes cuenta? Registrate</a>
		
       	<c:if test = "${not empty error}">
		<div class="alert alert-danger" role="alert">${error}</div>
        </c:if>
		
		<p class="mt-5 mb-3 text-muted">CinemaXYZ, 2019</p>
	</form>
</body>
</html>