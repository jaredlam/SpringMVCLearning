<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hello Spring MVC</title>
</head>
<body>
	<ul>
		<li><span>学生姓名</span> <em>${student.studentName}</em></li>
		<li><span>学生年龄</span> <em>${student.studentAge}</em></li>
		<li><span>学生班级</span> <em>${student.studentClass}</em></li>
	</ul>
</body>
</html>