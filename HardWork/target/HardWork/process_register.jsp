<%@ page language="java" contentType="text/html; charset=gbk"%>
<%@ page import="service.imp.UserService" %>
<%@ page import="domain.User" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="userService" class="service.imp.UserService" scope="session"></jsp:useBean>
<%
  request.setCharacterEncoding("gbk");
    //获取用户名，"userName"和register.jsp中name属性为"userName"的文本框对应
	String userName=request.getParameter("userName");

    //获取密码，"password"和register.jsp中name属性为"password"的文本框对应
	String password = request.getParameter("password");
    
    //获取真是姓名，"realName"和register.jsp中name属性为"realName"的文本框对应
	String realName = request.getParameter("realName");
    
    //获取性别，"gender"和register.jsp中name属性为"gender"的文本框对应
	String gender = request.getParameter("gender");
    
    //获取年龄，"age"和register.jsp中name属性为"age"的文本框对应
	String age = request.getParameter("age");
    
    //获取个性签名，"personalSignature"和register.jsp中name属性为"personalSignature"的文本框对应
	String personalSignature = request.getParameter("personalSignature");
	User user = new User();
	
	//设置用户类对象
	user.setUsername(userName);
	user.setPassword(password);
	user.setRealname(realName);
	user.setGender(gender);
	user.setAge(Integer.parseInt(age));
	user.setPersonalSignature(personalSignature);
	try
	{
		//调用业务逻辑层的方法完成注册功能，userService与上面的useBean元素中的id属性对应
		userService.addUser(user);
%>
        <!-- 注册成功，跳转到登录界面 -->
		<jsp:forward page="login.jsp"></jsp:forward>
<%
	}
	//处理异常
	catch(Exception ex)
	{
		ex.printStackTrace();
			
%>
       <!-- 注册失败，回到原界面 -->
		<jsp:forward page="register.jsp"></jsp:forward>
<%
	}
%>	
</body>
</html>
