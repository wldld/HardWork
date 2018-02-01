<%@ page language="java" contentType="text/html; charset=gbk"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addinformation.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
   <form action="Process_addinformation.jsp" method="post">
	<table>
		<tr>
			<td>
				<label>标题</label>
				<input type="text" name="title"/>
			</td>
		</tr>
		<tr>
			<td>
				<label>内容</label>
				<textarea rows="3" cols="18" name="content"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<label>类型</label>
				<select name="type">
					<option value="日志">日志</option>
					<option value="社区信息">社区信息</option>
  				</select>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="发布"/>
			</td>
		</tr>
	</table>
</form>

  </body>
</html>
