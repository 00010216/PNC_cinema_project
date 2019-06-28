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
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/resources/css/dashboard.css" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Roboto&display=swap" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/jquery.datetimepicker.css"/>

</head>
<body>
	<%@include file="header.jsp" %>
	<main role="main" class="col-md-9 ml-sm-auto col-lg-10 pt-3 px-4">
    <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pb-2 mb-3 border-bottom">
            <h1 class="h2">Registros</h1>
            <div class="btn-toolbar mb-2 mb-md-0">
            <form action="${pageContext.request.contextPath}/admin/getLogsFiltered">
              <div class="input-group input-daterange">
    				<input type="text" class="form-control" name="fromDate" id="fromDate" value="2019-05-01">
    				<div class="input-group-addon">hasta</div>
    				<input type="date" class="form-control" name="toDate" value="${currentDate}" } >
    				<button class="btn btn-primary" type="submit">Consultar</button>
				</div>
			</form>
            </div>
          </div>
          <c:if test = "${ message != null }">
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
                                <th>Acción</th>
                                <th>Número de transacción</th>
                                <th>Fecha de transacción</th>                                                                
                            </tr>
                        </thead>
                        <tbody>
                        	<c:if test = "${logs.size() > 0 }">
				            	<c:forEach begin="0" end="${logs.size() - 1}" var="index"> 
	                        		<tr>
										<th><button data="${info.get(index)}" class="btn btn-raised logButton" data-toggle="modal" data-target="#logModal" style="background-color: #f44336; color:white;"><i class="far fa-eye"></i></button></th>
		                                <th><fmt:formatNumber pattern="00000000" value="${logs.get(index).getIdTicket()}" /></th>
		                                <th><fmt:formatDate type = "date" dateStyle = "short" value = "${logs.get(index).getPurchaseDate()}" /></th> 
		         					</tr>
								</c:forEach>                     		
				      		</c:if>
	                        	                                                      
                        </tbody>
                    </table>
                </div>
              	             
      </div>
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
        <div class="row">
        	<div class="col-md-12">
        		<div class="form-group">
	                 <label for="name">Pelicula</label>                		                	
	                 <input class="form-control" type="text" id="movieLog" disabled="true" />		                                     	                 
                 </div>
        	</div>
        </div>
        <div class="row">
        	<div class="col-sm-12 col-md-4">
        		<div class="form-group">
	                 <label for="name">Tiempo</label>                		                	
	                 <input class="form-control" type="text" id="scheduleLog" disabled="true"/>		                                     	                 
                 </div>
        	</div>
        	<div class="col-sm-12 col-md-4">
        		<div class="form-group">
	                 <label for="name">Saldo utilizado</label>                		                	
	                 <input class="form-control" type="text" id="balanceLog" disabled="true"/>		                                     	                 
                 </div>
        	</div>
        	<div class="col-sm-12 col-md-4">
        		<div class="form-group">
	                 <label for="name">Total</label>                		                	
	                 <input class="form-control" type="text" id="totalLog" disabled="true"/>		                                     	                 
                 </div>
        	</div>
        </div>       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>        
      </div>
    </div>
  </div>
</div>

	
   
<script src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/logsJs.js"></script>  
</body>
</html>