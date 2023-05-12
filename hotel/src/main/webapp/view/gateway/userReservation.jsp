<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>预订客房</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/gateway/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/gateway/font-awesome.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/gateway/jquery.bxslider.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/gateway/jquery.fancybox.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/gateway/jquery.mCustomScrollbar.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/gateway/strock-icon.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/gateway/default.css" rel="stylesheet">
<!-- strock gap icons -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/gateway/style1.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/gateway/animate.min.css">
<!--    owl-carousel-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/gateway/owl.carousel.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/gateway/jquery-ui.min.css"> 
<!-- Main Css  -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/gateway/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/gateway/responsive.css"> 	 
<link rel="icon" type="image/png" sizes="16x16" href="img/favicon-16x16.png">
</head>
<body>
<section class="top-bar dhomev">
        <div class="container">
            <div class="pull-left left-infos contact-infos">




                <c:choose>
                    <c:when test="${sessionScope.customer == null}">

                        <c:choose>
                            <c:when test="${sessionScope.loginKey == 0}">
                                <ul class="list-inline">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/view/gateway/userLogin.jsp">登录</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/view/gateway/userRegist.jsp">注册</a>
                                    </li>
                                </ul>
                            </c:when>
                            <c:when test="${sessionScope.loginKey ==1}">
                                <ul class="list-inline">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/view/gate/clientLogin.jsp">登录</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/view/gate/clientRegist.jsp">注册</a>
                                    </li>
                                </ul>
                            </c:when>
                        </c:choose>

                    </c:when>



                    <c:when test="${sessionScope.customer != null }">

                        <c:choose>
                            <c:when test="${sessionScope.loginKey == 0}">
                                <ul class="list-inline">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/view/gateway/userLogin.jsp">欢迎！${sessionScope.customer.userRealName}</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/userCancellation">注销</a>
                                    </li>
                                </ul>
                            </c:when>
                            <c:when test="${sessionScope.loginKey == 1}">

                                <ul class="list-inline">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/view/gate/clientLogin.jsp">欢迎！${sessionScope.customer.clientName}</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/clientCancellation">注销</a>
                                    </li>
                                </ul>
                            </c:when>
                        </c:choose>

                    </c:when>
                </c:choose>




            </div><!-- /.pull-right right-infos link-list -->
        </div><!-- /.container -->
    </section><!-- /.top-bar -->
    
    <nav class="navbar navbar-default  _fixed-header _light-header stricky" id="main-navigation-wrapper">
        <div class="container">
            <div class="navbar-header">
              <a href="${pageContext.request.contextPath}/gatewayShowAllRoomType/0" class="navbar-brand">
                    <img alt="Awesome Image" src="${pageContext.request.contextPath}/img/gateway/logo2.png">
                </a>
            </div>
            <div class="collapse navbar-collapse" id="main-navigation">
                <ul class="nav navbar-nav ">
                    <li>
                    	<a href="${pageContext.request.contextPath}/gatewayShowAllRoomType/0" class="dropdown-toggle" >首页<span class="glyphicon glyphicon-chevron-down"></span></a>						
					</li>                              
                </ul>               
            </div>
        </div>
    </nav>
    
  
 <!-- Header  Inner style-->
<section class="row final-inner-header" style="background: url(${pageContext.request.contextPath}/img/gateway/inner-header2.jpg) no-repeat scroll center bottom">
 	<div class="container" >
 		<h2 class="this-title">${requestScope.roomType.roomTypeName}</h2>
 	</div>
 </section>
 <section class="row final-breadcrumb">
 	<div class="container">
 		<ol class="breadcrumb">
 			<li><a href="${pageContext.request.contextPath}/gatewayShowAllRoomType/0">首页</a></li>
 			<li class="active">${requestScope.roomType.roomTypeName}</li>
 		</ol>
 	</div>
 </section>
<!-- Header  Slider style-->
    

