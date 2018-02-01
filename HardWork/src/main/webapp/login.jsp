<%@ page language="java" contentType="text/html; charset=gbk"
%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
<head>
    <base href="<%=basePath%>">

    <title>登陆界面</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">


</head>

<body>
<form action="process_login.jsp" method="post">
    <table align="center" border="0" cellpadding="0" cellspacing="7"
           width="234">
        <tr>
            <td align="left" valign="middle" width="26">
                <img src="css/images/jiantou3.jpg" width="11" height="10">
            </td>
            <td align="center" valign="middle" width="60">
                <img src="css/images/user.jpg" width="46" height="15">
            </td>
            <td align="center" valign="middle" width="148">
                <input type = "Text"  name="username">
            </td>
        </tr>
        <tr>
            <td align="left" valign="middle" width="26">
                <img src="css/images/jiantou3.jpg" width="11" height="10">
            </td>
            <td align="center" valign="middle" width="60">
                <img src="css/images/pass.jpg" width="47" height="15">
            </td>
            <td align="center" valign="middle" width="148">
                <input type ="password" name="password"/>
            </td>
        </tr>
        <tr>
            <td align="left"><input type="submit" value="进入"/></td>
            &nbsp;&nbsp;&nbsp;&nbsp;
            <td align="right"><a href="register.jsp"><input type="button" value="注册"></input></a> </td>
        </tr>

    </table>
</form>

</body>
</html>
