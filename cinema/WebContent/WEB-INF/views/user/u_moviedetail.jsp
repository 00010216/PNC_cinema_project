<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
<%@include file="u_header.jsp" %>
	<div class = "m-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">Películas</h1>
          </div>
    <div class = "container mt-4 ml-5">      
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
        <div class="col-md-7 d-flex justify-content-center">
        <iframe width="560" height="315" src="${movie.trailerLink}" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
        </div>
      </div>
      </div>
      
      <!-- Tabla de funciones  por pelicula-->
      <!-- Debe mostrar solo activas -->
      <div class = "container mt-4 mh-5">
		<div class = "table-responsive-sm" style="height: 450px;overflow-y: scroll;padding-right: 20px;">
		   <table class="table" >
                        <thead>
                            <tr>
                                <th>Día</th>
                                <th>Hora</th>
                                <th>Formato</th>
                                <th style="width: 150px;"></th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach items="${movie.showtimes}" var="st"> 
								<tr>
									<td><fmt:formatDate value="${st.showdate}" pattern="dd-MM-yyyy"/></td>
									<td><fmt:formatDate value="${st.schedule}" pattern="HH:mm"/></td>
									<td>${st.showtimeFormat.name}</td>
                                   	<td>
										<div class="btn-toolbar mb-2 mb-md-0">
							                <button class="btn btn-large btn-raised btn-danger " type="button" onclick="window.location.href='${pageContext.request.contextPath}/user/movie/reservation/${movie.idMovie}'" >
												<span data-feather="bookmark"></span> 
												Reservar			
											</button>
              							</div>
                                    </td>
								</tr>
							</c:forEach>
                                                        
                        </tbody>
                    </table>
                </div>
                </div>
     </div>
      <%@include file="u_footer.jsp" %>
</body>
</html>