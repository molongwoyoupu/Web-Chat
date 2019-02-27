<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Web即时通讯</title>

<link rel="stylesheet" type="text/css" href="css/font-awesome-4.7.0/css/font-awesome.min.css">
	

<style>
    .chat-container{float:left;margin-left:100px;width:800px;height:600px;margin-top:30px;box-shadow: 2px 2px 50px #ccc, -2px -2px 50px #ccc;z-index:99999;}
    .friend-area{width:250px;height:600px;float:left;overflow: auto;background:rgb(207,207,207)}
    .chat-window{height:600px;width:550px;margin-left:250px;}
    .msg-list-area{height:370px;overflow: auto;padding:5px;padding-bottom:40px;}
    .msg-add-area{position:relative;width:550px;height: 105px;}
    button#btnSend{position: absolute;right:10px;bottom:10px;}
    textarea#chat{width:538px;height: 93px;padding: 5px;}
    .friend-item{padding:10px 15px;height:60px;margin-bottom:1px;}
    .friend-item-title{padding:10px 15px;height:60px;margin-bottom:1px;}
    .friend-item:hover{background:rgb(215,225,220)}
    
    .friend-item-close{color:#cccccc;display:none;}
    .friend-item:hover .friend-item-close{display:block;}
    .friend-item-close:hover{color:red;}
    
    .friend-item.current{background:rgb(255,255,255)}
    .friend-item-avatar{width:60px;height:60px;border-radius:50%;float:left;}
    .friend-item-name{margin-left:8px;display:inline-block;vertical-align:middle;height:100%;padding-top:20px;}
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


	.chat-contact-list{float:left;margin-left:30px;width:300px;height:600px;margin-top:30px;box-shadow: 2px 2px 50px #ccc, -2px -2px 50px #ccc;z-index:99999;}



.sidebar{width:300px;background-color:#dcdcdc;height:600px;}
.sidebar .sidebar-nav{height:600px;position:relative;width:100%;overflow-y:auto;overflow-x:hidden}
.sidebar .nav{width:100%;list-style:none}
.sidebar .nav-title{height:60px;text-align: center;width:100%;line-height: 60px;border-bottom: 1px solid #cccccc;display: inline-block;}
.sidebar .nav-item{width:100%;position:relative}
.sidebar .nav-item:hover{background:rgb(200,200,200)}
.contact-item-avatar{width:30px;height:30px;border-radius:50%;float:left;}
.sidebar .nav-link{display:block;text-decoration:none;padding:16px 24px;}

.sidebar .nav-dropdown.open .nav-dropdown-toggle i:last-of-type{-webkit-transform:rotate(90deg);transform:rotate(90deg)}
.sidebar .nav-dropdown.open .nav-dropdown-items{max-height:600px!important;}
.sidebar .nav-dropdown-items{overflow:hidden;max-height:0!important;}


</style>
</head>
<body>
	<div>
	<div class="chat-contact-list">
	<div class="main-container">
        <div class="sidebar">
        	<div class="nav-title">联系人</div>
            <nav class="sidebar-nav">
                <div class="nav">

                    <div class="nav-item">
                        <a href="index.html" class="nav-link active">
                            <span>联系人</span>
                        </a>
                    </div>

                    <div class=" nav-dropdown" >
                    	<div class="nav-item">
                        <a href="#" class="nav-link nav-dropdown-toggle" >
                            <i class="fa fa-caret-right"></i><span>分组一</span>
                        </a>
                        </div>

                        <div class="nav-dropdown-items">
                            <div class="nav-item">
                                <a href="index.html" class="nav-link">
                                    <img class="contact-item-avatar" src="http://k2.jsqq.net/uploads/allimg/1706/7_170629152344_5.jpg"/>
                                    <span >张一</span>
                                </a>
                            </div>
							<div class="nav-item">
                                <a href="index.html" class="nav-link">
                                    <img class="contact-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17091443/17-1F9140920430-L.jpg"/>
                                    <span >张二</span>
                                </a>
                            </div>
                            <div class="nav-item">
                                <a href="index.html" class="nav-link">
                                    <img class="contact-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17092551/17-1F925092U10-L.jpg"/>
                                    <span >张三</span>
                                </a>
                            </div>
                            <div class="nav-item">
                                <a href="index.html" class="nav-link">
                                    <img class="contact-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17090924/17-1FZ9105R40-L.jpg"/>
                                    <span >张四</span>
                                </a>
                            </div>       
                        </div>
                    </div>
                    
                    <div class=" nav-dropdown" >
                    	<div class="nav-item">
                        <a href="#" class="nav-link nav-dropdown-toggle" >
                            <i class="fa fa-caret-right"></i><span>分组二</span>
                        </a>
                        </div>

                        <div class="nav-dropdown-items">
                            <div class="nav-item">
                                <a href="index.html" class="nav-link">
                                    <img class="contact-item-avatar" src="http://k2.jsqq.net/uploads/allimg/1706/7_170629152344_5.jpg"/>
                                    <span >张一</span>
                                </a>
                            </div>
							<div class="nav-item">
                                <a href="index.html" class="nav-link">
                                    <img class="contact-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17091443/17-1F9140920430-L.jpg"/>
                                    <span >张二</span>
                                </a>
                            </div>
                            <div class="nav-item">
                                <a href="index.html" class="nav-link">
                                    <img class="contact-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17092551/17-1F925092U10-L.jpg"/>
                                    <span >张三</span>
                                </a>
                            </div>
                            <div class="nav-item">
                                <a href="index.html" class="nav-link">
                                    <img class="contact-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17090924/17-1FZ9105R40-L.jpg"/>
                                    <span >张四</span>
                                </a>
                            </div>       
                        </div>
                    </div>
                    
                    <div class=" nav-dropdown" >
                    	<div class="nav-item">
                        <a href="#" class="nav-link nav-dropdown-toggle" >
                            <i class="fa fa-caret-right"></i><span>分组三</span>
                        </a>
                        </div>

                        <div class="nav-dropdown-items">
                            <div class="nav-item">
                                <a href="index.html" class="nav-link">
                                    <img class="contact-item-avatar" src="http://k2.jsqq.net/uploads/allimg/1706/7_170629152344_5.jpg"/>
                                    <span >张一</span>
                                </a>
                            </div>
							<div class="nav-item">
                                <a href="index.html" class="nav-link">
                                    <img class="contact-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17091443/17-1F9140920430-L.jpg"/>
                                    <span >张二</span>
                                </a>
                            </div>
                            <div class="nav-item">
                                <a href="index.html" class="nav-link">
                                    <img class="contact-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17092551/17-1F925092U10-L.jpg"/>
                                    <span >张三</span>
                                </a>
                            </div>
                            <div class="nav-item">
                                <a href="index.html" class="nav-link">
                                    <img class="contact-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17090924/17-1FZ9105R40-L.jpg"/>
                                    <span >张四</span>
                                </a>
                            </div>       
                        </div>
                    </div>
                </div>
            </nav>
        </div>
	
	</div>
	</div>
    <div class="chat-container">
        <div class="friend-area">
            <div class="friend-item current">
                <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/1706/7_170629152344_5.jpg"/>
                <span class="friend-item-name">张一</span>
                <i class="fa fa-close friend-item-close" style="float:right;"></i>
                <div style="clear:both;"></div>
            </div>
            <div class="friend-item">
                <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17091443/17-1F9140920430-L.jpg"/>
                <span class="friend-item-name">张二</span>
                <i class="fa fa-close friend-item-close" style="float:right;"></i>
				<div style="clear:both;"></div>
            </div>
            <div class="friend-item">
                <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17092551/17-1F925092U10-L.jpg"/>
                <span class="friend-item-name">张三</span>
                <i class="fa fa-close friend-item-close" style="float:right;"></i>
				<div style="clear:both;"></div> 
            </div>
            <div class="friend-item">
                <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17090924/17-1FZ9105R40-L.jpg"/>
                <span class="friend-item-name">张四</span>
                <i class="fa fa-close friend-item-close" style="float:right;"></i>
				<div style="clear:both;"></div>
            </div>
            <div class="friend-item">
                <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/17071840/17-1FGQ540400-L.jpg"/>
                <span class="friend-item-name">张五</span>
                <i class="fa fa-close friend-item-close" style="float:right;"></i>
				<div style="clear:both;"></div>
            </div>
        </div>
        <div class="chat-window">
            <div class="friend-info" style="background:rgb(231,231,231);">
                <div class="friend-item-title">
                    <img class="friend-item-avatar" src="http://k2.jsqq.net/uploads/allimg/1706/7_170629152344_5.jpg"/>
                    <span class="friend-item-name">张一</span>
                    <div style="clear:both;"></div>
                </div>
            </div>
            <div id="msgList" class="msg-list-area">
                <div class="msg-item avatar-user">
                    <img class="msg-item-friend-avatar" src="https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2182925329,386985427&fm=27&gp=0.jpg">
                    <div class="msg-item-right"> 
                        <div class="msg-item-right-name">李五</div>
                        <div class="msg-item-send-time">2017-10-17 09:08:11</div>
                        <div class="msg-item-right-content" >在吗？lionel</div>
                        <div style="clear:both;"></div>
                    </div>
                </div> 
                 <div class="msg-item avatar-me">
                    <img class="msg-item-friend-avatar" src="http://k2.jsqq.net/uploads/allimg/17071840/17-1FGQ540400-L.jpg">
                    <div class="msg-item-right"> 
                        <div class="msg-item-right-name">lionel</div>
                        <div class="msg-item-send-time">2017-10-17 09:08:11</div>
                        <div class="msg-item-right-content">你大撒发撒发fddasjkfjkdsajkfkjew大撒发空间撒附近发苏打粉绝对看撒辣椒；看风景额外前锋杰我靠前峰武器；看风景委屈分看委屈乏味气氛李；委屈分看了我穷家富路科技武器兰科维奇快乐；飞机我企鹅快乐；将的撒肌肤抵抗撒；的撒看见疯狂悄然过去将开启企鹅给我企鹅个前峰武器个高考前国务卿</div>
                    </div>
                </div> 
            </div>
            <div class="msg-add-area">
                <textarea id="chat" rows="5" cols="30"></textarea>
                <button id="btnSend">发送</button>
            </div>
        </div>
    </div>
	
	</div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
  	<script src="js/jquery-3.3.1/jquery-3.3.1.min.js"></script>
  	<!-- Include all compiled plugins (below), or include individual files as needed -->
  	<script src="js/bootstrap-3.3.7/bootstrap.min.js"></script>
    <script type="text/javascript">


	$(".friend-area .friend-item").click(function(){
		setCurrentFriendItem($(this).find(".friend-item-name").text());
	});
	function setCurrentFriendItem(curFriend){
		if(!curFriend){return;}
		$(".friend-area .friend-item").removeClass("current");
		$(".friend-area .friend-item").each(function(){
			if($(this).find(".friend-item-name").text()==curFriend){
				$(this).addClass("current");
				$(".friend-item-title").find(".friend-item-name").html(curFriend);
				$(".friend-item-title").find(".friend-item-avatar").attr('src',$(this).find(".friend-item-avatar").attr('src'));
			}
		});
	}
	
	
	//联系人分组点击事件
	$(document).ready(function () {
	    /**
	     * Sidebar Dropdown
	     */
	    $('.nav-dropdown-toggle').on('click', function (e) {
	        e.preventDefault();
	        $(this).parent().parent().toggleClass('open');
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
	    $('.friend-item-close').on('click', function () {
	    	$(this).parent().remove();
	    });
	    
	});
    </script>
</body>
</html>