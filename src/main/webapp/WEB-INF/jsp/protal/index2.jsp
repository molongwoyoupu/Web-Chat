<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ page session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    // 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是http://localhost:8080/MyApp/）: 
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>会话聊天</title>
<link type="text/css" rel="stylesheet" href="css/protal/login.css"/>
<style type="text/css">
</style>
</head>
<body>
<!-- header start -->
<jsp:include page="../common/header.jsp" />
<!-- header end -->

<div  style="width: 100%;height: 800px;overflow-y:auto;overflow-x:auto" class="chat-scrollbar">
<jsp:include page="../im/chat.jsp" />
</div>

<!-- footer start -->
<jsp:include page="../common/footer.jsp" />
<!-- footer end -->

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-3.3.1/jquery-3.3.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="js/bootstrap-3.3.7/bootstrap.min.js"></script>
<script src="js/util.js"></script>
<script src="js/cookie.js"></script>
<script src="js/login.js"></script>
<script type="text/javascript">
function login(){
	location.href = "login";
}
</script>
</body>
</html>