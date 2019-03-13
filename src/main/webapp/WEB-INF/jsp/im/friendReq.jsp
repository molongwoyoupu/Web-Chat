<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    // 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是http://localhost:8080/MyApp/）: 
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html>
<html>
<head>
	<!-- base需要放到head中 -->
    <base href=" <%=basePath%>">
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
	<title>申请验证</title>

	<!-- Bootstrap -->
	<link rel="stylesheet" type="text/css" href="css/bootstrap-3.3.7/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="css/protal/index.css">
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<style type="text/css">
	.friendAddMsgModalFooter{
		height:550px;overflow-y:auto;overflow-x:hidden
	}
	.loading-warp{ display: table; width: 100%; margin-top: -5.8rem; }
	.loading-warp .box{ width: 100%; padding-top: 1rem; padding-bottom: 1rem;
		display: table-cell; text-align: center; vertical-align: middle; }
	.loading-warp .box img{ display: block; width: 2rem; height: 2rem; margin: 0 auto; }
	
	</style>
</head>
<body>
	
  	
  	<div class="friendAddMsgModalFooter chat-scrollbar">
		<div id="friendReqList" draggable="false">
		</div>
  	</div>


    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  	<script src="js/jquery-3.3.1/jquery-3.3.1.min.js"></script>
  	<script src="js/jquery-ui.min.js"></script>
  	<!-- Include all compiled plugins (below), or include individual files as needed -->
  	<script src="js/bootstrap-3.3.7/bootstrap.min.js"></script>
  	<script src="js/util.js"></script>
	<script src="js/cookie.js"></script>
	<script src="js/login.js"></script>
  	<script type="text/javascript">
  	var reqTimes=1;
  	var hasMore=0;
  	var LoginUser;
  	$(function () {
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
						  	    //获取好友请求;
								getFriendRequest(LoginUser);
                        }

                  }

            });
  		
  	});
  	
  	function getFriendRequest(LoginUser){
  		var msgList=[];
  		$.ajax({
  			url:"<%=basePath%>getFriendRequestListByUser",
  			type:"post",
  			dataType:"json",
  			data:{
  				page:reqTimes,
  				rows:10,
  				userId:LoginUser.id
  			},
  			success:function(data){
  				msgList=data;
  				//拼接消息
  				appendFriendRequest(msgList);
  			}
  		});	
  	}
  	
  //拼接消息
  	function appendFriendRequest(msgList){
  		var str="";
		if(msgList&&msgList.length){
			for (var i = 0; i < msgList.length; i++) {
					str+="	<div class='row' style='border-bottom:1px solid #cccccc;padding:10px;'>";
					str+="    <div class='col-sm-2' style='display: inline-block;vertical-align:middle;'> ";
					str+="    <img class='avatar-middle-1' msgId='"+msgList[i].id+"' src='"+msgList[i].headPath+"'>";
					str+="     </div>";
					str+="    <div class='col-sm-7' style='display: inline-block;vertical-align:middle;'> ";
					str+="        <div class='msg-item-right-name' style='display: inline-block;'>"+msgList[i].nickName+"</div>";
					str+="        <div class='msg-item-send-time' style='display: inline-block;color:#777777;'>"+msgList[i].createTime+"</div>";
					str+="        <div>";
					if(msgList[i].userId==LoginUser.id){
						str+="        <span >已发送验证消息</span><br>";
					}else if(msgList[i].reqToId==LoginUser.id){
						str+="        <span >申请加你为好友</span><br>";
					}
					str+="        <span style='color:#777777;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width:200px;'> 附言："+msgList[i].reqRemark+"</span>";
					str+="     	  </div>";
					str+="     </div>";
					if(msgList[i].reqResult==0){
						if(msgList[i].userId==LoginUser.id){
							str+="    <div class='col-sm-3' > ";
							str+="    等待验证";
							str+="     </div>";
							
						}else if(msgList[i].reqToId==LoginUser.id){
							str+="    <div class='col-sm-3' > ";
							str+="    <button class='btn btn-info agree'>同意</button>";
							str+="    <button class='btn btn-default refuse'>拒绝</button>";
							str+="     </div>";
							
						}
					}else if(msgList[i].reqResult==1){
						str+="    <div class='col-sm-3' > ";
						str+="    已同意";
						str+="     </div>";
					}else if(msgList[i].reqResult==2){
						str+="    <div class='col-sm-3' > ";
						str+="    已拒绝";
						str+="     </div>";
					}
					
					
					str+=" </div>";
			}
		}
		if(reqTimes==1){
			$("#friendReqList").empty();
		}
		$("#friendReqList").append(str);
		if(msgList.length<10){
			hasMore=1;
			var noMoreStr="";
			noMoreStr+="<div style='color:#777777;text-align:center;padding:10px;'>";
			noMoreStr+="暂无更多新消息</div>";
			$("#friendReqList").append(noMoreStr);
		}
  	}
  	//判断滚动条是否到底部
  	$(".friendAddMsgModalFooter").scroll(function(){
	  		var scrollTop = $(this).scrollTop();
	  		var scrollHeight = $(this)[0].scrollHeight;
	  		var windowHeight = $(this).height();
	  		if(scrollTop + windowHeight == scrollHeight){
	  			if(hasMore==0){
	  				reqTimes++;
	  				getFriendRequest(LoginUser);
	  			}
	  		}
  		});
  	
  	 /**
     * Sidebar Dropdown
     */
    $(document).on('click','.btn',function(e){
    	e.preventDefault();
    	var msgId=$(this).parent().parent().find(".avatar-middle-1").attr("msgId");
    	var that=$(this);
    	//同意
    	if($(this).hasClass("agree")){
    		updateReq(msgId,1,that);
    	}else if($(this).hasClass("refuse")){
    		updateReq(msgId,2,that);
    	}
	});
  	 function updateReq(msgId,result,that){
  		$.ajax({
  			url:"<%=basePath%>applyFriendRequest",
  			type:"post",
  			dataType:"json",
  			data:{
  				id:msgId,
  				reqResult:result
  			},
  			success:function(data){
  				if(data.status==200){
  					var str="";
  					if(result==1){
						str+="    已同意";
					}else if(result==2){
						str+="    已拒绝";
					}
  					that.parent().empty().append(str);
  				}else{
  					alert(data.msg);
  				}
  			}
  		});	
  	 }
  	</script>
  </body>
  </html>