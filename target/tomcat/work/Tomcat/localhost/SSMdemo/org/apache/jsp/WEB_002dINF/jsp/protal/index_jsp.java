/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-03-05 08:43:58 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.protal;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write('\r');
      out.write('\n');

    String path = request.getContextPath();
    // 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是http://localhost:8080/MyApp/）: 
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";

      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("\t<!-- base需要放到head中 -->\r\n");
      out.write("    <base href=\" ");
      out.print(basePath);
      out.write("\">\r\n");
      out.write("\t<meta charset=\"utf-8\">\r\n");
      out.write("\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("\t<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->\r\n");
      out.write("\t<title>主页面</title>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Bootstrap -->\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-3.3.7/bootstrap.min.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/protal/index.css\">\r\n");
      out.write("  </head>\r\n");
      out.write("  <body>\r\n");
      out.write("\r\n");
      out.write("  \t<!-- 右下角按钮 -->\r\n");
      out.write("  \t<!-- <button class=\"btn btn-default btn_right_bottom\">写</button> -->\r\n");
      out.write("  \t<!-- 图片轮播 -->\r\n");
      out.write("  \t<div id=\"carousel-example-generic\" class=\"carousel slide\" data-ride=\"carousel\">\r\n");
      out.write("  \t\t<!-- Indicators -->\r\n");
      out.write("  \t\t<ol class=\"carousel-indicators\">\r\n");
      out.write("  \t\t\t<li data-target=\"#carousel-example-generic\" data-slide-to=\"0\" class=\"active\"></li>\r\n");
      out.write("  \t\t\t<li data-target=\"#carousel-example-generic\" data-slide-to=\"1\"></li>\r\n");
      out.write("  \t\t\t<li data-target=\"#carousel-example-generic\" data-slide-to=\"2\"></li>\r\n");
      out.write("  \t\t\t<li data-target=\"#carousel-example-generic\" data-slide-to=\"3\"></li>\r\n");
      out.write("  \t\t\t<li data-target=\"#carousel-example-generic\" data-slide-to=\"4\"></li>\r\n");
      out.write("  \t\t\t<li data-target=\"#carousel-example-generic\" data-slide-to=\"5\"></li>\r\n");
      out.write("  \t\t</ol>\r\n");
      out.write("\r\n");
      out.write("  \t\t<!-- Wrapper for slides -->\r\n");
      out.write("  \t\t<div class=\"carousel-inner\" role=\"listbox\">\r\n");
      out.write("  \t\t\t<div class=\"item active\">\r\n");
      out.write("  \t\t\t\t<img src=\"image/protal/ic_p4.jpg\">\r\n");
      out.write("  \t\t\t\t<p class=\"carousel-caption\">\r\n");
      out.write("  \t\t\t\t\t图片\r\n");
      out.write("  \t\t\t\t</p>\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("  \t\t\t<div class=\"item\">\r\n");
      out.write("  \t\t\t\t<img src=\"image/protal/ic_p5.jpg\">\r\n");
      out.write("  \t\t\t\t<p class=\"carousel-caption\">\r\n");
      out.write("  \t\t\t\t\t图片\r\n");
      out.write("  \t\t\t\t</p>\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("  \t\t\t<div class=\"item\">\r\n");
      out.write("  \t\t\t\t<img src=\"image/protal/ic_p6.jpg\">\r\n");
      out.write("  \t\t\t\t<p class=\"carousel-caption\">\r\n");
      out.write("  \t\t\t\t\t图片\r\n");
      out.write("  \t\t\t\t</p>\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("  \t\t\t<div class=\"item\">\r\n");
      out.write("  \t\t\t\t<img src=\"image/protal/ic_p7.jpg\">\r\n");
      out.write("  \t\t\t\t<p class=\"carousel-caption\">\r\n");
      out.write("  \t\t\t\t\t图片\r\n");
      out.write("  \t\t\t\t</p>\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("  \t\t\t<div class=\"item\">\r\n");
      out.write("  \t\t\t\t<img src=\"image/protal/ic_p8.jpg\">\r\n");
      out.write("  \t\t\t\t<p class=\"carousel-caption\">\r\n");
      out.write("  \t\t\t\t\t图片\r\n");
      out.write("  \t\t\t\t</p>\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("  \t\t\t<div class=\"item\">\r\n");
      out.write("  \t\t\t\t<img src=\"image/protal/ic_p9.jpg\">\r\n");
      out.write("  \t\t\t\t<p class=\"carousel-caption\">\r\n");
      out.write("  \t\t\t\t\t图片\r\n");
      out.write("  \t\t\t\t</p>\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("\r\n");
      out.write("  \t\t<!-- Controls -->\r\n");
      out.write("  \t\t<a class=\"left carousel-control\" href=\"#carousel-example-generic\" role=\"button\" data-slide=\"prev\">\r\n");
      out.write("  \t\t\t<span class=\"glyphicon glyphicon-chevron-left\" aria-hidden=\"true\"></span>\r\n");
      out.write("  \t\t\t<span class=\"sr-only\">Previous</span>\r\n");
      out.write("  \t\t</a>\r\n");
      out.write("  \t\t<a class=\"right carousel-control\" href=\"#carousel-example-generic\" role=\"button\" data-slide=\"next\">\r\n");
      out.write("  \t\t\t<span class=\"glyphicon glyphicon-chevron-right\" aria-hidden=\"true\"></span>\r\n");
      out.write("  \t\t\t<span class=\"sr-only\">Next</span>\r\n");
      out.write("  \t\t</a>\r\n");
      out.write("  \t</div>\r\n");
      out.write("  \t<!-- 功能模块 -->\r\n");
      out.write("  \t<div class=\"row div_function\">\r\n");
      out.write("  \t\t<div class=\"col-xs-4\">\r\n");
      out.write("  \t\t\t<div class=\"panel panel-default\" id=\"pFunc1\">\r\n");
      out.write("  \t\t\t\t<div class=\"panel-body\">\r\n");
      out.write("  \t\t\t\t\t<strong>选项一</strong>\r\n");
      out.write("  \t\t\t\t\t<img class=\"iv_function\" src=\"image/protal/ic_store.svg\">\r\n");
      out.write("  \t\t\t\t</div>\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t\t<div class=\"col-xs-4\">\r\n");
      out.write("  \t\t\t<div class=\"panel panel-default\"  id=\"pFunc2\">\r\n");
      out.write("  \t\t\t\t<div class=\"panel-body\">\r\n");
      out.write("  \t\t\t\t\t<strong>选项二</strong>\r\n");
      out.write("  \t\t\t\t\t<img class=\"iv_function\" src=\"image/protal/ic_remeber.svg\">\r\n");
      out.write("  \t\t\t\t</div>\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t\t<div class=\"col-xs-4\">\r\n");
      out.write("  \t\t\t<div class=\"panel panel-default\"  id=\"pFunc3\">\r\n");
      out.write("  \t\t\t\t<div class=\"panel-body\">\r\n");
      out.write("  \t\t\t\t\t<strong>选项三</strong>\r\n");
      out.write("  \t\t\t\t\t<img class=\"iv_function\" src=\"image/protal/ic_personal.svg\">\r\n");
      out.write("  \t\t\t\t</div>\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t</div>\r\n");
      out.write("  \t<!-- 技术日记 -->\r\n");
      out.write("  \t<div class=\"container div_divider\">\r\n");
      out.write("  \t\t<!-- 分割线 -->\r\n");
      out.write("  \t\t<hr class=\"hr_1\">SSMdemo Test !<hr class=\"hr_2\">\r\n");
      out.write("  \t\t<div class=\"row\">\r\n");
      out.write("  \t\t\t<!-- 文章列表 -->\r\n");
      out.write("  \t\t\t<div class=\"col-xs-9\">\r\n");
      out.write("  \t\t\t\t<div class=\"list-group div_article\">\r\n");
      out.write("  \t\t\t\t\t<!-- 子头栏 -->\r\n");
      out.write("  \t\t\t\t\t<a href=\"#\" class=\"list-group-item active item_article_first\">\r\n");
      out.write("  \t\t\t\t\t\t<span class=\"list-group-item-heading\">\r\n");
      out.write("  \t\t\t\t\t\t\tThe first step is as good as half over!\r\n");
      out.write("  \t\t\t\t\t\t</span>\r\n");
      out.write("  \t\t\t\t\t</a>\r\n");
      out.write("  \t\t\t\t\t<!-- 文章列表 -->\r\n");
      out.write("  \t\t\t\t\t<div class=\"list-group-item item_article\">\r\n");
      out.write("  \t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("  \t\t\t\t\t\t\t<div class=\"div_center col-xs-9\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t<div class=\"list-group-item-heading div_article_title\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t<strong>\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t\t框架设计理念\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t</strong>\r\n");
      out.write("  \t\t\t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t\t\t\t<p class=\"list-group-item-text div_article_content\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t</p>\r\n");
      out.write("  \t\t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t\t\t<!-- 右侧图片，信息 -->\r\n");
      out.write("  \t\t\t\t\t\t\t<div class=\"col-xs-3 div_right_info\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t<img class=\"iv_article img-rounded\" src=\"image/protal/ic_android1.jpg\">\r\n");
      out.write("  \t\t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t<div class=\"list-group-item item_article\">\r\n");
      out.write("  \t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("  \t\t\t\t\t\t\t<div class=\"div_center col-xs-9\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t<div class=\"list-group-item-heading div_article_title\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t<strong>\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t\t框架设计理念\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t</strong>\r\n");
      out.write("  \t\t\t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t\t\t\t<p class=\"list-group-item-text div_article_content\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t</p>\r\n");
      out.write("  \t\t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t\t\t<!-- 右侧图片，信息 -->\r\n");
      out.write("  \t\t\t\t\t\t\t<div class=\"col-xs-3 div_right_info\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t<img class=\"iv_article img-rounded\" src=\"image/protal/ic_android1.jpg\">\r\n");
      out.write("  \t\t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t<div class=\"list-group-item item_article\">\r\n");
      out.write("  \t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("  \t\t\t\t\t\t\t<div class=\"div_center col-xs-9\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t<div class=\"list-group-item-heading div_article_title\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t<strong>\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t\t框架设计理念\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t</strong>\r\n");
      out.write("  \t\t\t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t\t\t\t<p class=\"list-group-item-text div_article_content\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t</p>\r\n");
      out.write("  \t\t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t\t\t<!-- 右侧图片，信息 -->\r\n");
      out.write("  \t\t\t\t\t\t\t<div class=\"col-xs-3 div_right_info\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t<img class=\"iv_article img-rounded\" src=\"image/protal/ic_android2.jpg\">\r\n");
      out.write("  \t\t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t<div class=\"list-group-item item_article\">\r\n");
      out.write("  \t\t\t\t\t\t<div class=\"row\">\r\n");
      out.write("  \t\t\t\t\t\t\t<div class=\"div_center col-xs-9\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t<div class=\"list-group-item-heading div_article_title\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t<strong>\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t\t框架设计理念\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t</strong>\r\n");
      out.write("  \t\t\t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t\t\t\t<p class=\"list-group-item-text div_article_content\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t\t所有设计源于生活，框终点在于分层、层与层之间如何交流。\r\n");
      out.write("  \t\t\t\t\t\t\t\t</p>\r\n");
      out.write("  \t\t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t\t\t<!-- 右侧图片，信息 -->\r\n");
      out.write("  \t\t\t\t\t\t\t<div class=\"col-xs-3 div_right_info\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t<img class=\"iv_article img-rounded\" src=\"image/protal/ic_android3.jpg\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t<div>2019/12/9 12:09</div>\r\n");
      out.write("  \t\t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t</div>\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("  \t\t\t<!-- 右侧 -->\r\n");
      out.write("  \t\t\t<div class=\"col-xs-3 div_record\">\r\n");
      out.write("  \t\t\t\t<!-- 用户信息 -->\r\n");
      out.write("  \t\t\t\t<div class=\"jumbotron div_userinfo\">\r\n");
      out.write("  \t\t\t\t\t<img class=\"iv_user_head img-circle\" src=\"image/protal/ic_p5.jpg\">\r\n");
      out.write("  \t\t\t\t\t<div id=\"loginbar\" style=\"display: inline-block; margin-left: 12px;font-size: 18px;\">\r\n");
      out.write("\t\t\t\t\t您好！欢迎！\r\n");
      out.write("\t\t\t\t\t<br/>\r\n");
      out.write("\t\t\t\t\t<a href=\"javascript:login()\">[登录]</a>&nbsp;<a href=\"javascript:regist()\">[免费注册]</a>\r\n");
      out.write("\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t<!-- 随手记录 -->\r\n");
      out.write("  \t\t\t\t<div style=\"display: flex;\">\r\n");
      out.write("  \t\t\t\t\t<div style=\"flex: 1\"><hr></div>\r\n");
      out.write("  \t\t\t\t\t<div style=\"text-align: center;line-height: 48px;color: #34374C\">记录美好的心情</div>\r\n");
      out.write("  \t\t\t\t\t<div style=\"flex: 1\"><hr></div>\r\n");
      out.write("  \t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t<input type=\"text\" class=\"form-control\" placeholder=\"标题:美好的一天...\">\r\n");
      out.write("  \t\t\t\t<br>\r\n");
      out.write("  \t\t\t\t<textarea class=\"form-control\" rows=\"3\" name=textarea placeholder=\"内容:今天捡到一分钱！！！^_^\"></textarea>\r\n");
      out.write("  \t\t\t\t<br>\r\n");
      out.write("  \t\t\t\t<div class=\"div_save\">\r\n");
      out.write("  \t\t\t\t\t<button type=\"button\" class=\"btn btn-primary btn_save_record\">save</button>\r\n");
      out.write("  \t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t<hr>\r\n");
      out.write("  \t\t\t\t<!-- 小功能列表 -->\r\n");
      out.write("  \t\t\t\t<div class=\"row div_little_func\">\r\n");
      out.write("  \t\t\t\t\t<div class=\"col-xs-4\">\r\n");
      out.write("  \t\t\t\t\t\t<button class=\"btn btn-default btn-cricle btn_login\" data-toggle=\"modal\" data-target=\"#loginModal\">登</button>\r\n");
      out.write("  \t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t<div class=\"col-xs-4\">\r\n");
      out.write("  \t\t\t\t\t\t<button class=\"btn btn-default btn-cricle btn_stay\">留</button>\r\n");
      out.write("  \t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t<div class=\"col-xs-4\">\r\n");
      out.write("  \t\t\t\t\t\t<button class=\"btn btn-default btn-cricle btn_write\">写</button>\r\n");
      out.write("  \t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t</div>\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t\t<!-- 登录模态框 -->\r\n");
      out.write("  \t\t<div class=\"modal fade bs-example-modal-sm\" id=\"loginModal\" tabindex=\"-1\" role=\"dialog\" aria-labelledby=\"mySmallModalLabel\">\r\n");
      out.write("  \t\t\t<div class=\"modal-dialog modal-sm\" role=\"document\">\r\n");
      out.write("  \t\t\t\t<div class=\"modal-content\">\r\n");
      out.write("  \t\t\t\t\t<div class=\"modal-header\">\r\n");
      out.write("  \t\t\t\t\t\t<div class=\"modal-title\" id=\"myModalLabel\" style=\"text-align: center;\">登录</div>\r\n");
      out.write("  \t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t<div class=\"modal-body\">\r\n");
      out.write("  \t\t\t\t\t\t<form class=\"form-horizontal\" style=\"padding: 12px;\">\r\n");
      out.write("  \t\t\t\t\t\t\t<div class=\"form-group\">\r\n");
      out.write("  \t\t\t\t\t\t\t\t<input type=\"text\" class=\"form-control\" id=\"inputEmail3\" placeholder=\"账户名\">  \t\t\r\n");
      out.write("  \t\t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t\t\t<div class=\"form-group\">\t\t\t\r\n");
      out.write("  \t\t\t\t\t\t\t\t<input type=\"password\" class=\"form-control\" id=\"inputPassword3\" placeholder=\"密码\">\r\n");
      out.write("  \t\t\t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t\t</form>\r\n");
      out.write("  \t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t\t<div class=\"modal-footer\" style=\"text-align: center;\">\r\n");
      out.write("  \t\t\t\t\t\t<button type=\"button\" class=\"btn btn-primary\" style=\"width: 100%\">Login</button>\r\n");
      out.write("  \t\t\t\t\t</div>\r\n");
      out.write("  \t\t\t\t</div>\r\n");
      out.write("  \t\t\t</div>\r\n");
      out.write("  \t\t</div>\r\n");
      out.write("  \t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("  \t<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\r\n");
      out.write("  \t<script src=\"js/jquery-3.3.1/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("  \t<!-- Include all compiled plugins (below), or include individual files as needed -->\r\n");
      out.write("  \t<script src=\"js/bootstrap-3.3.7/bootstrap.min.js\"></script>\r\n");
      out.write("  \t<script src=\"js/util.js\"></script>\r\n");
      out.write("  \t<script src=\"js/cookie.js\"></script>\r\n");
      out.write("  \t<script src=\"js/login.js\"></script>\r\n");
      out.write("  \t<script type=\"text/javascript\">\r\n");
      out.write("  \tfunction login(){\r\n");
      out.write("  \t\tlocation.href = \"login\";\r\n");
      out.write("  \t}\r\n");
      out.write("  \t</script>\r\n");
      out.write("  </body>\r\n");
      out.write("  </html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}