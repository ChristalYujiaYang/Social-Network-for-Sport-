/*copy from http://www.lanrenzhijia.com/service/656.html*/
$(document).ready(function(){
	
	$('#friends strong').toggle(
	  function () {
		 $(this).addClass("rightejectthis").next("div").animate({width: '+210px'}, "100");
	  },
	  function () {
		$(this).removeClass("rightejectthis").next("div").animate({width: '-210px'}, "100");
	  }
	);
});