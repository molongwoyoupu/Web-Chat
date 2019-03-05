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
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web即时通讯</title>
<!-- Bootstrap -->
<link rel="stylesheet" type="text/css" href="css/bootstrap-3.3.7/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/font-awesome-4.7.0/css/font-awesome.min.css">
	

<style>
    .chat-container{float:left;margin-left:100px;width:800px;height:600px;margin-top:30px;box-shadow: 2px 2px 50px #ccc, -2px -2px 50px #ccc;z-index:999;}
    .friend-area{width:250px;height:600px;float:left;overflow: auto;background:rgb(207,207,207)}
    .chat-window{height:600px;width:550px;margin-left:250px;}
    .msg-list-area{height:370px;overflow: auto;padding:5px;padding-bottom:40px;}
    .msg-add-area{position:relative;width:550px;height: 170px;border:1px solid #cccccc;}
    button#btnSend{position: absolute;right:10px;bottom:10px;}
    textarea#chat{width:548px;height: 114px;padding: 5px;resize:none;border: none;font-size: 20px;}
    .friend-item{padding:10px 15px;height:60px;margin-bottom:1px;}
    .friend-item-title{padding:10px 15px;height:60px;margin-bottom:1px;}
    .friend-item:hover{background:rgb(215,225,220)}
    
    .friend-item-close{color:#cccccc;display:none;}
    .friend-item:hover .friend-item-close{display:block;}
    .friend-item-close:hover{color:red;}
    
    .friend-item.current{background:rgb(255,255,255)}
    .friend-item-avatar{width:43px;height:43px;border-radius:50%;float:left;}
    .friend-item-name{margin-left:8px;display:inline-block;vertical-align:middle;height:100%;padding-top:10px;}
    .msg-item{margin-top:15px;}
    .msg-item-friend-avatar{width:40px;height:40px;border-radius:50%;}
    .avatar-user .msg-item-friend-avatar{float:left;}
    .avatar-me .msg-item-friend-avatar{float:right;}
    .avatar-user .msg-item-right{margin-left:48px;}
    .avatar-me .msg-item-right{margin-right:48px;}
    .msg-item-right-name{font-size: 14px;color:#333;}
    .msg-item-send-time{font-size:13px;}
    .avatar-me .msg-item-send-time{text-align: right;}
    .msg-item-right-content{font-size:13px;background:rgb(209,209,209);padding:8px 15px;border-radius:5px;display:inline-block;}
    .avatar-user .msg-item-right-content{margin-right:100px;}
    .avatar-me .msg-item-right-content{margin-left:100px;}
    .avatar-me .msg-item-right-name{text-align: right;}
    .avatar-me .msg-item-right-content{text-aligin:right;background:rgb(82,172,101);color:white;text-align: right;display:inline-block;float:right;}

	.chatClose{display:none;}
	
	.chat-contact-list{float:left;margin-left:30px;width:300px;height:600px;margin-top:30px;box-shadow: 2px 2px 50px #ccc, -2px -2px 50px #ccc;z-index:999;}

	.sidebar{width:300px;background-color:#dcdcdc;height:600px;}
	.sidebar .sidebar-nav{height:478px;position:relative;width:100%;overflow-y:auto;overflow-x:hidden}
	.sidebar .nav{width:100%;list-style:none}
	.sidebar .nav-title{height:60px;text-align: center;width:100%;line-height: 60px;border-bottom: 1px solid #cccccc;display: inline-block;}
	.sidebar .nav-item{width:100%;position:relative}
	.sidebar .nav-item:hover{background:rgb(200,200,200)}
	/*分组内的联系人 头像*/
	.contact-item-avatar{width:30px;height:30px;border-radius:50%;float:left;}
	/*分组内的联系人 选择显示更多*/
	.contact-item-more{color:#ffffff;display:none;}
	.sidebar .nav-item:hover .contact-item-more{display:block;}
	.contact-item-more:hover{color:#aaaaaa;}
	
	.sidebar .nav-link{display:block;text-decoration:none;padding:16px 24px;}
	
	.sidebar .nav-dropdown.open .nav-dropdown-toggle i:last-of-type{-webkit-transform:rotate(90deg);transform:rotate(90deg)}
	.sidebar .nav-dropdown.open .nav-dropdown-items{max-height:600px!important;}
	.sidebar .nav-dropdown-items{overflow:hidden;max-height:0!important;}
	
	
	.sidebar .nav-footer{height:60px;text-align: center;width:100%;line-height: 60px;border-top: 1px solid #cccccc;display: inline-block;}
	.sidebar .nav-footer-item{float:left; width:33%;text-decoration:none;font-size: 14px;}
	.sidebar .nav-footer-item-line{float:left;width:1px;color:#aaaaaa;}

	
	/*
	 *  STYLE 7
	 */
	
	.chat-scrollbar::-webkit-scrollbar-track/*滚动条里面轨道*/
	{
		-webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3);
		background-color: #F5F5F5;
		border-radius: 10px;
	}
	
	.chat-scrollbar::-webkit-scrollbar/*滚动条整体样式*/
	{
		width: 10px;
		background-color: #F5F5F5;
	}
	
	.chat-scrollbar::-webkit-scrollbar-thumb/*滚动条里面小方块*/
	{
		border-radius: 10px;
		background-image: -webkit-gradient(linear,
										   left bottom,
										   left top,
										   color-stop(0.44, rgb(122,153,217)),
										   color-stop(0.72, rgb(73,125,189)),
										   color-stop(0.86, rgb(28,58,148)));
	}
	.dropdown:hover .dropdown-menu {
	display: block;
	margin-top: 0; /* remove the gap so it doesn't close*/
	}
</style>
</head>
<body>
	<div>
	<div class="chat-contact-list">
	<div class="main-container">
        <div class="sidebar">
        	<div class="nav-title">联系人</div>
            <nav class="sidebar-nav chat-scrollbar">
                <div class="nav">
                    <div class="nav-item">
                        <a href="index.html" class="nav-link active">
                            <span>联系人</span>
                        </a>
                    </div>
                </div>
            </nav>
            <div class="nav-footer">
				<a class="nav-footer-item"><span>创建群组</span></a>
				<span class="nav-footer-item-line">|</span>
				<a class="nav-footer-item" data-toggle="modal" data-target="#addFriendModal"><span >添加好友</span></a>
				<span class="nav-footer-item-line">|</span>
				<a class="nav-footer-item"><span >设置</span></a>
			</div>
        </div>
	
	</div>
	</div>
    <div class="chat-container chat-scrollbar chatClose">
        <div class="friend-area chat-scrollbar">
            
        </div>
        <div class="chat-window">
            <div class="friend-info" style="background:rgb(231,231,231);">
                <div class="friend-item-title">
                    <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/1706/7_170629152344_5.jpg"/>
                    <span class="friend-item-name">张一</span>
                    <div style="clear:both;"></div>
                </div>
            </div>
            <div id="msgList" class="msg-list-area  chat-scrollbar">
                
            </div>
            <div class="msg-add-area">
                <textarea id="chat" rows="5" cols="30"class=" chat-scrollbar"></textarea>
                <button id="btnSend" class="btn btn-info">发送</button>
            </div>
        </div>
    </div>
	
	<!-- 添加好友模态框 -->
  		<div class="modal fade bs-example-modal-sm" id="addFriendModal" tabindex="-1" role="dialog" aria-labelledby="mySmallModalLabel">
  			<div class="modal-dialog modal-dialog-centered  modal-lg" role="document">
  				<div class="modal-content">
  					<div class="modal-header">
  						<div class="modal-title" id="myModalLabel" style="text-align: center;">
  						添加好友
  						<button type="button" class="close" data-dismiss="modal" aria-label="Close">
          					<span aria-hidden="true">&times;</span>
        				</button>
  						</div>
  						
  					</div>
  					<div class="modal-body">
  						<form class="form-horizontal form-inline" style="padding: 12px;">
  							<div class="form-group">
  								<input type="text" class="form-control" id="inputEmail3" placeholder="账户名">  		
  								<button type="button" class="btn btn-primary" >查找</button>
  							</div>
  						</form>
  					</div>
  					<div class="modal-footer" style="text-align: center;">
  						<button type="button" class="btn btn-primary" style="width: 100%">查找</button>
						<div class="row" style="padding: 10px;">
							<div class="col-sm-3"style="">
							  <div class="card" >
							    <div class="card-body row">
							    <div >
							    <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17071840/17-1FGQ540400-L.jpg">
							      </div>
							      <div class="col-sm-2">
							      <span><a href="#" >somewhere</a><span class="card-num">(1232)</span></span><br>
							      <nobr> <span><span class="card-title">哈哈哈</span><span class="card-num">(1232)</span></span><br></nobr>
							      
							      <a href="#" class="btn btn-primary">+</a>
							      </div>
							    </div>
							  </div>
							</div>
							
							<div class="col-sm-3"style="">
							  <div class="card" >
							    <div class="card-body row">
							    <div >
							    <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17071840/17-1FGQ540400-L.jpg">
							      </div>
							      <div class="col-sm-2">
							      <span><a href="#" >somewhere</a><span class="card-num">(1232)</span></span><br>
							      <nobr> <span><span class="card-title">哈哈哈</span><span class="card-num">(1232)</span></span><br></nobr>
							      
							      <a href="#" class="btn btn-primary">+</a>
							      </div>
							    </div>
							  </div>
							</div>
							
							<div class="col-sm-3"style="">
							  <div class="card" >
							    <div class="card-body row">
							    <div >
							    <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17071840/17-1FGQ540400-L.jpg">
							      </div>
							      <div class="col-sm-2">
							      <span><a href="#" >somewhere</a><span class="card-num">(1232)</span></span><br>
							      <nobr> <span><span class="card-title">哈哈哈</span><span class="card-num">(1232)</span></span><br></nobr>
							      
							      <a href="#" class="btn btn-primary">+</a>
							      </div>
							    </div>
							  </div>
							</div>
							
							<div class="col-sm-3"style="">
							  <div class="card" >
							    <div class="card-body row">
							    <div >
							    <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17071840/17-1FGQ540400-L.jpg">
							      </div>
							      <div class="col-sm-2">
							      <span><a href="#" >somewhere</a><span class="card-num">(1232)</span></span><br>
							      <nobr> <span><span class="card-title">哈哈哈</span><span class="card-num">(1232)</span></span><br></nobr>
							      
							      <a href="#" class="btn btn-primary">+</a>
							      </div>
							    </div>
							  </div>
							</div>
						</div>
  					</div>
  				</div>
  			</div>
  		</div>
	</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  	<script src="js/jquery-3.3.1/jquery-3.3.1.min.js"></script>
  	<!-- Include all compiled plugins (below), or include individual files as needed -->
  	<script src="js/bootstrap-3.3.7/bootstrap.min.js"></script>
    <script type="text/javascript">
    $(function () {

  	    //获取好友分组;
		getFriendGroup();
		setOnClickEvent();
  	});

  	//联系人分组点击事件
    function setOnClickEvent() {
	    /**
	     * Sidebar Dropdown
	     */

	    //	$('.nav-dropdown-toggle').on('click', function (e) {
		//        e.preventDefault();
		//        $(this).parent().parent().toggleClass('open');
		//  });
	    $(document).on('click','.nav-dropdown-toggle',function(e){
	    	e.preventDefault();
        	//$(this).parent().parent().toggleClass('open');
        	//等同于
        	if($(this).parent().parent().hasClass("open")){
        		$(this).parent().parent().removeClass("open");
        	} else {
        		$(this).parent().parent().addClass("open");
        		var id=$(this).attr('id');
        		if(id&&id.length>7){
        			var groupId=$(this).attr('id').substring(7,$(this).attr('id').length);
            		//获取分组下的好友
            		getFriendItemByGroupId(groupId); 
        		}     		
        	}
    	});

	    $(document).on('click','.nav-dropdown-items .nav-item',function(e){
	    	e.preventDefault();
        	
        	//添加会话
        	var str="";
        	var imgPath=$(this).find(".contact-item-avatar").attr('src');
        	var nickName=$(this).find(".nickName").text();
        	var friendId=$(this).find(".nav-link").attr('friendId');
        	var friendAccountNum=$(this).find(".nav-link").attr('friendAccountNum');
        	
        	var i=0;
        	$(".friend-area .friend-item").each(function(){
    			if($(this).attr("friendAccountNum")==friendAccountNum){
    				i++;
    			}
    		});
        	if(i==0){
        		str+="<div class='friend-item' friendAccountNum='"+friendAccountNum+"'friendId='"+friendId+"'>";
            	str+="<img class='friend-item-avatar' src='"+imgPath+"'/>";
            	str+="<span class='friend-item-name'>"+nickName+"</span>";
            	str+="<i class='fa fa-close friend-item-close fa-2x' style='float:right;'></i>";
            	str+="<div style='clear:both;'></div>";
            	str+="</div>";
    	    	$(".chat-container").removeClass("chatClose");
            	$(".friend-area").append(str);
        	}
        	setCurrentFriendItem(imgPath,nickName,friendId,friendAccountNum);
    	});
	
	    // open sub-menu when an item is active.
	    $('ul.nav').find('a.active').parent().parent().parent().addClass('open');
	
	    /**
	     * Sidebar Toggle
	     */
	    $('.sidebar-toggle').on('click', function (e) {
	        e.preventDefault();
	        $('body').toggleClass('sidebar-hidden');
	    });
	
	    /**
	     * Mobile Sidebar Toggle
	     */
	    $('.sidebar-mobile-toggle').on('click', function () {
	        $('body').toggleClass('sidebar-mobile-show');
	    });
	    //会话列表点击事件
	    $(document).on("click",".friend-area .friend-item",function(e){
	    	e.preventDefault();
	    	var imgPath=$(this).find(".friend-item-avatar").attr('src');
        	var nickName=$(this).find(".friend-item-name").text();
        	var friendId=$(this).attr('friendId');
        	var friendAccountNum=$(this).attr('friendAccountNum');
			setCurrentFriendItem(imgPath,nickName,friendId,friendAccountNum);
		});
	  	//会话列表点击关闭事件
	    $(document).on("click",".friend-item-close",function(e){
	    	e.preventDefault();
	    	$(this).parent().remove();
	    	if($(".friend-area").find(".friend-item").length==0){
	    		$(".chat-container").addClass("chatClose");
	    	}
		});
	}

	function setCurrentFriendItem(imgPath,nickName,friendId,friendAccountNum){
		if(!imgPath){return;}
		if(!nickName){return;}
		if(!friendId){return;}
		if(!friendAccountNum){return;}
		$(".friend-area .friend-item").removeClass("current");
		$(".friend-area .friend-item").each(function(){
			if($(this).attr("friendAccountNum")==friendAccountNum){
				$(this).addClass("current");
				$(".friend-item-title").find(".friend-item-name").html(nickName);
				$(".friend-item-title").find(".friend-item-avatar").attr('src',$(this).find(".friend-item-avatar").attr('src'));
				$(".friend-item-title").attr("friendId",friendId);
				$(".friend-item-title").attr("friendAccountNum",friendAccountNum);
				getmsgList(friendId);
			}
		});
	}
	//获取分组下的好友
	function getFriendItemByGroupId(groupId) {
  		var friendItemList=[];
  		$.ajax({
  			url:"<%=basePath%>getAllFriendRelationByGroupId",
  			type:"post",
  			dataType:"json",
  			data:{
  				groupId:groupId
  			},
  			success:function(data){
  				friendItemList=data;
  				//拼接联系人
  				appendFriendGroupContactItem(groupId,friendItemList);
  			}
  		});	
	}
	function appendFriendGroupContactItem(groupId,friendItemList){
  		var str="";
		if(friendItemList&&friendItemList.length){
			str+="<div class='nav-dropdown-items'>";
			for (var i = 0; i < friendItemList.length; i++) {
				
				str+="<div class='nav-item' >";
				str+="	<div href='index.html' class='nav-link' id='groupfriend"+friendItemList[i].friendId+"'"+"friendAccountNum='"+friendItemList[i].friendAccountNum+"'"+"friendId='"+friendItemList[i].friendId+"'>";
				str+="		<img class='contact-item-avatar' src='"+friendItemList[i].friendHeadPath+"'/>";
				str+="		<span class='nickName'>"+friendItemList[i].friendNickName+"</span>";
				str+="		<span class='dropdown'>";
				str+="		<i class='fa fa-chevron-circle-down fa-2x contact-item-more dropdown-toggle ' style='float:right;' data-toggle='dropdown' data-container='body'></i>";
				str+="		<ul class='dropdown-menu'>";
				str+="		<li><a href='#'>下拉菜单1</a></li>";
				str+="		<li class='divider'></li>";
				str+="		<li><a href='#'>下拉菜单2</a></li>";
				str+="		</ul>";
				str+="		</span>";
				str+="	</div>";
				str+="</div>";
			}
			str+="</div>";
		}
		$("#contact"+groupId).parent().parent().find(".nav-dropdown-items").remove();
		$("#contact"+groupId).parent().parent().append(str);
		$('.dropdown-toggle').dropdown();
		

  	}
	
	//获取分组
  	function getFriendGroup() {
  		var friendGroupList=[];
  		$.ajax({
  			url:"<%=basePath%>getAllFriendGroupByUser",
  			type:"post",
  			dataType:"json",
  			success:function(data){
  				friendGroupList=data;
  				//拼接分组
  				appendFriendGroup(friendGroupList);
  			}
  		});	
	}
  	//拼接分组
  	function appendFriendGroup(friendGroupList){
  		var str="";
		if(friendGroupList&&friendGroupList.length){
			for (var i = 0; i < friendGroupList.length; i++) {
				str+="<div class='nav-dropdown'>";
				str+="<div class='nav-item'>";
				str+="<a href='#' class='nav-link nav-dropdown-toggle' id='contact"+friendGroupList[i].id+"'>";
				str+="    <i class='fa fa-caret-right'></i><span>"+friendGroupList[i].groupName+"</span>";
				str+="</a>";
				str+="</div>";
				
				str+="<div class='nav-dropdown-items'>";
				str+="<div class='nav-item'>";
				str+="    <a href='index.html' class='nav-link'>";
				str+="       <img class='contact-item-avatar' src='http://k2.jsqq.net/uploads/allimg/1706/7_170629152344_5.jpg'/>";
				str+="       <span >张一</span>";
				str+="   </a>";
				str+="</div>";
				str+="<div class='nav-item'>";
				str+="   <a href='index.html' class='nav-link'>";
				str+="       <img class='contact-item-avatar' src='http://k2.jsqq.net/uploads/allimg/17091443/17-1F9140920430-L.jpg'/>";
				str+="       <span >张二</span>";
				str+="    </a>";
				str+="</div>";
				str+="<div class='nav-item'>";
				str+="    <a href='index.html' class='nav-link'>";
				str+="        <img class='contact-item-avatar' src='http://k2.jsqq.net/uploads/allimg/17092551/17-1F925092U10-L.jpg'/>";
				str+="        <span >张三</span>";
				str+="    </a>";
				str+="</div>";
                    
				str+="</div>";
				str+="</div>";
			}
		}
		$(".nav").append(str);
  	}

	//获取消息记录
	function getmsgList(friendId) {
  		var msgList=[];
  		$.ajax({
  			url:"<%=basePath%>getChatMsgList",
  			type:"post",
  			dataType:"json",
  			data:{
  				page:1,
  				rows:10,
  				fromUserId:1,
  				toUserId:friendId
  			},
  			success:function(data){
  				msgList=data;
  				//拼接消息
  				appendMsgItem(msgList,friendId);
  			}
  		});	
	}
	
	//拼接消息
  	function appendMsgItem(msgList,friendId){
  		var str="";
  		var me="1";
		if(msgList&&msgList.length){
			for (var i = 0; i < msgList.length; i++) {
				if(me==msgList[i].fromUserId){
					str+="   <div class='msg-item avatar-me'>";
					str+="      <img class='msg-item-friend-avatar' src='http://k2.jsqq.net/uploads/allimg/17071840/17-1FGQ540400-L.jpg'>";
					str+="      <div class='msg-item-right'> ";
					str+="          <div class='msg-item-right-name'>lionel</div>";
					str+="          <div class='msg-item-send-time'>"+msgList[i].createTime+"</div>";
					str+="          <div class='msg-item-right-content'>"+msgList[i].msgText+"</div>";
					str+="        <div style='clear:both;'></div>";
					str+="      </div>";
					str+="  </div>";
				}else if(friendId==msgList[i].fromUserId){
					str+="	<div class='msg-item avatar-user'>";
					str+="    <img class='msg-item-friend-avatar' src='"+$(".friend-item-title").find(".friend-item-avatar").attr('src')+"'>";
					str+="    <div class='msg-item-right'> ";
					str+="        <div class='msg-item-right-name'>"+$(".friend-item-title").find(".friend-item-name").text()+"</div>";
					str+="        <div class='msg-item-send-time'>"+msgList[i].createTime+"</div>";
					str+="        <div class='msg-item-right-content' >"+msgList[i].msgText+"</div>";
					str+="        <div style='clear:both;'></div>";
					str+="     </div>";
					str+=" </div>";
				}
				
			}
		}
		$("#msgList").empty().append(str);
		//滚动条滚动到底部
		//$("#msgList").scrollTop($("#msgList")[0].scrollHeight);
		$("#msgList").animate({scrollTop:$("#msgList")[0].scrollHeight}, 800);
  	}

    </script>
</body>
</html>