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

<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
</head>
<body>
	<%@include file="header.jsp" %>
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">Usuarios</h1>
          </div>
    <div class="container">
      <div class="row">
        <div class="col-md-0 order-md-2 mb-4">
        
        </div>
        <div class="col-md-12 order-md-1" style="display:flex; justify-content: center; align-items: center; display: flex; justify-items: center; align-items: center; flex-direction: column;">
            <div style="width: 90%;display: flex;flex-direction: row;/*height: 10%;*/margin-bottom: 8px;justify-content: center;align-items: center;">
            	
                <h1 style="flex: 10;">Salas</h1>
                <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/admin/create-theater'" type="button" style="flex: 2;height: 37px;">
                	<i class="fa fa-plus"></i>
                	Registrar Sala
                </button>                
            </div>
            <c:if test = "${message != null }">
            	<div class="alert alert-success alert-dismissible fade show" role="alert" style="width: 90%;">
				  ${message}
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>                     		
      		</c:if>           
            <div style="width: 90%;/*height: 100px;*/">
                <div class="table-responsive" style="height: 450px;overflow-y: scroll;padding-right: 20px;">
                    <table class="table" style="table-layout: fixed;/*margin-right: 28px;*/">
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>Descripcion</th>
                                <th>Asientos</th>
                                <th>Estado</th>
                                <th style="width: 100px;">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach items="${theaters}" var="theater"> 
								<tr>
									<td><c:out value = "${theater.getIdTheater()}"/></td>
									<td><c:out value = "${theater.getName()}"/></td>
									<td><c:out value = "${theater.getDescription()}"/></td>
									<td><c:out value = "${theater.getCapacity()}"/></td>
									<td><c:out value = "${theater.getDelegateStatus()}"/></td>			
									<td style="display: flex;justify-content: center;align-items: center;">
										<button class="btn" type="button" onclick="location.href='${pageContext.request.contextPath}/admin/edit-theater?id=${theater.getIdTheater()}'" style="/*flex: 1;*/margin-right: 8px;">
											<i class="fa fa-edit" style="/*margin-right: 8px;*/"></i>										
										</button>
										<button class="btn btn-primary deleteButton" type="button" data-id="${theater.getIdTheater()}" data-toggle="modal" data-target="#deleteModal" data-url="${pageContext.request.contextPath}/admin/delete-theater-element?id=${theater.getIdTheater()}" 
                                        	style="/*flex: 1;*/">
                                        	<i class="fa fa-trash"></i>
                                        </button>
                                    </td>
								</tr>
							</c:forEach>
                                                        
                        </tbody>
                    </table>
                </div>
            </div>        	             
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
  
  <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/theatersJs.js"></script>
</body>
</html>