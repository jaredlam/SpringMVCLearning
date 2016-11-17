<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add Student</title>
</head>
<body>
	<div>
		<form action="<%=request.getContextPath()%>/student/save"
			method="post">
			<div>
				<span>学生姓名：</span><input type="text" id="studentName"
					name="studentName">
			</div>
			<div>
				<span>学生年龄：</span><input type="text" id="studentAge"
					name="studentAge">
			</div>
			<div>
				<span>学生班级：</span><select id="studentClass" name="studentClass">
					<option value="1班" selected="selected">第1班</option>
					<option value="2班">第2班</option>
					<option value="3班">第3班</option>
				</select>
			</div>
			<input type="submit" id="btnSubmit" value="保存">
		</form>
	</div>
</body>
</html>