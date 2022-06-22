const $time = document.getElementById("time");

const countUp = function() {
	var now = new Date();
	var year = now.getFullYear();
	var month = now.getMonth() + 1;
	var day = now.getDate();
	var hour = now.getHours();
	var minute = now.getMinutes();
	var second = now.getSeconds();
	
	if (month < 10) {
		month = "0" + month;
	}
	
	if (day < 10) {
		day = "0" + day;
	}
	
	if (hour < 10) {
		hour = "0" + hour;
	}
	
	if (minute < 10) {
		minute = "0" + minute;
	}
	
	if (second < 10) {
		second = "0" + second;
	}
	
	$time.innerHTML = year + "/" + month + "/" + day + " " + hour + ":" + minute + ":" + second;
	setTimeout(countUp, 1000);
};

countUp();