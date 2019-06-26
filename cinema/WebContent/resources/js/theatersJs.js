console.log("Entro");
$(document).ready(function() {
	
	$('.deleteButton').click( function() {
		var dataUrl = $(this).attr('data-url');
		$('#deleteModalButton').attr('data-url', dataUrl);
		$('.modal-body').html('¿Desea eliminar el registro #' + $(this).attr('data-id') + '?');
		$('#deleteModal').modal('toggle');
	});
	
	$('#deleteModalButton').click( function() {
		var dataUrl = $(this).attr('data-url');
		document.location.replace(dataUrl);
		$('#deleteModal').modal('toggle');
	});
	
});