<!-- News style-->
  <section class="container clearfix common-pad-inner">
   <div class="row">
      <div class="col-md-4 col-md-push-8">
       
          <div class="single-sidebar-widget sroom-sidebar">         
              
              <!-- Booking Form style-->
              <div class="book-r-form">
              
                  <div class="room-price">
                  <h6>从...开始</h6>
                  <p>$${roomType.listPrice}<span>/ 天</span></p>                 
                  </div>                
                  <div class="book-form">
                  <form action="${pageContext.request.contextPath}/userReservation">
                  <input type="hidden" name="roomTypeId" value="${requestScope.roomType.roomTypeId}">
                  <div class="col-md-12" style="margin-bottom: 10px;">
                  <b>到达</b>
                  <input class="form-control expectedTimeOfArrival upTime"  name="expectedTimeOfArrival" type="datetime-local">
                  </div>
                  <div class="col-md-12" style="margin-bottom: 10px;">
                  <b>离开</b>
                      <input class="form-control estimatedTimeOfDeparture outTime " min="2023-04-10T00:00" name="estimatedTimeOfDeparture"  type="datetime-local">
                  </div>
                  <div class="col-md-12" style="margin-bottom: 10px;">
                  <b>入住天数</b>
                  <input type="text" class="form-control reservationOccupancyDays UpOutTime" name="reservationOccupancyDays"/>
                  </div>

                  <div class="col-md-12" style="margin-bottom: 10px;">
                      <b>支付方式</b>
                      <div class="select-box">
                      <select class="select-menu" name="selectMenu">
                     			<option value="0">到付</option>	
                                <option value="1">现付</option>
                            </select>
                      </div>
                  </div>

                  <div class="col-md-12"><div class="chk-button">
                  <button type="submit" class="res-btn">预订房间</button>
                  </div></div>
                  </form>
                  </div>
              
              </div>
              <!-- Booking Form style-->
              
             
              
              <!-- Budget Rooms style-->
             <div class="single-sidebar-widget-outer">
              <div class="sec-title">
						<h2>其他客房</h2>
					</div>
                <div class="popular-post" >
						<ul style="height: 558px;overflow: auto;">
						<c:if test="${requestScope.roomTypes.size() > 0}">
						<c:if test="${requestScope.roomTypes != null}">
						<c:forEach items="${requestScope.roomTypes}" var="roomTypes">
							<li class="img-cap-effect">
								<div class="img-box">
                                    <a href="${pageContext.request.contextPath}/gatewayShowAllRoomType/${roomTypes.roomTypeId}"><img src="${pageContext.request.contextPath}/img/RType/${roomTypes.roomTypeImage}" style="width: 120px;height: 92px;" alt=""/></a>
								</div>
								<div class="content">
									<a href="${pageContext.request.contextPath}/gatewayShowAllRoomType/${roomTypes.roomTypeId}"><h4>${roomTypes.roomTypeName}</h4></a>
									<h6>$${roomTypes.listPrice} <span>每晚</span></h6>
								</div>
							</li>
							</c:forEach>
						   </c:if>
						   </c:if>
						</ul>
					</div> 
              </div>
              <!-- Budget Rooms style-->
              
              
              
          </div>
        
       </div>
      
      <div class="col-md-8 col-md-pull-4">
       
       <div class="single-room-wrapper">
         <!-- Rooms Slider style-->
          <div class="room-slider-wrapper">
           <div class="single-r-wrapper">
              <div class="single-sl-room">
             <div class="owl-itemm" data-hash="zero"><img src="${pageContext.request.contextPath}/img/${requestScope.roomType.roomTypeImage}" alt=""></div>
             <div class="owl-itemm" data-hash="one"><img src="${pageContext.request.contextPath}/img/${requestScope.roomType.roomTypeImage}" alt=""></div>
              <div class="owl-itemm" data-hash="two"><img src="${pageContext.request.contextPath}/img/${requestScope.roomType.roomTypeImage}" alt=""></div>
                  <div class="owl-itemm" data-hash="three"><img src="${pageContext.request.contextPath}/img/${requestScope.roomType.roomTypeImage}" alt=""></div>
               <div class="owl-itemm" data-hash="four"><img src="${pageContext.request.contextPath}/img/${requestScope.roomType.roomTypeImage}" alt=""></div>   
            </div>  
             
          <a class="button secondary url" href="#zero"><img src="${pageContext.request.contextPath}/img/gateway/roomsgallery3.jpg" alt=""></a> 
          <a class="button secondary url" href="#one"><img src="${pageContext.request.contextPath}/img/gateway/roomsgallery2.jpg" alt=""></a> 
          <a class="button secondary url" href="#two"><img src="${pageContext.request.contextPath}/img/gateway/roomsgallery4.jpg" alt=""></a> 
          <a class="button secondary url" href="#three"><img src="${pageContext.request.contextPath}/img/gateway/roomsgallery5.jpg" alt=""></a> 
          <a class="button secondary url" href="#four"><img src="${pageContext.request.contextPath}/img/gateway/roomsgallery6.jpg" alt=""></a> 
                  
               </div>
              
              </div>
           
          <!-- Rooms Slider style-->
           
           <!-- Description of Room style-->
           <div class="room-overview">
           <h2>房间概况</h2>
           
               <div class="table-responsive"> <table class="table table-striped"> <colgroup> <col class="col-xs-1"> <col class="col-xs-7"> </colgroup><tbody>
                   <tr> <th scope="row"> <code>名称:</code> </th> <td>${roomType.roomTypeName}</td> </tr>
                   <tr> <th scope="row"> <code>面积 : </code> </th> <td>${roomType.roomTypeArea}</td> </tr>
                   <tr> <th scope="row"> <code>状态 :</code> </th>
                   <c:if test="${roomType.roomTypeStatus ==0}">
                  		 <td>有房</td> 
                   </c:if>
                    <c:if test="${roomType.roomTypeStatus ==1}">
                  		 <td>房源紧张</td> 
                   </c:if>
                   <c:if test="${roomType.roomTypeStatus ==2}">
                  		 <td>客满</td> 
                   </c:if>                    
                    </tr>
                   <tr><th scope="row"> <code>押金 :</code> </th> <td>${roomType.reservationForegift}</td></tr>
                   <tr> <th scope="row"> <code>挂牌价 :</code> </th> <td>${roomType.listPrice}</td> </tr>
                   <tr> <th scope="row"> <code>散客价 :</code> </th> <td>${roomType.individualPrice}</td> </tr>
                   <tr> <th scope="row"> <code>会员价 :</code> </th> <td>${roomType.vipPrice}</td> </tr>
                   
                   </tbody> </table> </div>      
           </div>
           <!-- Description of Room style-->
           
           <!-- Room Facilities style-->
           <div class="room-fac-wrapper">
           <h2>客房设施</h2>
              <div class="row">
               <div class="ro-facilitie">
               <ul class="clearfix">
               <li><div class="facilitie-i-box">
                           <h3>液晶电视</h3>
                           <span><img src="${pageContext.request.contextPath}/img/gateway/icon1.gif" alt=""></span>
                       </div>
                   </li>
               <li><div class="facilitie-i-box">
                           <h3>早餐</h3>
                           <span><img src="${pageContext.request.contextPath}/img/gateway/icon2.gif" alt=""></span>
                       </div>
                   </li>
                   <li><div class="facilitie-i-box">
                           <h3>免费停车场</h3>
                           <span><img src="${pageContext.request.contextPath}/img/gateway/icon3.gif" alt=""></span>
                       </div>
                   </li>
                   <li><div class="facilitie-i-box">
                           <h3>wi-fi 服务</h3>
                           <span><img src="${pageContext.request.contextPath}/img/gateway/icon4.gif" alt=""></span>
                       </div>
                   </li>
                   <li><div class="facilitie-i-box">
                           <h3>空调房</h3>
                           <span><img src="${pageContext.request.contextPath}/img/gateway/icon5.gif" alt=""></span>
                       </div>
                   </li>
               
               </ul>
               </div>
                  </div>
               
               
           </div>
           <!-- Room Facilities style-->
           
           <!-- Room Overview style-->
           
           
           <!-- Room Overview style-->
          
           
           
          </div>
       </div>
      
      </div>
   </section> 
    
 <!-- footer  style-->
  
  <footer>
