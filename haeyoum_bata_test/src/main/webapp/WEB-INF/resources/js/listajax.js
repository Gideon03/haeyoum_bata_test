var isEnd = false;

$(window).scroll(function() {
	var $window = $(this);
    var scrollTop = $window.scrollTop();
    var windowHeight = $window.height();
    var documentHeight = $(document).height();
   
    console.log("----------------------------------------------------------------------------");
   
    if( scrollTop + windowHeight + 10 > documentHeight ){
    	
       	fatchList();
    	console.log("call scroll~!");
    }
});

var stPage = 1;
function fatchList() {
	if( isEnd ){
		return;
	}
	$.ajax({
		type : "GET",
		url : "home/list/" + stPage,
		dataType : "json",
		success : function(data) {
			
			if(data.list.length < 11){
				isEnd = true;
			}
			
			$.each(data.list, function(index, haeyoum){
	
			var html = '<div class="col-xs-12 col-lg-4 h-list">'
				html += '<div class="thumbnail h-list">'
				html += '<div class="caption">'
				html += '<h2>' + haeyoum.title + '</h2>'
				html += '<p>' + haeyoum.intro + '</p>'
				html += '<p><a class="btn btn-default" href="${pageContext.request.contextPath}/haeyoum/'
				html += haeyoum.room_id 
				html += '/" role="button">모임 들어가기 &raquo;</a></p>'
				html += '</div>'
				html += '</div>'
				html += '</div>'
			
				$("#listSection").append(html);
			});
			stPage++;
			
		},
		error : function() {
			console.log("오류");
			}
		});
}
