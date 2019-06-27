<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-material-design.min.css">
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">
</head>
<body>

	<%@include file="u_header.jsp" %>
	<main role="main" class="m-4">

	      <div class="row">
	        <div class="col-md-5 order-md-1 mb-4">
			        	<div class="row">
		        <div class="col-md-4">
		          .col-md-8
		          <div class="row">
		            <div class="col-md-6">.col-md-6</div>
		            <div class="col-md-6">.col-md-6</div>
		          </div>
		        </div>
		        <div class="col-md-7">
					 
				</div>
		      </div>
			</div>
	        <div class="col-md-5 order-md-2">
	        	<h4 class="mb-3">Formulario</h4>
	        	<!-- Informacion de la reservacion -->
	          	<form >
		          <input type="hidden">
		  
		           
		           
		            <div class="row">
			        	<div class="col-md-6 mb-3">
			            	  <label for="state">Formato</label>
		                <select class="custom-select d-block w-100" id="state">
		                  <options value ="PG-13">PG-13/>
		                <select>
			        	</div>
			            <div class="col-md-6 mb-3">
			                 <label for="state">Horario</label>
		                <select class="custom-select d-block w-100" id="state">
		                  <options value ="PG-13">PG-13</>
		                <select>
			            </div>
		            </div>
		            
		            <div class="col-md-6 mb-3">
			            	<label for="fecha">Asientos</label>
			                <input type="text" class="form-control" id="fecha" >
			        	</div>
		            
		   		<hr class="mb-4">
		           	
		           	<div class="row">
			        	<div class="col-md-6 mb-3">
			            	
		              <label>Desea utilizar el saldo de su cuenta</label>
		              <div class="d-block my-2">
			              <input type = "radio"  name="status"  value="true"  checked="checked"> 
			              <label>Sí</label>                         
			              <input type = "radio" name="status" value="false">
			              <label>No</label>  
		             
		            </div>
			        	</div>
			            <div class="col-md-6 mb-3">
			            
		                <label for="precio">Saldo a utilizar</label>
		                <input type="text" class="form-control" id="precio">
		     
			            </div>
		            </div>
		           
		      <hr class="mb-4">
		      <div class="mb-3">
		               <label for="state">Precio</label>
		                <select class="custom-select d-block w-100" id="state">
		                  <options value ="PG-13">PG-13/>
		                <select>
		            </div>
		           <hr class="mb-4">
		            <button class="btn btn-primary btn-lg btn-block btn-danger" type="submit">Reservar</button>
	          </form>
	      	</div>
     
</main>
      <footer class="my-5 pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; 2019 CinemaXYZ</p>
        <ul class="list-inline">
          <li class="list-inline-item"><a style = "color: #CC3333;" href="#">Privacy</a></li>
          <li class="list-inline-item"><a style = "color: #CC3333;" href="#">Terms</a></li>
          <li class="list-inline-item"><a style = "color: #CC3333;" href="#">Support</a></li>
        </ul>
      </footer>
    </div>
<!-- Deberia ir footer -->
</body>
</html>