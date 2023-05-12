<%--
  Created by IntelliJ IDEA.
  User: hyw
  Date: 2023/4/18
  Time: 11:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>修改密码</title>
</head>
<style>
    b{
        width: 100px;
        height: 32px;
    }
</style>
<body>

    <c:if test="${sessionScope.loginKey==0}">
        <c:if test="${sessionScope.userss!=null}">
            <form action="${pageContext.request.contextPath}/personalModify" method="post">
                    <p>用户名：${sessionScope.userss.userRealName}</p>
                    <p>旧密码：
                        <input type="text" name="oldUserPass" class="oldUserPass">
                    </p>
                    <p>新密码：
                        <input type="text" name="userPass" class="userPass">
                    </p>
                    <p>确认密码：
                        <input type="text" name="twoUserPass" class="twoUserPass">
                    </p>
                    <b class="bbl"></b>
                    <p>
                        <input type="submit" value="修改">
                    </p>
            </form>
        </c:if>
    </c:if>



    <c:if test="${sessionScope.loginKey==1}">
        <c:if test="${sessionScope.clients!=null}">
            <form action="${pageContext.request.contextPath}/ClientPersonalModify" method="post">
                <p>用户名：${sessionScope.clients.clientName}</p>
                <p>旧密码：
                    <input type="text" name="oldClientPass" class="oldUserPass">
                </p>
                <p>新密码：
                    <input type="text" name="clientPass" class="userPass">
                </p>
                <p>确认密码：
                    <input type="text" name="twoClientPass" class="twoUserPass">
                </p>
                <b class="bbl"></b>
                <p>
                    <input type="submit" value="修改">
                </p>
            </form>
        </c:if>
    </c:if>




    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js" ></script>
    <script type="text/javascript">
        $(document).ready(function () {
            $(".twoUserPass").on("input",function () {
                let twoUserPass = $(".twoUserPass").val();
                let userPass = $(".userPass").val();
                if(userPass!=twoUserPass){
                    $(".bbl").html("两次密码不一致");
                }else{
                    $(".bbl").html("");
                }
            })

        })
    </script>
</body>
</html>
