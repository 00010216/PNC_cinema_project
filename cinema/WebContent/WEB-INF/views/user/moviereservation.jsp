<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reservar</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-material-design.min.css">
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">
</head>
<body>

	<%@include file="u_header.jsp" %>
	<main role="main" class="m-4">
			<div class = "m-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">${showtime.movie.title}</h1>
          </div>
	
			<c:if test = "${not empty message}">
			<div class="alert alert-dark alert-dismissible fade show" role="alert" style="width: 90%;">
				${message}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>                     		
			</c:if>
	        
	        <div class="row mt-4 d-flex justify-content-center">
	        <div class= "col-3"></div>
	        <div class = "col-6">
	        	<!-- Informacion de la reservacion -->
	          	<form  action = "${pageContext.request.contextPath}/user/ticket/save"><!--:form action = "${pageContext.request.contextPath}/admin/user/ticket/save" method = "POST" modelAttribute = "ticket"-->
		          <input type="hidden">
		          <div class = "row">
		          <div class = "col-md-4 mb-3"><h2> <span class="badge badge-danger">${showtime.showtimeFormat.name}</span></h2></div>
		         	<div class = "col-md-8 mb-3"><h2> <span class="badge badge-secondary">Dia: <fmt:formatDate value="${showtime.showdate}" pattern="dd-MM-yyyy"/>
		         	<!-- obtner formato --> Hora: <fmt:formatDate value="${showtime.schedule}" pattern="HH:mm"/> </span></h2></div>
		          </div>
		           	
		           	<div class="row mt-4 ">
			        	<div class="col-md-6 mb-3">
			            	
			              <label>Desea utilizar el saldo de su cuenta?</label>
			              <div class="d-block my-2">
					              <input type ="radio" id="radioyes"  name="usebalance"  value="true"  checked="checked" onClick="checkRadios()"> 
					              <label>Sí</label>                         
					              <input type = "radio" id="radiono" name="usebalance" value="false" onclick="checkRadios()">
					              <label>No</label>  
				            </div>
			            
			        	</div>
			            <div class="col-md-6 mb-3">
			            <input name="idshowtime" type="hidden" value="${showtime.idShowtime}">
		                <label for="precio">Saldo a utilizar</label>
		                <input id="saldo" name="balance" style="width: 100px;" type="text" class="form-control" id="precio" placeholder = "0.00">
		                
		                <br>
		                <label for="precio">Saldo disponible</label>
		                <p class="font-weight-bold"><fmt:formatNumber value="${userbalance}" type="currency"/></p>
		     
			            </div>
		            </div>
		           
		      <hr class="mb-4">
		      <div class="mb-3 d-flex justify-content-center">
		      <div class="table-responsive-sm table-bordered"  style="width: 500px;">
		      		
                    <table class="table" >
                        <thead>
                            <tr>
                                <th style="width: 100px;"><strong>Precio unitario<strong></strong></th>
                                <th style="width: 100px;" for = "asientos" >
                                	<strong>Asientos <span class="badge badge-info">Disponibles: ${showtime.avaliableSeats}</span></th>
                                <th style="width: 100px;"><strong>Subtotal</strong></th>
                     
                            </tr>
                        </thead>
                        <tbody>
								<tr>
									<td><strong>$</strong><fmt:formatNumber value="${showtime.price}" type="currency" /></td>
									<td><input type="number" class="form-control" name="seats" id="asientos"></td>
									<td><strong>$</strong><!-- valor calculado --></td>
								</tr>        
                        </tbody>
                    </table>
		            </div>
		            </div>
		           <hr class="mb-4">
		           <!-- Se redirige vista en boton por propositos de testing -->
		            <button class="btn btn-primary btn-lg btn-block btn-danger" type="submit" 
		            >Reservar</button>
	          </form> <!--:form -->
	        </div>
	         <div class= "col-3"></div>
	      	</div>
    </div>
    </main>
<!-- Deberia ir footer -->

<script type="text/javascript">
	function checkRadios()
	{
	 if(document.getElementById('radioyes').checked && !document.getElementById('radiono').checked){
	       document.getElementById('saldo').disabled=false; 
	  }else{
		  document.getElementById('saldo').disabled = true;
	  }
	}
</script>
</body>
</html>