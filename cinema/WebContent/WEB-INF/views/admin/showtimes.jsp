<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Funciones</title>
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-material-design.min.css">
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
	<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
</head>
<body style="height: 100%;overflow-y: hidden;">
<div class="row h-100">
        <div class="col col-md-3" style="/*position: fixed;*/display: flex;flex-direction: column;/*align-items: center;*//*justify-content: center;*//*background-color: #795548;*/">
            <div style="width: 100%;height: 150px;display: flex;justify-content: center;align-items: center;"><img></div>
            <ul class="nav nav-tabs flex-column" style="width: 100%;">
                <li class="nav-item"><a class="nav-link active" href="#">First Item</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Second Item</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Third Item</a></li>
            </ul>
        </div>
        <div class="col col-md-9" style="display: flex;flex-direction: column;justify-content: center;align-items: center;">
            <div style="width: 90%;display: flex;flex-direction: row;/*height: 10%;*/margin-bottom: 8px;justify-content: center;align-items: center;">
            	
                <h1 style="flex: 10;">Funciones</h1>
                <button class="btn btn-primary" onclick="location.href='${pageContext.request.contextPath}/admin/addShowtime'" type="button" style="flex: 2;height: 37px;">
                	<i class="fa fa-plus"></i>
                	Agregar función
                </button>                
            </div>
            <c:if test = "${not empty message}">
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
                                <th>Película</th>
                                <th>Día</th>
                                <th>Hora</th>
                                <th>Sala</th>
                                <th>Formato</th>
                                <th>Asientos</th>
                                <th>Precio</th>
                                <th>Estado</th>
                                <th style="width: 100px;">Acciones</th>
                            </tr>
                        </thead>
                        <tbody>
                        	<c:forEach items="${showtimes}" var="st"> 
								<tr>
									<td>${st.idShowtime}</td>
									<td>${st.movie}</td>
									<td>${st.showdate}</td>
									<td>${st.schedule}</td>
									<td>${st.theater}</td>
									<td>${st.format}</td>
									<td>${st.seats}</td>
									<td>${st.price}</td>
									<td>${st.status}</td>
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
</body>
</html>