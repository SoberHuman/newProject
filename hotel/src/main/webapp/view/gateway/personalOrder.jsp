<%--
  Created by IntelliJ IDEA.
  User: hyw
  Date: 2023/4/19
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>个人订单</title>
</head>
<style>
    *{
        margin: 0;
        padding: 0
    }

    body{
        background: #85ECF1;
    }
    h3{
        margin: 0 10px;
    }
    .orderMiddle>li{
        margin: 10px 10px;
        float: left;
    }
    .orderContent{
        width: 100%;
        display: flex;
        justify-content: space-between;
        flex-wrap: wrap;
    }
    .box{
        width: 30%;
        background: #FFFFFF;
        margin: 10px;
        line-height: 32px;
        border-top-left-radius: 30px;

    }
    .divbox1{
        margin: 20px 0;
        display: flex;
        justify-content: space-between;
    }
    .divbox1>span{
        display: block;
        text-align: center;
    }
    .divbox1>span:nth-child(1),.divbox1>span:nth-child(3){
        width: 40%;
        background: #85ECF1;
        border-radius: 50px;
        padding: 5px;
        font-size: 10px;

    }
    .divbox1>span:nth-child(2){
        display: block;
        width: 40px;
        height: 40px;
        background: blue;
        border-radius: 50px;
        color: #FFFFFF;
    }
    .divbox2p{
        display: flex;
        justify-content: space-between;
        flex-wrap: wrap;
    }

    .box>div{
        padding:20px;
    }
    img{
        width: 80px;
        height: 80px;
    }
    .divbutton>a{
        width: 75px;
        border-radius: 50px;
        border: blue 1px solid;
        cursor: pointer;
        padding: 5px 10px;
    }
    .reId{
        margin: 20px 0;
        border-top: #CCCCCC 1px solid;
        border-bottom: #CCCCCC 1px solid;
    }
    input{
        pointer-events: none;
        border: none;
    }
    .cancelR{
        width: 75px;
        border-radius: 50px;
        border: blue 1px solid;
        padding: 5px 10px;
    }
    .canR{
        width: 75px;
        border-radius: 50px;
        border: blue 1px solid;
        padding: 5px 10px;
        background-color: rgba(0,0,0,0.3);
        text-decoration:line-through
    }
</style>
<body>
<div class="orderTop">
   <div>
       <h3>我的订单</h3>
   </div>
    <div>

    </div>
</div>
<ul class="orderMiddle">
    <li>全部</li>
    <li>待付款</li>
    <li>待入住</li>

</ul>
<div class="orderContent">
<c:forEach items="${requestScope.reservations}" var="item">

    <div class="box">
        <div>
            <form action="${pageContext.request.contextPath}/updateReservation2" method="post">
            <div class="divbox1">
                <span>入住:${item.getExpectedTimeOfArrival().substring(0,10)}</span>
                <span>${item.getReservationOccupancyDays()}天</span>
                <span>离开：${item.getEstimatedTimeOfDeparture().substring(0,10)}</span>
            </div>
            <div class="divbox2">
                <p>warada酒店>${item.getReservationStatus()}</p>
                <div class="divbox2p">
                    <div>
                         <img src="/img/RType/${item.getRoomType().getRoomTypeImage()}" alt="">
                    </div>
                    <div>
                        <p>${item.getRoomType().getRoomTypeName()}</p>
                        <p>含早餐|免费WiFi</p>
                    </div>
                    <div>
                        <p>￥</p>
                        <p style="text-decoration:line-through;">￥500</p>
                    </div>
                </div>
                <p><input type="hidden" name="roomId" value="${item.getRoomId()}"></p>
                <p>押金：<input name="unsubscribeForegift" value="${item.getReservationForegift()}"/></p>
                <p class="reId" >订单号:<input name="reservationId" value="${item.getReservationId()}"/></p>
                <div class="divbutton">
                    <a href="">联系商家</a>
                    <c:choose>
                        <c:when test="${item.getReservationStatus() == 1 || item.getReservationStatus()==2}">
                            <input class="canR" type="text" value="取消订单" >
                        </c:when>
                        <c:otherwise>
                            <button class="cancelR"> 取消订单</button>
                        </c:otherwise>
                    </c:choose>


                </div>

            </div>

            </form>
        </div>
    </div>

</c:forEach>

</div>
</body>
</html>
