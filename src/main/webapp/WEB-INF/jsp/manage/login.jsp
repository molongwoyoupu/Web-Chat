<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<title>管理员登录</title>
<script src="<%=basePath%>js/jquery-3.3.1/jquery-3.3.1.min.js"></script>
<link rel='stylesheet' href='<%=basePath%>css/font-awesome-4.7.0/css/font-awesome.min.css'>
<link type="text/css" rel="stylesheet" href="<%=basePath%>css/manage/login.css"></link>
</head>

<body>

  <div class="login-form">
     <h1>管理登录</h1>
     <div class="form-group name log-status">
       <input type="text" class="form-control" placeholder="Username " id="username" name="username"value="admin">
       <i class="fa fa-user"></i>
     </div>
     <div class="form-group pass log-status">
       <input type="password" class="form-control" placeholder="Password" id="password"name="password" value="admin">
       <i class="fa fa-lock"></i>
     </div>
      <span class="alert">账号密码不正确</span>
      <a class="link" href="http://demo.cssmoban.com/cssthemes5/Login_Forms02/15_login-form-shake-effect/index.html#">忘记密码?</a>
     <button type="button" class="log-btn" id="login">Log in</button>
     
    
   </div>
 <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script type="text/javascript">
$("#login").click(function(){
	var username = $("[name=username]").val();
	var password = $("[name=password]").val();
	
	if(username!="admin"){
		
		$('.name').addClass('wrong-entry');
        $('.alert').fadeIn(500);
        setTimeout( "$('.alert').fadeOut(1500);",3000 );
		return ;
	}
	if(password!="admin"){
		
		$('.pass').addClass('wrong-entry');
        $('.alert').fadeIn(500);
        setTimeout( "$('.alert').fadeOut(1500);",3000 );
		return ;
	}
	window.location.href="/rest/page/index";
});

	$(document).ready(function(){

        $('.form-control').keypress(function(){
            $('.log-status').removeClass('wrong-entry');
        });

    });
</script>





</body>
</html>