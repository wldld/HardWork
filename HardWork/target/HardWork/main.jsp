<%@ page language="java" contentType="text/html; charset=gbk" %>

<%@page import="java.util.*,domain.*,service.imp.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title>社区主页</title>
</head>
<body>
<jsp:useBean id="infoService" class="service.imp.InfoService" scope="session"></jsp:useBean>
<%
    //调用业务逻辑层方法，获取所有信息列表
    List<Information> list = infoService.getAllInfo();
%>
<div id="outer">
    <div id="upbg"></div>
    <div id="inner">
        <div id="header">
            <h1><span>简易社区</span></h1>
            <h2>by 社区小组</h2>
        </div>
        <div id="splash"></div>
        <div id="menu">
            <ul>
                <li class="first"><a href="main.jsp">信息浏览</a></li>
                <li><a href="#">控制面板</a></li>
                <li><a href="logout.jsp">退出</a></li>
            </ul>
            <div id="date"></div>
        </div>
        <div id="primarycontent">

            <!-- primary content start -->
            <div class="post">
                <div class="header">
                    <h3>日志</h3>
                    <div class="date"></div>
                </div>
                <%
                    //循环帖子列表，显示日志信息
                    for (Information info : list) {
                        if (info.getType().equals("日志")) {
                %>
                <div class="content">
                    <!-- 读者请注意此处的Java表达式运用 -->
                    <p><a href="detail.jsp?Id=<%=info.getId()%>"><%=info.getTitle() %>
                    </a>&nbsp;&nbsp;<%=info.getPublishingtime()%>
                    </p>
                </div>
                <%
                        }
                    }
                %>
                <div class="header">
                    <h3>社区信息</h3>
                    <div class="date"></div>
                </div>
                <%
                    //循环帖子列表，显示社区信息
                    for (Information info : list) {
                        if (info.getType().equals("社区信息")) {
                %>
                <div class="content">
                    <!-- 读者请注意此处的Java表达式运用 -->
                    <p><a href="detail.jsp?Id=<%=info.getId()%>"><%=info.getTitle() %>
                    </a>&nbsp;&nbsp;<%=info.getPublishingtime()%>
                    </p>
                </div>
                <%
                        }
                    }
                %>
            </div>
            <!-- primary content end -->

        </div>

        <div id="secondarycontent">

            <!-- secondary content start -->
            <!-- 从会话中取出用户名，读者请注意此处的Java表达式运用 ，包括了取会话的操作-->
            <h3><%=((User) session.getAttribute("user")).getUsername() %>
            </h3>

            <div class="content">
                <p><a href="addinformation.jsp">发布信息</a></p>
            </div>
            <!-- secondary content end -->

        </div>

        <div id="footer">
            &copy; 社区小组. All rights reserved. Design by 社区小组.
        </div>

    </div>
</div>
</body>
</html>
