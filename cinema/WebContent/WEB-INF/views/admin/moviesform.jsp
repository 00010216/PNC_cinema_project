<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">Películas</h1>
          </div>
    <div class="container">
      <div class="row">
        <div class="col-md-4 order-md-2 mb-4">
        
        </div>
        <div class="col-md-8 order-md-1">
        	 <h4 class="mb-3">Formulario</h4>
          <form:form  action = "${pageContext.request.contextPath}/admin/movie/save" method = "POST" modelAttribute = "movie">
          <form:input type="hidden" path="idMovie" />
            <div class="mb-3">
              <label for="titulo">Título </label>
              <form:input type="text" class="form-control" id="titulo" path = "title"/>
            </div>

           <div class="mb-3">
              <label for="sinopsis">Sinopsis </label>
              <form:input type="text" class="form-control" id="sinopsis" path = "synopsis"/>
            </div>
            
            <div class="mb-3">
              <label for="poster">Enlace del poster </label>
              <form:input type="text" class="form-control" id="poster" path = "posterLink"/>
            </div>

            <div class="mb-3">
              <label for="trailer">Enlace de trailer </label>
              <form:input type="text" class="form-control" id="trailer" path ="trailerLink"/>
            </div>
            
            <div class="row">
                  <div class="col-md-4 mb-3">
                <label for="state">Clasificación</label>
                <form:select class="custom-select d-block w-100" id="state" path = "rating">
                  <option value ="PG-13">PG-13</option>
                  <option value="PG">PG</option>
                  <option value="R">R</option>
                  <option value = "NC-17">NC-17</option>
                </form:select>
              </div>
             <div class="col-md-4 mb-3">
                <label for="state">Género</label>
                <form:select class="custom-select d-block w-100" id="state" path = "genres">
                  <option value ="terror">Terror</option>
                  <option value="comedia">Comedia</option>
                  <option value="animada">Animada</option>
                  <option value="romance">Romance</option>
                  <option value = "accion">Acción</option>
                  <option value = "fantasia">Fantasía</option>
                  <option value = "cienciaf">Ciencia Ficción</option>
                </form:select>
              </div>
              <div class="col-md-3 mb-3">
                <label for="duracion">Duración</label>
                <form:input type="text" class="form-control" id="duracion" placeholder="en minutos" path = "runtime"/>
              </div>
            </div>
            <hr class="mb-4">
             <div class="mb-3">
              <label for="director">Director</label>
              <form:input type="text" class="form-control" id="director" path = "director"/>
            </div>
            
            <hr class="mb-4">
                         <div class="d-block my-3">
              <label>Estatus</label>
                    <div class="d-block my-2">
                   		
                         <form:radiobutton  name="status" path="status" value="true"/> 
                          <label>Activo</label>                         
                         <form:radiobutton name="status" path="status" value="false"/>
                          <label>Inactivo</label>   
                    </div>
            </div>
            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block btn-danger" type="submit">Guardar</button>
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