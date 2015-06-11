$(document).ready(function() {
	var interval = setInterval(function(){ recvLocation() }, 10000);

	function recvLocation() {
		var url = "/Bus/BusServlet";
		$('#getData').load(url, $(this).serialize());
	}
	
	recvLocation();
});
