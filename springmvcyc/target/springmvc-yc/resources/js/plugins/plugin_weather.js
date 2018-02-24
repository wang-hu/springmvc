(function($) {
	function weatherTool() {
		var img_home = "/img/weather/";
		return {
			getWeather : function() {
				$.post("/ajax/weather.do", weatherTemplet1, "json");
			}
		};
		function weatherTemplet1(data) {

			if (data != null) {
				var status="";
				if(data.status1!=""){
					status= data.status1 ;
				}else status += data.status2;
				
				var str = "<img class=\"weather\" SRC=\"" + img_home
						+ status + ".png\" />";
				str += "<div id=\"weatherInfo\">";
				str += data.city + "<br/>";
				str += status + "<br/>";
				
				str += data.temperature2 + "℃/" + data.temperature1 + "℃";
				str += "</div>";
			} else {
				var str = "<img class=\"weather\" SRC=\""+img_home+"undefined.png\" />";
			}
			$("#topnav").html(str);
		}
	}
	//weatherTool().getWeather();
	setTimeout(weatherTool().getWeather,1000);
})(jQuery);