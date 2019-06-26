<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	 
	 	<!-- Contenido de la pagina -->
        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">Funciones</h1>
            <div class="btn-toolbar mb-2 mb-md-0">
              <button class="btn btn-large btn-outline-secondary" onclick = "window.location.href='${pageContext.request.contextPath}/admin/addShowtime'">
                <span data-feather="plus-circle"></span>
                Agregar Función
              </button>
            </div>
          </div>
               <c:if test = "${not empty message}">
            	<div class="alert alert-success alert-dismissible fade show" role="alert" style="width: 90%;">
				  ${message}
				  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
				    <span aria-hidden="true">&times;</span>
				  </button>
				</div>                     		
      		</c:if> 

		${nolist}
		<!-- Tabla de funciones -->
		   <table class="table" style="table-layout: fixed;/margin-right: 28px;/">
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
									<td>
										<div class="btn-group d-flex justify-content-end " style="height: 40px;padding-top: 8px;">
							                <button type = "button" class="btn btn-danger bmd-btn-fab bmd-btn-fab-sm" onclick = "">
							                	<span data-feather="edit">
							                </button>
							                <button type="button" class="btn btn-danger bmd-btn-fab bmd-btn-fab-sm" onclick = "">
							 					<span data-feather="trash-2"></span>
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
    </div>
  	

    <%@include file="footer.jsp" %>
</body>
</html>