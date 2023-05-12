<%--
  Created by IntelliJ IDEA.
  User: hyw
  Date: 2023/4/10
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>预定预览</title>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .box{
            width:100%;
            height: 100vh;
            overflow: hidden;
            background: #1F2E46;
        }
        .obox{
            width: 500px;
            background: cornsilk;
            border-radius: 5px;
            line-height: 35px;
            margin:150px auto;
            padding: 20px;
        }
        input{
            border: none;
            /*去除鼠标事件*/
            pointer-events: none;
            background: #FFF8DC;
        }
        button{
            margin: 10px 0;
            padding: 5px 35px;
            border-radius: 5px;

        }
        textarea{
            width: 300px;
            height: 50px;
        }
        a{
            margin: 20px;
            color: white;
        }
        #WIDbody{
            vertical-align: middle;
        }
    </style>
</head>
<body>

<div class="box">
    <a href="${pageContext.request.contextPath}/gatewayShowAllRoomType/0" >首页</a>
    <form name="alipayment" action="${pageContext.request.contextPath}/pay/showPay" method="post" target="_blank">
    <div class="obox">
        <p>
            订单号：<input id="WIDout_trade_no" name="WIDout_trade_no" />
        </p>
        <p>
            预定人：<c:if test="${sessionScope.loginKey==0}">
                            ${sessionScope.userss.userRealName}
                    </c:if>
                    <c:if test="${sessionScope.loginKey == 1}">
                        ${sessionScope.clients.clientName}
                    </c:if>
        </p>
        <p>
            预定时间：<span type="text" name="reservationTime" class="reservationTime"/>
        </p>

        <p>
            房型名称：<input type="text" id="WIDsubject" name="WIDsubject" value="${requestScope.reservation.getRoomTypeName()}">
        </p>
        <p>
            房价：
            <c:if test="${requestScope.selectMenu==0}">
                <c:if test="${requestScope.users!=null}">
                    ${requestScope.roomTypeInfo.vipPrice} (到付)
                </c:if>
                <c:if test="${requestScope.client!=null}">
                    ${requestScope.roomTypeInfo.listPrice} (到付)
                </c:if>
            </c:if>


            <c:if test="${requestScope.selectMenu==1}">
                <c:if test="${requestScope.users!=null}">
                    ${requestScope.roomTypeInfo.vipPrice}
                </c:if>
                <c:if test="${requestScope.client!=null}">
                    ${requestScope.roomTypeInfo.listPrice}
                </c:if>
            </c:if>
        </p>
        <p>
            预计到达时间：${requestScope.reservation.getExpectedTimeOfArrival()}

        </p>
        <p>
            预计离开时间：${requestScope.reservation.getEstimatedTimeOfDeparture()}
        </p>
        <p>
            押金：<input value="${requestScope.reservation.reservationForegift}" readonly unselectable="on"/>
        </p>
        <p>
            结算：<input  id="WIDtotal_amount" name="WIDtotal_amount"   value="${requestScope.Price}">

        </p>
        <p>
            备注：<textarea id="WIDbody" name="WIDbody"></textarea>
        </p>
        <p>
            <button>确定支付</button>
        </p>
    </div>
    </form>
</div>

<script src="${pageContext.request.contextPath}/js/gateway/jquery-2.2.4.min.js"></script>
<script type="text/javascript">
    $(document).ready(function () {
        setInterval(function () {
            $(".reservationTime").html(getNowDate());
        },1000)


        function getNowDate() {
            var myDate = new Date;
            var year = myDate.getFullYear(); //获取当前年
            var mon = myDate.getMonth() + 1; //获取当前月
            var date = myDate.getDate(); //获取当前日
            var hours = myDate.getHours(); //获取当前小时
            var minutes = myDate.getMinutes(); //获取当前分钟
            var seconds = myDate.getSeconds(); //获取当前秒
            var now = year + "-" + mon + "-" + date + " " + hours + ":" + minutes + ":" + seconds;
            return now;
        }




        $("#WIDout_trade_no").val(getNowDate2());
        function getNowDate2() {
            var myDate = new Date;
            var year = myDate.getFullYear(); //获取当前年
            var mon = myDate.getMonth() + 1; //获取当前月
            var date = myDate.getDate(); //获取当前日
            var hours = myDate.getHours(); //获取当前小时
            var minutes = myDate.getMinutes(); //获取当前分钟
            var seconds = myDate.getSeconds(); //获取当前秒
            var now = year + mon +  date +  hours +  minutes +  seconds;
            return now;
        }
    })
</script>
</body>
</html>
