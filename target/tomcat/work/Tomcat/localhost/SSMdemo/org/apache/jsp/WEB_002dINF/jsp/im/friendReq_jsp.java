/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2019-03-13 09:01:14 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.jsp.im;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class friendReq_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\t<title>申请验证</title>\r\n");
      out.write("\r\n");
      out.write("\t<!-- Bootstrap -->\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/bootstrap-3.3.7/bootstrap.min.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/protal/index.css\">\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"css/common.css\">\r\n");
      out.write("\t<style type=\"text/css\">\r\n");
      out.write("\t.friendAddMsgModalFooter{\r\n");
      out.write("\t\theight:550px;overflow-y:auto;overflow-x:hidden\r\n");
      out.write("\t}\r\n");
      out.write("\t.loading-warp{ display: table; width: 100%; margin-top: -5.8rem; }\r\n");
      out.write("\t.loading-warp .box{ width: 100%; padding-top: 1rem; padding-bottom: 1rem;\r\n");
      out.write("\t\tdisplay: table-cell; text-align: center; vertical-align: middle; }\r\n");
      out.write("\t.loading-warp .box img{ display: block; width: 2rem; height: 2rem; margin: 0 auto; }\r\n");
      out.write("\t\r\n");
      out.write("\t</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t\r\n");
      out.write("  \t\r\n");
      out.write("  \t<div class=\"friendAddMsgModalFooter chat-scrollbar\">\r\n");
      out.write("\t\t<div id=\"friendReqList\" draggable=\"false\">\r\n");
      out.write("\t\t</div>\r\n");
      out.write("  \t</div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\r\n");
      out.write("  \t<script src=\"js/jquery-3.3.1/jquery-3.3.1.min.js\"></script>\r\n");
      out.write("  \t<script src=\"js/jquery-ui.min.js\"></script>\r\n");
      out.write("  \t<!-- Include all compiled plugins (below), or include individual files as needed -->\r\n");
      out.write("  \t<script src=\"js/bootstrap-3.3.7/bootstrap.min.js\"></script>\r\n");
      out.write("  \t<script src=\"js/util.js\"></script>\r\n");
      out.write("\t<script src=\"js/cookie.js\"></script>\r\n");
      out.write("\t<script src=\"js/login.js\"></script>\r\n");
      out.write("  \t<script type=\"text/javascript\">\r\n");
      out.write("  \tvar reqTimes=1;\r\n");
      out.write("  \tvar hasMore=0;\r\n");
      out.write("  \tvar LoginUser;\r\n");
      out.write("  \t$(function () {\r\n");
      out.write("  \t\tvar _ticket = $.cookie(\"TT_TOKEN\");\r\n");
      out.write("\t\tif(!_ticket){\r\n");
      out.write("\t\t \treturn ;\r\n");
      out.write("\t\t}\r\n");
      out.write("  \t\t$.ajax({\r\n");
      out.write("                  url : \"http://localhost:8080/SSMdemo/token/\" + _ticket,\r\n");
      out.write("                  dataType : \"json\",\r\n");
      out.write("                  type : \"GET\",\r\n");
      out.write("                  success : function(data){\r\n");
      out.write("                        if(data.status == 200){\r\n");
      out.write("\t\t\t\t\t\t\t\tLoginUser=data.data;\r\n");
      out.write("\t\t\t\t\t\t  \t    //获取好友请求;\r\n");
      out.write("\t\t\t\t\t\t\t\tgetFriendRequest(LoginUser);\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("                  }\r\n");
      out.write("\r\n");
      out.write("            });\r\n");
      out.write("  \t\t\r\n");
      out.write("  \t});\r\n");
      out.write("  \t\r\n");
      out.write("  \tfunction getFriendRequest(LoginUser){\r\n");
      out.write("  \t\tvar msgList=[];\r\n");
      out.write("  \t\t$.ajax({\r\n");
      out.write("  \t\t\turl:\"");
      out.print(basePath);
      out.write("getFriendRequestListByUser\",\r\n");
      out.write("  \t\t\ttype:\"post\",\r\n");
      out.write("  \t\t\tdataType:\"json\",\r\n");
      out.write("  \t\t\tdata:{\r\n");
      out.write("  \t\t\t\tpage:reqTimes,\r\n");
      out.write("  \t\t\t\trows:10,\r\n");
      out.write("  \t\t\t\tuserId:LoginUser.id\r\n");
      out.write("  \t\t\t},\r\n");
      out.write("  \t\t\tsuccess:function(data){\r\n");
      out.write("  \t\t\t\tmsgList=data;\r\n");
      out.write("  \t\t\t\t//拼接消息\r\n");
      out.write("  \t\t\t\tappendFriendRequest(msgList);\r\n");
      out.write("  \t\t\t}\r\n");
      out.write("  \t\t});\t\r\n");
      out.write("  \t}\r\n");
      out.write("  \t\r\n");
      out.write("  //拼接消息\r\n");
      out.write("  \tfunction appendFriendRequest(msgList){\r\n");
      out.write("  \t\tvar str=\"\";\r\n");
      out.write("\t\tif(msgList&&msgList.length){\r\n");
      out.write("\t\t\tfor (var i = 0; i < msgList.length; i++) {\r\n");
      out.write("\t\t\t\t\tstr+=\"\t<div class='row' style='border-bottom:1px solid #cccccc;padding:10px;'>\";\r\n");
      out.write("\t\t\t\t\tstr+=\"    <div class='col-sm-2' style='display: inline-block;vertical-align:middle;'> \";\r\n");
      out.write("\t\t\t\t\tstr+=\"    <img class='avatar-middle-1' msgId='\"+msgList[i].id+\"' src='\"+msgList[i].headPath+\"'>\";\r\n");
      out.write("\t\t\t\t\tstr+=\"     </div>\";\r\n");
      out.write("\t\t\t\t\tstr+=\"    <div class='col-sm-7' style='display: inline-block;vertical-align:middle;'> \";\r\n");
      out.write("\t\t\t\t\tstr+=\"        <div class='msg-item-right-name' style='display: inline-block;'>\"+msgList[i].nickName+\"</div>\";\r\n");
      out.write("\t\t\t\t\tstr+=\"        <div class='msg-item-send-time' style='display: inline-block;color:#777777;'>\"+msgList[i].createTime+\"</div>\";\r\n");
      out.write("\t\t\t\t\tstr+=\"        <div>\";\r\n");
      out.write("\t\t\t\t\tif(msgList[i].userId==LoginUser.id){\r\n");
      out.write("\t\t\t\t\t\tstr+=\"        <span >已发送验证消息</span><br>\";\r\n");
      out.write("\t\t\t\t\t}else if(msgList[i].reqToId==LoginUser.id){\r\n");
      out.write("\t\t\t\t\t\tstr+=\"        <span >申请加你为好友</span><br>\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\tstr+=\"        <span style='color:#777777;overflow: hidden;text-overflow: ellipsis;white-space: nowrap;width:200px;'> 附言：\"+msgList[i].reqRemark+\"</span>\";\r\n");
      out.write("\t\t\t\t\tstr+=\"     \t  </div>\";\r\n");
      out.write("\t\t\t\t\tstr+=\"     </div>\";\r\n");
      out.write("\t\t\t\t\tif(msgList[i].reqResult==0){\r\n");
      out.write("\t\t\t\t\t\tif(msgList[i].userId==LoginUser.id){\r\n");
      out.write("\t\t\t\t\t\t\tstr+=\"    <div class='col-sm-3' > \";\r\n");
      out.write("\t\t\t\t\t\t\tstr+=\"    等待验证\";\r\n");
      out.write("\t\t\t\t\t\t\tstr+=\"     </div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t}else if(msgList[i].reqToId==LoginUser.id){\r\n");
      out.write("\t\t\t\t\t\t\tstr+=\"    <div class='col-sm-3' > \";\r\n");
      out.write("\t\t\t\t\t\t\tstr+=\"    <button class='btn btn-info agree'>同意</button>\";\r\n");
      out.write("\t\t\t\t\t\t\tstr+=\"    <button class='btn btn-default refuse'>拒绝</button>\";\r\n");
      out.write("\t\t\t\t\t\t\tstr+=\"     </div>\";\r\n");
      out.write("\t\t\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t}else if(msgList[i].reqResult==1){\r\n");
      out.write("\t\t\t\t\t\tstr+=\"    <div class='col-sm-3' > \";\r\n");
      out.write("\t\t\t\t\t\tstr+=\"    已同意\";\r\n");
      out.write("\t\t\t\t\t\tstr+=\"     </div>\";\r\n");
      out.write("\t\t\t\t\t}else if(msgList[i].reqResult==2){\r\n");
      out.write("\t\t\t\t\t\tstr+=\"    <div class='col-sm-3' > \";\r\n");
      out.write("\t\t\t\t\t\tstr+=\"    已拒绝\";\r\n");
      out.write("\t\t\t\t\t\tstr+=\"     </div>\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\t\r\n");
      out.write("\t\t\t\t\tstr+=\" </div>\";\r\n");
      out.write("\t\t\t}\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\tif(reqTimes==1){\r\n");
      out.write("\t\t\t$(\"#friendReqList\").empty();\r\n");
      out.write("\t\t}\r\n");
      out.write("\t\t$(\"#friendReqList\").append(str);\r\n");
      out.write("\t\tif(msgList.length<10){\r\n");
      out.write("\t\t\thasMore=1;\r\n");
      out.write("\t\t\tvar noMoreStr=\"\";\r\n");
      out.write("\t\t\tnoMoreStr+=\"<div style='color:#777777;text-align:center;padding:10px;'>\";\r\n");
      out.write("\t\t\tnoMoreStr+=\"暂无更多新消息</div>\";\r\n");
      out.write("\t\t\t$(\"#friendReqList\").append(noMoreStr);\r\n");
      out.write("\t\t}\r\n");
      out.write("  \t}\r\n");
      out.write("  \t//判断滚动条是否到底部\r\n");
      out.write("  \t$(\".friendAddMsgModalFooter\").scroll(function(){\r\n");
      out.write("\t  \t\tvar scrollTop = $(this).scrollTop();\r\n");
      out.write("\t  \t\tvar scrollHeight = $(this)[0].scrollHeight;\r\n");
      out.write("\t  \t\tvar windowHeight = $(this).height();\r\n");
      out.write("\t  \t\tif(scrollTop + windowHeight == scrollHeight){\r\n");
      out.write("\t  \t\t\tif(hasMore==0){\r\n");
      out.write("\t  \t\t\t\treqTimes++;\r\n");
      out.write("\t  \t\t\t\tgetFriendRequest(LoginUser);\r\n");
      out.write("\t  \t\t\t}\r\n");
      out.write("\t  \t\t}\r\n");
      out.write("  \t\t});\r\n");
      out.write("  \t\r\n");
      out.write("  \t /**\r\n");
      out.write("     * Sidebar Dropdown\r\n");
      out.write("     */\r\n");
      out.write("    $(document).on('click','.btn',function(e){\r\n");
      out.write("    \te.preventDefault();\r\n");
      out.write("    \tvar msgId=$(this).parent().parent().find(\".avatar-middle-1\").attr(\"msgId\");\r\n");
      out.write("    \tvar that=$(this);\r\n");
      out.write("    \t//同意\r\n");
      out.write("    \tif($(this).hasClass(\"agree\")){\r\n");
      out.write("    \t\tupdateReq(msgId,1,that);\r\n");
      out.write("    \t}else if($(this).hasClass(\"refuse\")){\r\n");
      out.write("    \t\tupdateReq(msgId,2,that);\r\n");
      out.write("    \t}\r\n");
      out.write("\t});\r\n");
      out.write("  \t function updateReq(msgId,result,that){\r\n");
      out.write("  \t\t$.ajax({\r\n");
      out.write("  \t\t\turl:\"");
      out.print(basePath);
      out.write("applyFriendRequest\",\r\n");
      out.write("  \t\t\ttype:\"post\",\r\n");
      out.write("  \t\t\tdataType:\"json\",\r\n");
      out.write("  \t\t\tdata:{\r\n");
      out.write("  \t\t\t\tid:msgId,\r\n");
      out.write("  \t\t\t\treqResult:result\r\n");
      out.write("  \t\t\t},\r\n");
      out.write("  \t\t\tsuccess:function(data){\r\n");
      out.write("  \t\t\t\tif(data.status==200){\r\n");
      out.write("  \t\t\t\t\tvar str=\"\";\r\n");
      out.write("  \t\t\t\t\tif(result==1){\r\n");
      out.write("\t\t\t\t\t\tstr+=\"    已同意\";\r\n");
      out.write("\t\t\t\t\t}else if(result==2){\r\n");
      out.write("\t\t\t\t\t\tstr+=\"    已拒绝\";\r\n");
      out.write("\t\t\t\t\t}\r\n");
      out.write("  \t\t\t\t\tthat.parent().empty().append(str);\r\n");
      out.write("  \t\t\t\t}else{\r\n");
      out.write("  \t\t\t\t\talert(data.msg);\r\n");
      out.write("  \t\t\t\t}\r\n");
      out.write("  \t\t\t}\r\n");
      out.write("  \t\t});\t\r\n");
      out.write("  \t }\r\n");
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
