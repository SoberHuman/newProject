<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>发送验证码测试</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/messageTest">
<input type="text" name="phone">
<button type="submit">获取验证码</button>
</form>
</body>
</html>