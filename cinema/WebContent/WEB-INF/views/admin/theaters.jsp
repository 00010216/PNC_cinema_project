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
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">


</head>
<body>
	<%@include file="header.jsp" %>
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">Salas</h1>
            <div class="btn-toolbar mb-2 mb-md-0">
              <button class="btn btn-large btn-outline-secondary" onclick = "window.location.href='${pageContext.request.contextPath}/admin/create-theater'">
                <span data-feather="plus-circle"></span>
                Agregar sala
              </button>
            </div>
          </div>
          
          <c:if test = "${message != null }">
            	<div class="alert alert-success alert-dismissible fade show" role="alert" style="width: 90%;">
				  ${message}
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>                     		
      		</c:if> 
      		
        
           
                      
                <div class="table-responsive-sm" style="height: 450px;overflow-y: scroll;padding-right: 20px;">
                    <table class="table" >
                        <thead>
                            <tr>
                                <th>Codigo</th>
                                <th>Nombre</th>
                                <th>Descripción</th>
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
									<td style="display: flex;justify-content: center;align-items: center; padding: .2rem;" >
										
										<div class="btn-group d-flex justify-content-end mr-3 " >
							                <button class="btn btn-outline-danger " type="button" onclick="location.href='${pageContext.request.contextPath}/admin/edit-theater?id=${theater.getIdTheater()}'" >
												<span data-feather="edit">								
											</button>
											<!-- Agregar funcionalidad de activar y desactivar -->
							                <button class="btn btn-outline-danger " type="button" onclick="" >
												<span data-feather="lock"></span>						
											</button>
											<button class="btn btn-outline-danger  " type="button" onclick="" >
												<span data-feather="unlock"></span>						
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
  <%@include file="footer.jsp" %>
  
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/theatersJs.js"></script>
</body>
</html>