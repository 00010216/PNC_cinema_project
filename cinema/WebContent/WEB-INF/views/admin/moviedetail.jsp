<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-material-design.min.css">
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">
<style>
p{
margin-bottom: 0.3rem;
}
</style>
</head>
<body>
<%@include file="header.jsp" %>
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">Películas</h1>
          </div>
    <div class = "container mt-4">      
    <div class="row">
        <div class="col-md-5">
          <div class="row">
            <div class="col-md-5"> 
            <img class="img-fluid card-img-right flex-auto d-none d-md-block" style="height: 13rem;width: 10rem;" src="${movie.posterLink}" alt="Card image cap">
            </div>
            <div class="col-md-7">
            	<div class="d-flex flex-column align-items-start">
              <h3 class="mb-0">
                <a class="text-dark">${movie.title}</a>
              </h3>
              <div class = "mt-2">
                <p class = "card-text"><span data-feather="clock"></span> ${movie.runtime} min</p>
                <p class = "card-text"><span data-feather="film"></span> ${movie.genres}</p>
                <span class = "bagde badge-danger" style ="padding: .25em .4em;">${movie.rating}</span>
       		  </div>
       		   <strong class="mb-1 mt-4 ">Director: ${movie.director}</strong>
            </div>
            </div>
          </div>
          <div class="row">
            <div class="col-md-12">
            	<div class="d-flex flex-column align-items-start">
            		 <strong class="d-inline-block mb-1 mt-2 text-danger">Sinopsis</strong>
            		  <p class="card-text mb-auto">${movie.synopsis}</p>
            	</div>
            </div>
          </div>
        </div>
        <div class="col-md-7">
        <iframe width="560" height="315" src="${movie.trailerLink}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        </div>
      </div>
      </div>
    
  <%@include file="footer.jsp" %>
</body>
</html>