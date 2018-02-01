<%@ page language="java" contentType="text/html; charset=gbk"%>

<%@ page import="domain.User" %>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="domain.Information"%>

<%@page import="service.imp.InfoService"%>
<%@ page import="java.sql.Timestamp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<!-- 声明javaBean -->
<jsp:useBean id="infoService" scope="session" class="service.imp.InfoService"></jsp:useBean>
<%
  request.setCharacterEncoding("gbk");
	//获取标题
	String title = request.getParameter("title");
    //获取信息内容
    String content = request.getParameter("content");
    //获取信息类型
    String type=request.getParameter("type");
    //读取会话中的user对象，并取出用户名
    String userName=((User)session.getAttribute("user")).getUsername();
    //初始化一个信息类对象
    Information information = new Information();
    information.setTitle(title);
    information.setContent(content);
    information.setType(type);
    
    information.setPublishingtime(new Timestamp((new Date()).getTime()));
   
    //设置用户字段
    information.setPublishinguser(userName);
    //调用业务逻辑层方法，添加信息到数据库
    infoService.addInfo(information);
    
%>
    <!--信息发布成功，回到系统主界面  -->
	<jsp:forward page="main.jsp"></jsp:forward>
</body>
</html>
