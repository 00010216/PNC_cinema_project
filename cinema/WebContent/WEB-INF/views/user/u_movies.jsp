<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cartelera</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-material-design.min.css">
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/css/slider.css" rel="stylesheet">
</head>
<body>
	<%@include file="u_header.jsp" %>
			<div class = "mt-4">
          <div class=" ml-4 mr-4 d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">Cartelera disponible</h1>
          </div>
	
	${nolist}
	      <div class = "d-flex justify-content-center"style = "background-color: #DFDEDE;">
	      <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  
   <div class="slider-holder mt-4 ml-0 mr-0" style = "width: 1040px;">
	        <span id="slider-image-1"></span>
	        <span id="slider-image-2"></span>
	        <span id="slider-image-3"></span>
	        <div class="image-holder" style = "background-color: #DFDEDE;">
	             <c:forEach items="${movies}" var="movie">
			            <!-- Debe mandar id asi con el controller manda a la otra vista el objeto -->
			            <img class="slider-image img-fluid card-img-right flex-auto d-none d-md-block" style="height: 22rem;width: 16rem; padding: 1rem;" src="${movie.posterLink}" alt="Card image cap"
			            onclick = "window.location.href='${pageContext.request.contextPath}/user/movie/detail/${movie.idMovie}'">
	            </c:forEach>  
	        </div>
	        <div class="button-holder">
	            <a href="#slider-image-1" class="slider-change"></a>
	            <a href="#slider-image-2" class="slider-change"></a>
	        </div>
    	</div> 
  <a class="carousel-control-prev slider-changer" href="#slider-image-1" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next slider-changer" href="#slider-image-2" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
         
        </div>
<%@include file="u_footer.jsp" %> 

</body>
</html>