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
    <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Carbon - Admin Template</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/bootstrap-3.3.7/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/manage/simple-line-icons.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/font-awesome-4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" href="<%=basePath%>css/manage/styles.css">

<style type="text/css">/* Chart.js */
@-webkit-keyframes chartjs-render-animation{
from{opacity:0.99}
to{opacity:1}
}
@keyframes chartjs-render-animation{
from{opacity:0.99}
to{opacity:1}
}
.chartjs-render-monitor{
-webkit-animation:chartjs-render-animation 0.001s;
animation:chartjs-render-animation 0.001s;
}
</style>
</head>
<body class="sidebar-fixed header-fixed">
<div class="page-wrapper">
    <div class="page-header">
        <nav class="navbar page-header">
            <a href="#" class="btn btn-link sidebar-mobile-toggle d-md-none mr-auto">
                <i class="fa fa-bars"></i>
            </a>

            <a class="navbar-brand" href="#">
                <img src="<%=basePath%>image/protal/ic_store.svg" alt="logo">
            </a>

            <a href="#" class="btn btn-link sidebar-toggle d-md-down-none">
                <i class="fa fa-bars"></i>
            </a>

            <ul class="navbar-nav ml-auto">
                <li class="nav-item d-md-down-none">
                    <a href="#">
                        <i class="fa fa-bell"></i>
                        <span class="badge badge-pill badge-danger">5</span>
                    </a>
                </li>

                <li class="nav-item d-md-down-none">
                    <a href="#">
                        <i class="fa fa-envelope-open"></i>
                        <span class="badge badge-pill badge-danger">5</span>
                    </a>
                </li>

                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <img src="http://k2.jsqq.net/uploads/allimg/17071840/17-1FGQ540400-L.jpg" class="avatar avatar-sm" alt="logo">
                        <span class="small ml-1 d-md-down-none">John Smith</span>
                    </a>

                    <div class="dropdown-menu dropdown-menu-right">
                        <div class="dropdown-header">Account</div>

                        <a href="#" class="dropdown-item">
                            <i class="fa fa-user"></i> Profile
                        </a>

                        <a href="#" class="dropdown-item">
                            <i class="fa fa-envelope"></i> Messages
                        </a>

                        <div class="dropdown-header">Settings</div>

                        <a href="#" class="dropdown-item">
                            <i class="fa fa-bell"></i> Notifications
                        </a>

                        <a href="#" class="dropdown-item">
                            <i class="fa fa-wrench"></i> Settings
                        </a>

                        <a href="#" class="dropdown-item">
                            <i class="fa fa-lock"></i> Logout
                        </a>
                    </div>
                </li>
            </ul>
        </nav>
    </div>

    <div class="main-container">
        <div class="sidebar">
            <nav class="sidebar-nav">
                <ul class="nav">
                    <li class="nav-title">Navigation</li>

                    <li class="nav-item">
                        <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/index.html" class="nav-link">
                            <i class="icon icon-speedometer"></i> Dashboard
                        </a>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-target"></i> Layouts <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/layouts-normal.html" class="nav-link">
                                    <i class="icon icon-target"></i> Normal
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/layouts-fixed-sidebar.html" class="nav-link">
                                    <i class="icon icon-target"></i> Fixed Sidebar
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/layouts-fixed-header.html" class="nav-link">
                                    <i class="icon icon-target"></i> Fixed Header
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/layouts-hidden-sidebar.html" class="nav-link">
                                    <i class="icon icon-target"></i> Hidden Sidebar
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item nav-dropdown open">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-energy"></i> UI Kits <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/alerts.html" class="nav-link">
                                    <i class="icon icon-energy"></i> Alerts
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/buttons.html" class="nav-link">
                                    <i class="icon icon-energy"></i> Buttons
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/cards.html" class="nav-link">
                                    <i class="icon icon-energy"></i> Cards
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/modals.html" class="nav-link">
                                    <i class="icon icon-energy"></i> Modals
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/tabs.html" class="nav-link">
                                    <i class="icon icon-energy"></i> Tabs
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/progress-bars.html" class="nav-link active">
                                    <i class="icon icon-energy"></i> Progress Bars
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/widgets.html" class="nav-link">
                                    <i class="icon icon-energy"></i> Widgets
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-graph"></i> Charts <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/chartjs.html" class="nav-link">
                                    <i class="icon icon-graph"></i> Chart.js
                                </a>
                            </li>
                        </ul>
                    </li>

                    <li class="nav-item">
                        <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/forms.html" class="nav-link">
                            <i class="icon icon-puzzle"></i> Forms
                        </a>
                    </li>

                    <li class="nav-item">
                        <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/tables.html" class="nav-link">
                            <i class="icon icon-grid"></i> Tables
                        </a>
                    </li>

                    <li class="nav-title">More</li>

                    <li class="nav-item nav-dropdown">
                        <a href="#" class="nav-link nav-dropdown-toggle">
                            <i class="icon icon-umbrella"></i> Pages <i class="fa fa-caret-left"></i>
                        </a>

                        <ul class="nav-dropdown-items">
                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/blank.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Blank Page
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/login.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Login
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/register.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Register
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/invoice.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Invoice
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/404.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> 404
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/500.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> 500
                                </a>
                            </li>

                            <li class="nav-item">
                                <a href="http://demo.cssmoban.com/cssthemes5/twts_173_carbon/dist/settings.html" class="nav-link">
                                    <i class="icon icon-umbrella"></i> Settings
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>

        <div class="content" >
			<div  style="width: 100%;height: 800px;overflow-y:auto;overflow-x:auto" class="chat-scrollbar">
<jsp:include page="../protal/index2.jsp" />
</div>
        </div>
    </div>
</div>
<script type="text/javascript" src="<%=basePath%>js/jquery-3.3.1/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="<%=basePath%>js/bootstrap-3.3.7/bootstrap.min.js"></script>
<script type="text/javascript">
$(function () {

	setOnClickEvent();


    //$(".content").load("../chat");

});

//点击事件
function setOnClickEvent() {
    /**
     * Sidebar Dropdown
     */
    $(document).on('click','.nav-dropdown-toggle',function(e){
    	e.preventDefault();
    	$(this).parent().toggleClass('open');
    	
	});
    
 	// open sub-menu when an item is active.
    $('ul.nav').find('a.active').parent().parent().parent().addClass('open');

    /**
     * Sidebar Toggle
     */
    $(document).on('click','.sidebar-toggle', function (e) {
        e.preventDefault();
        $('body').toggleClass('sidebar-hidden');
    });

    /**
     * Mobile Sidebar Toggle
     */
    $(document).on('click','.sidebar-mobile-toggle', function () {
        $('body').toggleClass('sidebar-mobile-show');
    });
}
</script>
</body>
</html>