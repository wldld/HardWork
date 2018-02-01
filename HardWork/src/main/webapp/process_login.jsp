<%@ page language="java" contentType="text/html; charset=gbk" %>

<%@page import="service.imp.UserService.*,domain.User.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>登陆处理</title>
</head>
<body>
<jsp:useBean id="userService" class="service.imp.UserService" scope="session"></jsp:useBean>
<%
    request.setCharacterEncoding("gbk");
    String userName = request.getParameter("username");
    String password = request.getParameter("password");
    if (userService.validateUser(userName, password) != null) {
        //保存用户对象到会话
        session.setAttribute("user", userService.validateUser(userName, password));
%>
<jsp:forward page="main.jsp"></jsp:forward>
<%
} else {
%>
<jsp:forward page="login.jsp"></jsp:forward>
<%
    }
%>
</body>
</html>
