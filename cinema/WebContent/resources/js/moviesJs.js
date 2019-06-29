console.log("Entro aqui");
$(document).ready(function() {				
	
	$('.logButton').click( function() {
		var logHeaderLabel = $('#logModalHeader');
		var idUser = $(this).attr('data-id');
		var name = $(this).attr('data-name');
		var value = $(this).attr('data-value');
		console.log(value);
		console.log(value == 'false');
		
		logHeaderLabel.html('¿Desea '+ $(this).attr('data-label-status') + ' la pelicula <strong>'  + name + '</strong>?');				
							
		$('#user-hidden').val(idUser);
		$('#status-hidden').val(value);						
		
		
		$('#logModal').modal('toggle');
	});
	
	$('#submitFormButton').click( function() {
		$("#modalForm").submit();
	});
	
});