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
              <strong class = "text-danger">${movie.status}</strong>
              <!-- Agregar funcionalida de activar y desactivar -->
              <div class="btn-group d-flex justify-content-end " style="height: 40px;">
		                 <button class="btn btn-outline-secondary logButton" type="button" data-label-status="desactivar"  data-id="${ movie.idMovie }" data-name="${ movie.title }" data-value="false" data-toggle="modal" data-target="#moviesModal"  ${ movie.status ? "" : "disabled"}>
											<span data-feather="lock"></span>						
										</button>
		                 <button class="btn btn-outline-secondary logButton" type="button" data-label-status="activar"  data-id="${ movie.idMovie }" data-name="${ movie.title }" data-value="true" data-toggle="modal" data-target="#moviesModal"  ${ movie.status ? "disabled" : ""} >
											<span data-feather="unlock"></span>						
										</button>
              		</div>
            </div>
             <div class="btn-group d-flex justify-content-end mr-3 " style="height: 40px;padding-top: 8px;">
		                 <button type="button" class="btn btn-danger bmd-btn-fab bmd-btn-fab-sm" onclick = "window.location.href='${pageContext.request.contextPath}/admin/movie/detail/${movie.idMovie}'">
		 					<span data-feather="eye"></span>
						</button>
		                <button type = "button" class="btn btn-danger bmd-btn-fab bmd-btn-fab-sm" onclick = "window.location.href='${pageContext.request.contextPath}/admin/movie/edit/${movie.idMovie}'">
		                	<span data-feather="edit"></span>
		                </button>
              		</div>
          </div>
          </div>
  		</c:forEach>
  		
  	
  	<div class="modal fade" id="moviesModal" tabindex="-1" role="dialog" aria-labelledby="moviesModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="logModalHeader"></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body"> 
      	<form id="modalForm" action="${pageContext.request.contextPath}/admin/movie/updateMovieStatus" method="POST">  
	         <div class="row">
	         	<div class="col-md-12">
	         		<div class="form-group">	         				         				         					         		
	         			<input id="status-hidden" type="hidden"  name="status"/>
	         			<input id="user-hidden" type="hidden"  name="movie_id"/>
	         		</div>
	         		
	         	</div>
	         </div>
         </form>
      </div>
      <div class="modal-footer">
      	<button id="submitFormButton" type="button" class="btn btn-primary" type="submit">Aceptar</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Cerrar</button>        
      </div>
    </div>
  </div>
</div>
  	

    <%@include file="footer.jsp" %>
    
    
    <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
  	<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
  	<script src="${pageContext.request.contextPath}/resources/js/moviesJs.js"></script>
</body>
</html>