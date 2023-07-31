/**
 * aside menu control을 위해 사용됨
 */

 $(document).ready(function() {
	
	$('#stateMsgBtn').click(function(e) {
		$('#stateMsgInput').attr({'class': 'mt-2'});
		$('#stateInput').attr({value: $('#stateMsg').text()});
		
	}) 
	$('#stateMsgSubmit').click(changeStateMsg);

 });
 
 function changeStateMsg() {

	 $('#stateMsgInput').attr({'class': 'mt-2 d-none'});
	 let stateInputVal = $('#stateInput').val();

	 $.ajax({
		 type: 'GET',
		 url: '/sbbs/aside/stateMsg',
		 data: {stateMsg: stateInputVal},
		 success: function(e) {
			 $('#stateMsg').html(stateInputVal);
		 }		 
	 });
}


function changeWeather() {

	let addr = $('#addr').text();
	
	$.ajax({
		type: 'GET',
		url: '/sbbs/aside/weather',
		data: {addr: addr},
		success: function(e) {
			$('#weather').html(e);
		}		 
	});
}