<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-material-design.min.css">
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-material-design.min.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
</head>
<body>
	<%@include file="header.jsp" %>
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">Usuario</h1>
             <button class="btn btn-danger" onclick="location.href='${pageContext.request.contextPath}/admin/users'" type="button" >
                     <i class="fa fa-plus"></i>
                     Regresar	                	
                 </button>
          </div>
    <div class="container">
      <div class="row">
        <div class="col-md-0 order-md-2 mb-4">
        
        </div>
        <div class="col-md-12 order-md-1" style="display:flex; justify-content: center; align-items: center">
        	 
             <form:form action="${pageContext.request.contextPath}/admin/${actionForm}" method="POST" modelAttribute="CUser" style="padding: 8px;width: 100%;">
                   
             <div class="row">
                 <div class="col-md-6">
                     <div class="form-group">
                         <label for="name">Nombres</label>                		                	
                         <form:input class="form-control" type="text" id="name"  path="firstName" disabled="true" />	
                         <form:hidden path="idUser"/>
                         <form:errors path="firstName" cssStyle="color: #E81505"/>
                     </div>	                	
                     
                 </div>	
                 <div class="col-md-6">
                     <div class="form-group"><label for="capacity">Apellidos</label>
                         <form:input class="form-control" type="text" id="lastName" path="lastName" disabled="true"/>
                         <form:errors path="lastName" cssStyle="color: #E81505"/>
                         </div>
                 </div>	
             </div>
             <div class="row">
                 <div class="col-md-4">
                     <div class="form-group">
                         <label for="name">Cumpleaños</label>                		                	
                         <form:input class="form-control" path="birthday" type="date" disabled="true" />
                         
                     </div>	                	
                     
                 </div>	
                 <div class="col-md-4">
                     <div class="form-group">
                         <label for="capacity">Pais de origen</label>
                         <input class="form-control" value="${ countryName }" disabled="true" />                                                          			
                         
                         </div>
                 </div>	
                 <div class="col-md-4">
                     <div class="form-group">
                         <label for="capacity">Municipio</label>
                         <input class="form-control" value="${ municipalityName }" disabled="true" />
                         </div>
                 </div>
             </div>
             <div class="row">
                 <div class="col-md-8">
                     <div class="form-group">
                         <label for="name">Direccion</label>                		                	
                         <form:input class="form-control" type="text" id="name"  path="address" disabled="true" />		                	
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
                         <form:input class="form-control" type="text" id="username"  path="username" disabled="true"/>		                	
                         <form:errors path="username" cssStyle="color: #E81505"/>
                     </div>	                	                    
                 </div>	
                                                 
             </div>         	           	            	                
            
             </div>            
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
</body>
</html>