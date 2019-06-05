$('#calendar').datepicker({
	language : "es",
	multidate : true,
	multidateSeparator : ",",
	daysOfWeekDisabled : "0,6",
	todayHighlight : true
});

function getDays() {
	var days = [];
	$.ajax({
		url : "http://localhost:8080/days",
		type : "GET",
		success : function(response) {
			console.log(response);
			for (var i = 0; i < response.length; i++) {
				days[i] = new Date(response[i]);
			}
			$('#calendar').datepicker('setDates', days);
		},
		error : function(xhr) {
			console.log('Error');
		}
	});
	getList();
	// console.log($('#calendar').datepicker('getDates'));
}

function saveAllDays() {
	var dates = $('#calendar').datepicker('getDates');
	var days = [];
	var day = [];
	var j = 0;
	var dayNumber = 0;
	for (var i = 0; i < dates.length; i++) {
		dayNumber = getDayOfYear(dates, i);
		days[i] = dates[i].toString();
		day[j] = days[i].substring(0, 16) + $('#start').val().substring(0, 3) + $('#start').val().substring(3, 5) + days[i].substring(21) + " START_" + dayNumber;
		j++;
		day[j] = days[i].substring(0, 16) + $('#pause').val().substring(0, 3) + $('#pause').val().substring(3, 5) + days[i].substring(21) + " PAUSE_" + dayNumber;
		j++;
		day[j] = days[i].substring(0, 16) + $('#stopPause').val().substring(0, 3) + $('#stopPause').val().substring(3, 5) + days[i].substring(21) + " STOPPAUSE_" + dayNumber;
		j++;
		day[j] = days[i].substring(0, 16) + $('#end').val().substring(0, 3) + $('#end').val().substring(3, 5) + days[i].substring(21) + " END_" + dayNumber;
		j++;
	}
	console.log(day);
	$.ajax({
		url : "http://localhost:8080/days",
		type : "POST",
		contentType : "application/json; charset=utf-8",
		data : JSON.stringify(day),
		success : function(msg) {
			console.log('OK');
		},
		error : function(xhr, status, error) {
			console.log('Error 1');
		}
	});

	// console.log($('#calendar').datepicker('getDates'));
	// http://localhost:8080/h2-console
	// https://www.springboottutorial.com/spring-boot-and-h2-in-memory-database
}

function getDayOfYear(dates, i) {
	var start = new Date(dates[i].getFullYear(), 0, 0);
	var diff = (dates[i] - start) + ((start.getTimezoneOffset() - dates[i].getTimezoneOffset()) * 60 * 1000);
	var oneDay = 1000 * 60 * 60 * 24;
	var dayNumber = Math.floor(diff / oneDay);
	return dayNumber;
}

function getList() {
	var days = [];
	$.ajax({
		url : "http://localhost:8080/list",
		type : "GET",
		success : function(response) {
			console.log(response);
			var dates = response;
			
		},
		error : function(xhr) {
			console.log('Error');
		}
	});

	// console.log($('#calendar').datepicker('getDates'));
}