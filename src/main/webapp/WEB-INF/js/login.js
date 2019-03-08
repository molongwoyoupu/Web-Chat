var LoginUser;
var Login= {
      checkLogin : function(){
            var _ticket = $.cookie("TT_TOKEN");
            if(!_ticket){
                  return ;
            }

            $.ajax({
                  url : "http://localhost:8080/SSMdemo/token/" + _ticket,
                  dataType : "json",
                  type : "GET",
                  success : function(data){
                        if(data.status == 200){
								LoginUser=data.data;
                              var username = data.data.nickName;
                              var html = username + "，欢迎！<a href=\"javascript:void()\" class=\"link-logout\"  onclick=\"logout()\">[退出]</a>";
                              $("#loginbar").html(html);
                        }

                  }

            });

      }

}

$(function(){
      // 查看是否已经登录，如果已经登录查询登录信息
      Login.checkLogin();
});

function logout(){
	var _ticket = $.cookie("TT_TOKEN");
	if(!_ticket){
		return ;
	}
	$.ajax({
		url : "http://localhost:8080/SSMdemo/logout/"+_ticket,
		dataType : "json",
		type : "GET",
		success : function(data){
			if(data.status == 200){
				location="http://localhost:8080/SSMdemo/index";
			}
		}
	});
	
}