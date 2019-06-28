<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap-material-design.min.css">
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">
</head>
<body>

	<%@include file="u_header.jsp" %>
	<main role="main" class="m-4">
			<div class = "m-4">
          <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">Ticket</h1>
          </div>
	
	        
	     
<div class="card mt-4 ml-5 mr-5" style = "width:50rem;">
  <h3 class="card-header">Toy Story 4</h3>
  <div class="card-body d-flex flex-column align-items-start ml-5">
    <h5 class="card-title">Horario : 12:00  , Formato : 2D SUB</h5>
    <h5 class = "mb-3"> Sala 4</h5>
    <div class="mb-3 d-flex justify-content-center">
		      <div class="table-responsive-sm "  style="width: 600px;">
                    <table class="table">
                        <thead>
                            <tr>
                                <th style="width: 300px;"><strong>Precio unitario<strong></strong></th>
                                <th style="width: 100px;" for = "asientos" ><strong>Asientos<strong></strong></th>
                                <th style="width: 100px;"><strong>Subtotal</strong></th>
                     			<th style="width: 300px;"><strong>Saldo a utilizar</strong></th>
                     			<th style="width: 300px;"><strong>Gran total</strong></th>
                            </tr>
                        </thead>
                        <tbody>
                        	
								<tr>
									<td><strong>$5</strong><!-- jalar valor de precio por el formato elegido --></td>
									<td><strong></strong><!-- valor calculado --></td>
									<td><strong>$5</strong><!-- valor calculado --></td>
									<td><strong>$</strong><!-- valor calculado --></td>
									<td><strong>$</strong><!-- valor calculado --></td>
								</tr>
							                           
                        </tbody>
                    </table>
		            </div>
		            </div>
		            <h5> <span class="badge badge-primary">Saldo: $20  |  Saldo actual: $12</span></h5>
  					<div class="btn-toolbar mb-2 mb-md-0 mt-3">
              <button class="btn btn-large btn-outline-secondary align-items-right" onclick = "window.location.href='${pageContext.request.contextPath}/admin/user/movies'">

                FINALIZAR TRANSACCIÓN
              </button>
            </div>
  </div>
</div>
	     
    </div>
    </main>
<%@include file="u_footer.jsp" %>
</body>
</html>