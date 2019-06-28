console.log("Entro aqui");
$(document).ready(function() {		
	$('.logButton').click( function() {
		var logHeaderLabel = $('#logModalHeader');
		var info = $(this).attr('data').split('%');
		logHeaderLabel.html('Transacción #'  + $(this).parent().next().html());
		
		$('#movieLog').val(info[0]);
		$('#scheduleLog').val(info[1]);
		$('#balanceLog').val('$' + info[2]);
		$('#totalLog').val('$' + info[3]);
		
		$('#logModal').modal('toggle');
	});	
	
	$("#toDate").attr('readonly', 'readonly');
	$('#toDate').datetimepicker({
	format: 'Y-m-d',
	timepicker: false,
	minDate: 0,
	});;	
	
	$("#fromDate").attr('readonly', 'readonly');
	$('#fromDate').datetimepicker({
	format: 'Y-m-d',
	timepicker: false,
	minDate: 0,
	});;
	
});