var isEnd = false;

$(window).scroll(function() {
	var $window = $(this);
    var scrollTop = $window.scrollTop();
    var windowHeight = $window.height();
    var documentHeight = $(document).height();
   
    console.log("----------------------------------------------------------------------------");
   
    if( scrollTop + windowHeight + 30 > documentHeight ){
    	
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
	url : "${pageContext.request.contextPath}/group/groupList/" + stPage,
	dataType : "json",
	success : function(groupList) {
		
		if(groupList.list.length < 11){
			isEnd = true;
		}
		
		$.each(groupList.list, function(index, group){

		var html = '<article class="blog-item-holder"><div class="entry-content relative"><div class="group-card center-relative"><h2 class="entry-title">'
    		 + '<a href="${pageContext.request.contextPath}/group/room?group_id=' 
    		 + group.group_id 
    		 + '">'
    		 + group.group_name
    		 + '</a></h2><div class="clear"></div></div></div></article>'
		
			$("#gl").append(html);
		});
		stPage++;
		
	},
	error : function() {
		console.log("오류");
		}
	});
}
