<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
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
            <div class="btn-toolbar mb-2 mb-md-0">
              <button class="btn btn-large btn-outline-secondary" onclick = "window.location.href='${pageContext.request.contextPath}/admin/userForm'">
                <span data-feather="plus-circle"></span>
                Agregar Usuario
              </button>
            </div>
          </div>
   
            <c:if test = "${message != null }">
            	<div class="alert alert-success alert-dismissible fade show" role="alert" style="width: 100%;">
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
                                <th>Usuario</th>
                                <th>Email</th>
                                <th>Cumpleaños</th>
                                <th>Saldo</th>
                                <th>Estado</th>
                                <th style="width: 100px;">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach items="${users}" var="user"> 
								<tr>
									<td><c:out value = "${user.getIdUser()}"/></td>
									<td><c:out value = "${user.getUsername()}"/></td>
									<td><c:out value = "${user.getEmail()}"/></td>
									<td><fmt:formatDate type = "date" 
         								dateStyle = "short" value = "${user.getBirthday()}" /></td>
									<td><c:out value = "${user.getBalance()}"/></td>
									<td><c:out value = "${user.getDelegateStatus() }"/></td>
                                    <td style="display: flex;justify-content: center;align-items: center; padding: .2rem;" >										
										<div class="btn-group d-flex justify-content-end mr-3 " >
							                <button class="btn btn-outline-danger " type="button" onclick="location.href='${pageContext.request.contextPath}/admin/editUserForm?user_id=${user.getIdUser()}'" >
												<span data-feather="edit">								
											</button>
											<!-- Agregar funcionalidad de activar y desactivar -->
							                <button class="btn btn-outline-danger logButton" type="button" data-label-status="desactivar"  data-id="${user.getIdUser()}" data-name="${user.getUsername()}" data-value="false" data-toggle="modal" data-target="#logModal"  ${ user.getStatus() ? "" : "disabled"}>            
												<span data-feather="lock"></span>						
											</button>
											<button class="btn btn-outline-danger  logButton" type="button" data-label-status="activar" data-label-status data-id="${user.getIdUser()}" data-name="${user.getUsername()}" data-value="true" data-toggle="modal" data-target="#logModal" ${ user.getStatus() ? "disabled" : ""}>
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
  
  <div class="modal fade" id="logModal" tabindex="-1" role="dialog" aria-labelledby="logModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="logModalHeader"></h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body"> 
      	<form id="modalForm" action="${pageContext.request.contextPath}/admin/updateStatus" method="POST">  
	         <div class="row">
	         	<div class="col-md-12">
	         		<div class="form-group">
	         			<textarea class="form-control" id="text-description" name="description" rows="3"></textarea>	         				         					         			
	         			<input id="status-hidden" type="hidden"  name="status"/>
	         			<input id="user-hidden" type="hidden"  name="user_id"/>
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
  
  <script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
  <script src="${pageContext.request.contextPath}/resources/js/userJs.js"></script>
</body>
</html>