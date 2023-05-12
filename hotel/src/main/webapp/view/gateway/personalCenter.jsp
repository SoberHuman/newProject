<%--
  Created by IntelliJ IDEA.
  User: hyw
  Date: 2023/4/7
  Time: 11:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人中心</title>
    <link href="${pageContext.request.contextPath}/css/gateway/bootstrap.min.css" rel="stylesheet">

    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
</head>
<style>
    *{
        margin: 0;
        padding: 0;
    }
    li{
        text-decoration: none;
    }
</style>
<body>
<h3>个人中心</h3>

<div>

    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/gatewayShowAllRoomType/0" >首页</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/personalInfo">个人信息</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/order">个人订单</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/view/gateway/personalModify.jsp">修改密码</a>
        </li>
        <li>
            <a href="${pageContext.request.contextPath}/clientCancellation">安全退出</a>
        </li>
    </ul>
    <div></div>
</div>
</body>
</html>
