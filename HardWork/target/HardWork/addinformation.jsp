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
				<label>����</label>
				<input type="text" name="title"/>
			</td>
		</tr>
		<tr>
			<td>
				<label>����</label>
				<textarea rows="3" cols="18" name="content"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<label>����</label>
				<select name="type">
					<option value="��־">��־</option>
					<option value="������Ϣ">������Ϣ</option>
  				</select>
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="����"/>
			</td>
		</tr>
	</table>
</form>

  </body>
</html>
