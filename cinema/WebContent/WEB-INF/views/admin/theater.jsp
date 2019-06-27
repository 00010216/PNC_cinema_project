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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
</head>
<body>
	<%@include file="header.jsp" %>
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
           <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">Salas</h1>
          </div>
    <div class="container">
      <div class="row">
        <div class="col-md-0 order-md-2 mb-4">
        
        </div>
        <div class="col-md-12 order-md-1" style="display:flex; justify-content: center; align-items: center; display: flex; justify-items: center; align-items: center">
        	 
            <form:form action="${pageContext.request.contextPath}/admin/${actionForm}" method="POST" modelAttribute="theater" style="padding: 8px;width: 100%;">
            <div style="display: flex;flex-direction: row;/*height: 10%;*/margin-bottom: 8px;justify-content: center;align-items: center;">
            
                <h3 style="flex: 10;">Registrar Sala</h3>
                <button class="btn" onclick="location.href='${pageContext.request.contextPath}/admin/theaters'" type="button" style="flex: 2;height: 37px; color: #CC3333;">
                    <i class="fa fa-plus"></i>
                    Regresar	                	
                </button>                
            </div>        
            
            
            <div class="form-group"><label for="name">Nombre</label>
                <form:input class="form-control" type="text" id="name"  path="name"/>
                <form:hidden path="createdDate"/>
                <form:hidden path="createdBy"/>
                <form:hidden path="idTheater"/>
                <form:errors path="name" cssStyle="color: #E81505"/>
            </div>
            <div class="form-group"><label for="capacity">Descripción</label>
                <form:input class="form-control" type="text" id="capacity" path="description"/>
                <form:errors path="description" cssStyle="color: #E81505"/>
            </div>
            <div>
                <div style="align-items: center; display: flex;">
                    <div class="form-group" style="flex: 1"><label for="capacity">Asientos</label>
                        <form:input class="form-control" type="number" min="1" id="capacity" path="capacity"/>
                        <form:errors path="capacity" cssStyle="color: #E81505"/>
                    </div>
                    <div style="flex: 5;
                        /* align-items: initial; */
                        justify-content: flex-end;
                        display: flex;">
                        <div class="form-check-inline">                	
                          <label class="form-check-label">
                            <form:radiobutton checked="true" path="status" value="true" class="form-check-input"/> Disponible 
                          </label>
                        </div>
                        <div class="form-check-inline">
                          <label class="form-check-label">
                            <form:radiobutton path="status" value="false" class="form-check-input"/> No disponible
                          </label>
                        </div>
                    </div>
                </div>                		                	
                <div class="form-group" style="display: flex; justify-content: center;">
                    <button class="btn btn-raised btn-danger" type="submit">
                        Guardar
                    </button>
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