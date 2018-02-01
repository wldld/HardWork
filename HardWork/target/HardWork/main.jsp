<%@ page language="java" contentType="text/html; charset=gbk" %>

<%@page import="java.util.*,domain.*,service.imp.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/style.css"/>
    <title>������ҳ</title>
</head>
<body>
<jsp:useBean id="infoService" class="service.imp.InfoService" scope="session"></jsp:useBean>
<%
    //����ҵ���߼��㷽������ȡ������Ϣ�б�
    List<Information> list = infoService.getAllInfo();
%>
<div id="outer">
    <div id="upbg"></div>
    <div id="inner">
        <div id="header">
            <h1><span>��������</span></h1>
            <h2>by ����С��</h2>
        </div>
        <div id="splash"></div>
        <div id="menu">
            <ul>
                <li class="first"><a href="main.jsp">��Ϣ���</a></li>
                <li><a href="#">�������</a></li>
                <li><a href="logout.jsp">�˳�</a></li>
            </ul>
            <div id="date"></div>
        </div>
        <div id="primarycontent">

            <!-- primary content start -->
            <div class="post">
                <div class="header">
                    <h3>��־</h3>
                    <div class="date"></div>
                </div>
                <%
                    //ѭ�������б���ʾ��־��Ϣ
                    for (Information info : list) {
                        if (info.getType().equals("��־")) {
                %>
                <div class="content">
                    <!-- ������ע��˴���Java���ʽ���� -->
                    <p><a href="detail.jsp?Id=<%=info.getId()%>"><%=info.getTitle() %>
                    </a>&nbsp;&nbsp;<%=info.getPublishingtime()%>
                    </p>
                </div>
                <%
                        }
                    }
                %>
                <div class="header">
                    <h3>������Ϣ</h3>
                    <div class="date"></div>
                </div>
                <%
                    //ѭ�������б���ʾ������Ϣ
                    for (Information info : list) {
                        if (info.getType().equals("������Ϣ")) {
                %>
                <div class="content">
                    <!-- ������ע��˴���Java���ʽ���� -->
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
            <!-- �ӻỰ��ȡ���û�����������ע��˴���Java���ʽ���� ��������ȡ�Ự�Ĳ���-->
            <h3><%=((User) session.getAttribute("user")).getUsername() %>
            </h3>

            <div class="content">
                <p><a href="addinformation.jsp">������Ϣ</a></p>
            </div>
            <!-- secondary content end -->

        </div>

        <div id="footer">
            &copy; ����С��. All rights reserved. Design by ����С��.
        </div>

    </div>
</div>
</body>
</html>
