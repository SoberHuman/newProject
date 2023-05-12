<%--
  Created by IntelliJ IDEA.
  User: hyw
  Date: 2023/4/18
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人信息</title>
</head>
<body>
${requestScope.userPass}
<c:if test="${sessionScope.loginKey==0}">
    <c:if test="${sessionScope.userss!=null}">
        <p>
            会员号：${sessionScope.userss.userVipId}
        </p>
        <p>
            密码:${requestScope.Pass}
        </p>
        <p>
            用户名：${sessionScope.userss.userRealName}
        </p>
        <p>
            身份证号：${sessionScope.userss.userIdCard}
        </p>
        <p>
            联系电话：${sessionScope.userss.userPhone}
        </p>
        <p>
            会员积分：${sessionScope.userss.userIntegral}
        </p>
    </c:if>
</c:if>
<c:if test="${sessionScope.loginKey==1}">
    <c:if test="${sessionScope.clients!=null}">
        <p>
            用户名：${sessionScope.clients.clientName}
        </p>
        <p>
            密码：${requestScope.Pass}
        </p>
        <p>
            身份证号：${sessionScope.clients.clientIdCard}
        </p>
        <p>
            联系电话：${sessionScope.clients.clientPhone}
        </p>





    </c:if>
</c:if>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js" ></script>
<script>
    var pass =  '${requestScope.userPass}';
    console.log(pass);

</script>
</body>
</html>
