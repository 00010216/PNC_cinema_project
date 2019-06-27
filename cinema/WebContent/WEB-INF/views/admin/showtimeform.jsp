<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Función</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-material-design.min.css">
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery.datetimepicker.css"/>
</head>
<body>
	<%@include file="header.jsp" %>
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
    	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
        	<h1 class="h2">Función</h1>
    	</div>
	    <div class="container">
			<c:if test = "${not empty message}">
			<div class="row valign-wrapper">
			    <div class="col s12">
			        <div class="card-panel light-blue lighten-4">
			        <span>${message}</span>
			        </div>
			    </div>
			</div>
			</c:if>
	      <div class="row">
	        <div class="col-md-4 order-md-2 mb-4">
	        
	        </div>
	        <div class="col-md-8 order-md-1">
	        	<h4 class="mb-3">Formulario</h4>
	          	<form:form action="${pageContext.request.contextPath}/admin/saveShowtime" method="POST" modelAttribute="showtimeDTO" autocomplete="off">
		          <form:input type="hidden" path="idShowtime"/>

					<div class="form-group mb-3">
						<label for="pelicula" class="bmd-label-floating">Película</label>
						<form:select path="idmovie" class="form-control" id="pelicula"> 
						<form:options items="${movies}" itemValue="idMovie" itemLabel="title" id="idmovie" />
						</form:select>
					</div>
		            
		            <div class="form-group mb-3">
						<label for="sala" class="bmd-label-floating">Sala</label>
						<form:select path="idTheater" class="form-control" id="sala"> 
						<form:options items="${theaters}" itemValue="idTheater" itemLabel="name" id="idtheater" />
						</form:select>
					</div>
					
					<div class="form-group mb-3">
						<label for="formato" class="bmd-label-floating">Formato</label>
						<form:select path="idShowtimeFormat" class="form-control" id="formato"> 
						<form:options items="${formats}" itemValue="idStFormat" itemLabel="name" id="idtheater" />
						</form:select>
					</div>
		            
		            <div class="row">
			        	<div class="col-md-6 mb-3">
			            	<label for="fecha">Fecha</label>
			                <form:input type="text" class="form-control" path="showdate" id="fecha"/>
			        	</div>
			            <div class="col-md-6 mb-3">
			                <label for="hora">Hora</label>
			               	<form:input type="text" class="form-control" path="schedule" id="hora" />
			            </div>
		            </div>
		            
		           	<div class="col-md-3 mb-3">
		                <label for="precio">Precio</label>
		                <form:input type="text" class="form-control" path="price" id="precio"/>
		            </div>
		            
		           	<hr class="mb-4">
		           	
		            <div class="d-block my-3">
		              <label>Estatus</label>
		                    <div class="d-block my-2">
		                   		
		                         <form:radiobutton  name="status" path="status" value="true"  checked="checked"/> 
		                          <label>Activo</label>                         
		                         <form:radiobutton name="status" path="status" value="false"/>
		                          <label>Inactivo</label>   
		                    </div>
		            </div>
		     
		            <hr class="mb-4">
		            <button class="btn btn-primary btn-lg btn-block btn-danger" type="submit">Guardar</button>
	          </form:form>
	      	</div>
	      </div>
         

      <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2019 CinemaXYZ</p>
        <ul class="list-inline">
          <li class="list-inline-item"><a style = "color: #CC3333;" href="#">Privacy</a></li>
          <li class="list-inline-item"><a style = "color: #CC3333;" href="#">Terms</a></li>
          <li class="list-inline-item"><a style = "color: #CC3333;" href="#">Support</a></li>
        </ul>
      </footer>
    </div>
	<%@include file="footer.jsp" %>
	<script src="${pageContext.request.contextPath}/resources/js/jquery.datetimepicker.full.min.js"></script>
	<script>
	$("#hora").attr('readonly', 'readonly');
	$("#fecha").attr('readonly', 'readonly');
	$('#fecha').datetimepicker({
	format: 'Y-m-d',
	timepicker: false,
	minDate: 0,
	});
	
	$('#hora').datetimepicker({
		format: 'H:i',
		datepicker: false,
		step: 5
		});
	</script>
</body>
</html>