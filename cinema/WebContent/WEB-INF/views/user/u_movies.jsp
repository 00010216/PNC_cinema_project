<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-material-design.min.css">
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">
</head>
<body>
	<%@include file="u_header.jsp" %>
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
		<div class="row">
            <div class="col-md-5"> 
            <!-- Debe mandar id asi con el controller manda a la otra vista el objeto -->
            <img class="img-fluid card-img-right flex-auto d-none d-md-block" style="height: 13rem;width: 10rem;" src="${pageContext.request.contextPath}/resources/img/mib.jpg" alt="Card image cap"
            onclick = "">
            </div>
            </div>
        </main>    
</body>
</html>