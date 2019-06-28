<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Funciones</title>
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
			<div class="alert alert-dark alert-dismissible fade show" role="alert" style="width: 90%;">
				${message}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>                     		
			</c:if> 

			<c:if test = "${not empty nolist}">
			<div class="alert alert-primary alert-dismissible fade show" role="alert" style="width: 90%;">
			${nolist}
			  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
			    <span aria-hidden="true">&times;</span>
			  </button>
			</div>                     		
			</c:if>
		<!-- Tabla de funciones -->
		<div class = "table-responsive-sm" style="overflow-y: scroll;padding-right: 20px;">
		   <table class="table" >
                        <thead>
                            <tr>
                                <th>Código</th>
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
									<td>${st.movie.title}</td>
									<td><fmt:formatDate value="${st.showdate}" pattern="dd-MM-yyyy"/></td>
									<td><fmt:formatDate value="${st.schedule}" pattern="HH:mm"/></td>
									<td>${st.theater.name}</td>
									<td>${st.showtimeFormat.name}</td>
									<td>${st.avaliableSeats}</td>
									<td><fmt:formatNumber value="${st.price}" type="currency" /></td>
									<td>${st.status}</td>
									<td style="display: flex;justify-content: center;align-items: center; padding: .2rem;" >
										
										<div class="btn-group d-flex justify-content-end mr-3 " >
							                <button class="btn btn-outline-danger " type="button" onclick="location.href='${pageContext.request.contextPath}/admin/showtime/edit/${st.idShowtime}'" >
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
<<<<<<< HEAD
            </div>
        </div>
    </div>
    </div>
    </main>
=======
  	</main>

>>>>>>> refs/heads/ShowtimeModule
    <%@include file="footer.jsp" %>
</body>
</html>