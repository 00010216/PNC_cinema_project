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
	    <%@include file="header.jsp" %>
	 
	 	<!-- Contenido de la pagina -->
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">Películas</h1>
            <div class="btn-toolbar mb-2 mb-md-0">
              <div class="btn-group mr-2">
                <button class="btn btn-sm btn-outline-secondary">Share</button>
                <button class="btn btn-sm btn-outline-secondary">Export</button>
              </div>
              <button class="btn btn-sm btn-outline-secondary dropdown-toggle">
                <span data-feather="calendar"></span>
                This week
              </button>
            </div>
          </div>
		
		<c:forEach items="${image}" var="image">
  			<div class = "d-flex justify-content-center">
  			 <div class="card flex-md-row mb-4 box-shadow h-md-250" style = "width: 800px;">
  			  <img class="img-fluid card-img-right flex-auto d-none d-md-block" style="height: 18rem;width: 15rem;" src="${image}" alt="Card image cap">
            <div class="card-body d-flex flex-column align-items-start">
              <h3 class="mb-0">
                <p class="text-dark">${image.title}</p>
              </h3>
              <p class="h6 mb-auto">${image.synopsis}</p>
              <div class="btn-group d-flex justify-content-end " style="height: 40px;padding-top: 8px;">
		                 <button type="button" class="btn btn-danger bmd-btn-fab bmd-btn-fab-sm">
		 					<span data-feather="eye"></span>
						</button>
		                <button type = "button" class="btn btn-danger bmd-btn-fab bmd-btn-fab-sm">
		                	<span data-feather="edit">
		                </button>
		                <button type="button" class="btn btn-danger bmd-btn-fab bmd-btn-fab-sm">
		 					<span data-feather="trash-2"></span>
						</button>
              		</div>
            </div>
          </div>
          </div>
  		</c:forEach>
  	

    <%@include file="footer.jsp" %>
</body>
</html>