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
    //��ȡ�û�����"userName"��register.jsp��name����Ϊ"userName"���ı����Ӧ
	String userName=request.getParameter("userName");

    //��ȡ���룬"password"��register.jsp��name����Ϊ"password"���ı����Ӧ
	String password = request.getParameter("password");
    
    //��ȡ����������"realName"��register.jsp��name����Ϊ"realName"���ı����Ӧ
	String realName = request.getParameter("realName");
    
    //��ȡ�Ա�"gender"��register.jsp��name����Ϊ"gender"���ı����Ӧ
	String gender = request.getParameter("gender");
    
    //��ȡ���䣬"age"��register.jsp��name����Ϊ"age"���ı����Ӧ
	String age = request.getParameter("age");
    
    //��ȡ����ǩ����"personalSignature"��register.jsp��name����Ϊ"personalSignature"���ı����Ӧ
	String personalSignature = request.getParameter("personalSignature");
	User user = new User();
	
	//�����û������
	user.setUsername(userName);
	user.setPassword(password);
	user.setRealname(realName);
	user.setGender(gender);
	user.setAge(Integer.parseInt(age));
	user.setPersonalSignature(personalSignature);
	try
	{
		//����ҵ���߼���ķ������ע�Ṧ�ܣ�userService�������useBeanԪ���е�id���Զ�Ӧ
		userService.addUser(user);
%>
        <!-- ע��ɹ�����ת����¼���� -->
		<jsp:forward page="login.jsp"></jsp:forward>
<%
	}
	//�����쳣
	catch(Exception ex)
	{
		ex.printStackTrace();
			
%>
       <!-- ע��ʧ�ܣ��ص�ԭ���� -->
		<jsp:forward page="register.jsp"></jsp:forward>
<%
	}
%>	
</body>
</html>
