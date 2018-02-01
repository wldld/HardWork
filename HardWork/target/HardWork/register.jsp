<%--
  Created by IntelliJ IDEA.
  User: XY
  Date: 2018/2/1
  Time: 11:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <title>社区主页</title>
</head>
<body>
<div id="outer">
    <div id="upbg"></div>
    <div id="inner">
        <div id="header">
            <h1><span>简易社区</span></h1>
            <h2>by 社区小组</h2>
        </div>
        <div id="splash"></div>
        <div id="menu">
        </div>

        <div id="primarycontent">

            <!-- primary content start -->
            <div class="post">
                <div class="header">
                    <h3>个人信息</h3>
                    <div class="date"></div>
                </div>
                <div class="content">
                    <form action="process_register.jsp" method="post">
                        <table id ="userInfo_table">
                            <tr>
                                <td>
                                    <label>用户名</label>
                                </td>
                                <td>
                                    <input type="text" name="userName"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>性    别</label>
                                </td>
                                <td>
                                    <select name="gender">
                                        <option value="男" selected="selected">男</option>
                                        <option value="女">女</option>
                                    </select>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>真实姓名</label>
                                </td>
                                <td>
                                    <input type="text" name="realName"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>密码</label>
                                </td>
                                <td>
                                    <input type="password" name="password"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>年龄</label>
                                </td>
                                <td>
                                    <input type="text" name="age"/>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <label>个性签名</label>
                                </td>
                                <td>
                                    <textarea rows="3" cols="18" name="personalSignature"></textarea>
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <input type ="submit" value="注册"/>
                                </td>
                            </tr>
                        </table>
                    </form>
                </div>
                <div class="footer">
                    <ul>
                        <li class="readmore"><a href="login.jsp">返回</a></li>
                    </ul>
                </div>
            </div>
            <!-- primary content end -->

        </div>

        <div id="secondarycontent">

            <!-- secondary content start -->
            <h3></h3>
            <!-- secondary content end -->

        </div>

        <div id="footer">
            &copy; 社区小组. All rights reserved. Design by 社区小组.
        </div>
    </div>
</div>
</body>
</html>
