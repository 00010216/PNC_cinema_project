<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<!DOCTYPE html>
<html style="height: 100%;overflow-y: hidden;">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>plantillaSala</title>
    <link rel="stylesheet" href="resources/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/styles.css">
</head>

<body style="height: 100%;overflow-y: hidden;">
    <div class="row h-100">
        <div class="col col-md-3" style="/*position: fixed;*/display: flex;flex-direction: column;/*align-items: center;*//*justify-content: center;*//*background-color: #795548;*/ border: 1px solid black">
            <div style="width: 100%;height: 150px;display: flex;justify-content: center;align-items: center;"><img src="resources/images/logoCine.png" style="width: 100px; heigth:100px;"></div>
            <ul class="nav nav-tabs flex-column" style="width: 100%;">
                <li class="nav-item"><a class="nav-link active" href="#">First Item</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Second Item</a></li>
                <li class="nav-item"><a class="nav-link" href="#">Third Item</a></li>
            </ul>
        </div>
        <div class="col col-md-9" style="display: flex;flex-direction: column;justify-content: center;align-items: center;">
            
            <form style="padding: 8px;width: 70%;">
            	<p style="width: 100%;font-size: 24px;">Sala</p>
                <div class="form-group"><label for="name">Nombre</label><input class="form-control" type="text" id="name"></div>
                <div class="form-group"><label for="capacity">Descripci�n</label><input class="form-control" type="text" id="capacity"></div>
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
                <div class="form-group"><button class="btn btn-primary" type="button">Guardar</button></div>
            </form>
        </div>
    </div>
    <div></div>
    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
</body>

</html>