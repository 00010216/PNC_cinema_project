console.log("Entro aqui");
$(document).ready(function() {		
	
	setTimeout( function() {
		console.log("Este es un mensaje");
		$('.alert').alert('close');
	}, 5000);
	
	$('.logButton').click( function() {
		var logHeaderLabel = $('#logModalHeader');
		var idUser = $(this).attr('data-id');
		var username = $(this).attr('data-name');
		var value = $(this).attr('data-value');
		console.log(value);
		console.log(value == 'false');
		if( value == 'false'){					
			logHeaderLabel.html('¿Por qué desea '+ $(this).attr('data-label-status') + ' a <strong>'  + username + '</strong>?');
			$(".modal-body").css('display', 'block');
		}
		else{
			$(".modal-body").css('display', 'none');
			logHeaderLabel.html('¿Desea activar al usuario <strong>'  + username + '</strong>?');
		}
			
		
		
		$('#user-hidden').val(idUser);
		$('#status-hidden').val(value);
		$('#text-description').val("");
		
		
		
		
		$('#logModal').modal('toggle');
	});
	
	$('#submitFormButton').click( function() {
		$("#modalForm").submit();
	});
	
});