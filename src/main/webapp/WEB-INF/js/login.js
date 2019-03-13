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
/**
 * 传入 1997-01-01 00:00:00
 */
function dateFromat(timeStr)  
{   
    var thisDate = (new Date()).Format("yyyy-MM-dd hh:mm:ss"); 
    var thisYear=thisDate.substring(0,4);
    var myYear=timeStr.substring(0,4);
    if(myYear==thisYear){
    	var thisMonth=thisDate.substring(5,10);
        var myMonth=timeStr.substring(5,10);
        if(thisMonth==myMonth){
        	var time=timeStr.substring(11,16);
        	return time;
        }else{
        	var time=timeStr.substring(5,10);
        	return time;
        }
    }else{
    	var myYear=timeStr.substring(0,10);
    	return myYear;
    }
  
}  

Date.prototype.Format = function (fmt) { //author: meizz 
var o = {
"M+": this.getMonth() + 1, //月份 
"d+": this.getDate(), //日 
"h+": this.getHours(), //小时 
"m+": this.getMinutes(), //分 
"s+": this.getSeconds(), //秒 
"q+": Math.floor((this.getMonth() + 3) / 3), //季度 
"S": this.getMilliseconds() //毫秒 
};
if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
for (var k in o)
if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
return fmt;
}