<section class="container clearfix footer-b-pad">
<div class="footer-copy"><div class="pull-left fo-txt">
           <p>Copyright (c) Resort and Hotel 2016. All rights reserved. </p>
       </div>
<div class="pull-right fo-txt">
           <p>Created by: <a href="http://www.htmlsucai.com">DesignArc</a></p>
       </div>
</div>
</section> 
</footer>   
 <!-- footer  style-->
 
<script src="${pageContext.request.contextPath}/js/gateway/jquery-2.2.4.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/gateway/jquery.bxslider.js"></script>
<!-- owl carousel  -->   
<script src="${pageContext.request.contextPath}/js/gateway/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/js/gateway/jquery.easing.min.js"></script>
<script src="${pageContext.request.contextPath}/js/gateway/jquery.mCustomScrollbar.concat.min.js"></script>
<script src="${pageContext.request.contextPath}/js/gateway/zebra_datepicker.js"></script>
<!-- jQuery ui js -->
<script src="${pageContext.request.contextPath}/js/gateway/jquery.mixitup.min.js"></script>
<script src="${pageContext.request.contextPath}/js/gateway/jquery.fancybox.pack.js"></script>    
 <script src="${pageContext.request.contextPath}/js/gateway/jquery-ui.min.js"></script>   
<script src="${pageContext.request.contextPath}/js/gateway/custom.js"></script>


<script type="text/javascript" src="/js/TimeDifference.js"></script>
</body>
</html>