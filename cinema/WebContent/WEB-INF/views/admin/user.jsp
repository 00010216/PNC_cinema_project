<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html style="height: 100%;overflow-y: hidden;">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>plantillaSala</title>
    
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-material-design.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
</head>

<body style="height: 100%;overflow-y: hidden;">
    <div class="row h-100">
        <div class="col col-md-3" style="/*position: fixed;*/display: flex;flex-direction: column;/*align-items: center;*//*justify-content: center;*//*background-color: #795548;*/ border: 1px solid black">
            <div style="width: 100%;height: 150px;display: flex;justify-content: center;align-items: center;"><img src="resources/images/logoCine.png" style="width: 100px; heigth:100px;"></div>
            <ul class="nav nav-tabs flex-column" style="width: 100%;">
                <li class="nav-item"><a class="nav-link active" href="#">First Item</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Second Item</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Third Item</a></li>
            </ul>
        </div>
        <div class="col col-md-9" style="display: flex;flex-direction: column;justify-content: center;align-items: center;">
            <form:form action="${pageContext.request.contextPath}/admin/${actionForm}" method="POST" modelAttribute="CUser" style="padding: 8px;width: 70%;">
                <div style="display: flex;flex-direction: row;/*height: 10%;*/margin-bottom: 8px;justify-content: center;align-items: center;">
            	
	                <h3 style="flex: 10;">Registro de Usuario</h3>
	                <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/theaters'" type="button" style="flex: 2;height: 37px;">
	                	<i class="fa fa-plus"></i>
	                	Regresar	                	
	                </button>                
            	</div>        
            	<div class="row">
            		<div class="col-md-6">
            			<div class="form-group">
		                	<label for="name">Nombres</label>                		                	
		                	<form:input class="form-control" type="text" id="name"  path="firstName"/>	
		                		                
		                	<form:errors path="firstName" cssStyle="color: #E81505"/>
	                	</div>	                	
	                	
            		</div>	
            		<div class="col-md-6">
            			<div class="form-group"><label for="capacity">Apellidos</label>
		                	<form:input class="form-control" type="text" id="lastName" path="lastName"/>
		                	<form:errors path="lastName" cssStyle="color: #E81505"/>
	               		 </div>
            		</div>	
            	</div>
            	<div class="row">
            		<div class="col-md-4">
            			<div class="form-group">
		                	<label for="name">Cumpleaños</label>                		                	
		                	<form:input class="form-control" path="birthday" type="date"/>
		                	
	                	</div>	                	
	                	
            		</div>	
            		<div class="col-md-4">
            			<div class="form-group">
            				<label for="capacity">Pais</label>
            				<select class="form-control" name="country_id">
            					<c:forEach items="${countries}" var="country">
            						<option value="${country.getIdCountry()}">${country.getName()}</option>
            					</c:forEach>         
				            </select>            				
		                	
	               		 </div>
            		</div>	
            		<div class="col-md-4">
            			<div class="form-group">
            				<label for="capacity">Municipio</label>
		                	<select class="form-control" name="municipality_id">
            					<c:forEach items="${municipalities}" var="municipality">
            						<option value="${municipality.getIdMun()}">${municipality.getName()}</option>
            					</c:forEach>         
				            </select>
	               		 </div>
            		</div>
            	</div>
            	<div class="row">
            		<div class="col-md-8">
            			<div class="form-group">
		                	<label for="name">Direccion</label>                		                	
		                	<form:input class="form-control" type="text" id="name"  path="address"/>		                	
		                	<form:errors path="address" cssStyle="color: #E81505"/>
	                	</div>	                	             	
            		</div>
            		<div class="col-md-4">
            			<div class="form-group">
		                	<label for="name">Saldo</label>                		                	
		                	<input class="form-control" type="text" id="balance" value="$20" disabled />		                			               
	                	</div>	                	
            		</div>	            		
            	</div>   
            	<div class="row">
            		<div class="col-md-4">
            			<div class="form-group">
		                	<label for="name">Usuario</label>                		                	
		                	<form:input class="form-control" type="text" id="username"  path="username"/>		                	
		                	<form:errors path="username" cssStyle="color: #E81505"/>
	                	</div>	                	
	                	
            		</div>	
            		<div class="col-md-4">
            			<div class="form-group"><label for="capacity">Correo</label>
		                	<form:input class="form-control" type="mail" id="email" path="email"/>
		                	<form:errors path="email" cssStyle="color: #E81505"/>
	               		 </div>
            		</div>	
            		<div class="col-md-4">
            			<div class="form-group"><label for="capacity">Contraseña</label>
            				<form:password class="form-control" showPassword="false" path="passwd"/>		                	
		                	<form:errors path="passwd" cssStyle="color: #E81505"/>
	               		 </div>
            		</div>
            	</div>         	           	            	                
                <div class="form-group">               		                	
					<div class="form-group" style="display: flex; justify-content: center;">
						<button class="btn btn-raised btn-primary" type="submit">
							Guardar
						</button>
					</div>                										  				 					 					
				 </div>
                </div>            
            </form:form>
        </div>
    </div>
    <div></div>
    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>