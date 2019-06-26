<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
    	<div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
        	<h1 class="h2">Funciones</h1>
    	</div>
	    <div class="container">
	      <div class="row">
	        <div class="col-md-4 order-md-2 mb-4">
	        
	        </div>
	        <div class="col-md-8 order-md-1">
	        	<h4 class="mb-3">Formulario</h4>
	          	<form >
		          <input type="hidden">
		  
		           <div class="mb-3">
		               <label for="state">Película</label>
		                <select class="custom-select d-block w-100" id="state">
		                  <options value ="PG-13">PG-13/>
		                <select>
		            </div>
		                        
		            <div class="mb-3">
		               <label for="state">Sala</label>
		                <select class="custom-select d-block w-100" id="state">
		                  <options value ="PG-13">PG-13</>
		                <select>
		            </div>
		            
		            <div class="row">
			        	<div class="col-md-6 mb-3">
			            	<label for="fecha">Fecha</label>
			                <input type="text" class="form-control" id="fecha" >
			        	</div>
			            <div class="col-md-6 mb-3">
			                <label for="hora">Hora</label>
			               	<input type="text" class="form-control" id="hora" >
			            </div>
		            </div>
		            
		             <div class="mb-3">
		               <label for="state">Tipo de Función</label>
		                <select class="custom-select d-block w-100" id="state">
		                  <options value ="PG-13">PG-13/>
		                <select>
		            </div>
		            
		           	<div class="col-md-3 mb-3">
		                <label for="precio">Precio</label>
		                <input type="text" class="form-control" id="precio">
		            </div>
		            
		           	<hr class="mb-4">
		           	
		            <div class="d-block my-3">
		              <label>Estatus</label>
		              <div class="d-block my-2">
			              <input type = "radio"  name="status"  value="true"  checked="checked"> 
			              <label>Activo</label>                         
			              <input type = "radio" name="status" value="false">
			              <label>Inactivo</label>  
		              </div>
		            </div>
		     
		            <hr class="mb-4">
		            <button class="btn btn-primary btn-lg btn-block btn-danger" type="submit">Guardar</button>
	          </form>
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
</body>
</html>