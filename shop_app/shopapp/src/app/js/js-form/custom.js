jQuery(document).ready(function($){
	$(".form").submit(function() {
		var str = $(this).serialize();
		$.ajax({
			type: "POST",
			url: "contact.php",
			data: str,
		});
		return false;
	});

});