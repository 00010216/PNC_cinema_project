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
              <button class="btn btn-large btn-outline-secondary" onclick = "window.location.href='${pageContext.request.contextPath}/admin/addMovie'">
                <span data-feather="plus-circle"></span>
                Agregar película
              </button>
            </div>
          </div>
               <c:if test = "${not empty message}">
            	<div class="alert alert-success alert-dismissible fade show" role="alert" style="width: 90%;">
				  ${message}
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>                     		
      		</c:if> 

		${nolist}
		<c:forEach items="${movies}" var="movie">
  			<div class = "d-flex justify-content-center">
  			 <div class="card flex-md-row mb-4 box-shadow h-md-250" style = "width: 800px;">
  			  <img class="img-fluid card-img-right flex-auto d-none d-md-block" style="height: 18rem;width: 15rem;" src="${movie.posterLink}" alt="Card image cap">
            <div class="card-body d-flex flex-column align-items-start">
              <h3 class="mb-0">
                <p class="text-dark">${movie.title}</p>
              </h3>
              <p class="h6 mb-auto">${movie.synopsis}</p>
              <div class="btn-group d-flex justify-content-end " style="height: 40px;padding-top: 8px;">
		                 <button type="button" class="btn btn-danger bmd-btn-fab bmd-btn-fab-sm">
		 					<span data-feather="eye"></span>
						</button>
		                <button type = "button" class="btn btn-danger bmd-btn-fab bmd-btn-fab-sm" onclick = "window.location.href='${pageContext.request.contextPath}/admin/movie/edit/${movie.idMovie}'">
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