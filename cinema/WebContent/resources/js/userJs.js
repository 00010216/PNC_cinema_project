console.log("Entro aqui");
$(document).ready(function() {		
	$('.logButton').click( function() {
		var logHeaderLabel = $('#logModalHeader');
		var idUser = $(this).attr('data-id');
		var username = $(this).attr('data-name');
		logHeaderLabel.html('¿Por qué desea desactivar a <strong>'  + username + '</strong>?');
		
		$('#logModal').modal('toggle');
	});		
	
});