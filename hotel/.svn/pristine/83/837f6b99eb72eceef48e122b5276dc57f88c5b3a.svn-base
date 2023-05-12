<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>会员客户消费记录</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/reservation/reservationOp.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
    <script>
        $(document).ready(function () {
            $(".dropdownMenu").dropdown();
            $(".nav-left-dropdown>a").click(function () {
                if ($(this).attr("d") != 1 && $(this).attr("d") != undefined) {
                    $(this).removeClass("nav-left-dropdown-a");
                    $this = $(this);
                    $(this).next("ul").slideUp(300, function () { $this.removeClass("nav-left-bottrom-border"); $this.removeClass("nav-left-dropdown-ul") });

                    $(this).attr("d", "1");

                } else {
                    $(this).addClass("nav-left-dropdown-a");
                    $(this).addClass("nav-left-bottrom-border");
                    $(this).next("ul").addClass("nav-left-dropdown-ul").slideDown(300);
                    $(this).attr("d", "2");

                }
            })
            var i = 2;
            $(".openNav").click(function(){
            	if(i % 2 ==0){
            		$(".navbtn").css("display","none");
                	$(".navbtns").css("display","block");
                	            	
            	}else{
            		$(".navbtns").css("display","none");
                	$(".navbtn").css("display","block");
            	}  
            	i++;  
            })
            var a = 2;
            $(".openNav1").click(function(){
            	if(a % 2 ==0){
            		$(".navbtn1").css("display","none");
                	$(".navbtns1").css("display","block");
                	            	
            	}else{
            		$(".navbtns1").css("display","none");
                	$(".navbtn1").css("display","block");
            	}  
            	a++;  
            })
            
            $(".openDeleteReservation").click(function(){
            	$(".deleteReservation").css("display","block");
            	var v_id = $(this).attr("id");
            	$("#okDeleteReservation").attr('href',"/deleteUserConsumptionRecord?userConsumptionRecordId="+v_id);
            })
            $(".closeDeleteReservation").click(function(){
            	$(".deleteReservation").css("display","none");
            })
        });
    </script>
</head>
<body style="min-height:635px;">
<div class="container-fluid">

        <nav class="navbar navbar-default row no-yj  navbar-fixed-top">
            <div class="container-fluid">
                <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#nav-list-left" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
                    <a class="navbar-brand" href="#">warada酒店管理系统</a>
                </div>
                
            </div>
        </nav>
        <div class="row" style="margin-top:70px">
            <div class="  nav-left col-md-2 no-padding" id="nav-list-left">
                <div class="user-panel">
                    <img src="${pageContext.request.contextPath}/img/userimg.jpg" class="img-circle center-block" />
                </div>

                <div class="nav-list" >
                   <ul>
                        <li>
                            <a href="${pageContext.request.contextPath}/toPage/index/index">首页</a>
                        </li>
                        <li class="nav-left-dropdown">
                            <a href="#" class="openNav">
                            	&nbsp&nbsp&nbsp&nbsp会员客户管理
                            	<span class="glyphicon glyphicon-option-horizontal navbtn"></span>
                            	<span class="glyphicon glyphicon-option-vertical navbtns"></span>
                            </a>
                            <ul class="nav-left-dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/showAllUsers/1">会员列表</a></li>
                                <li><a href="${pageContext.request.contextPath}/showAllUserConsumptionRecord/1">消费查询</a></li>
                               
                            </ul>
                        </li>
                        <li class="nav-left-dropdown">
                            <a href="#" class="openNav1">
                            	&nbsp&nbsp&nbsp&nbsp普通客户管理
                            <span class="glyphicon glyphicon-option-horizontal navbtn1"></span>
                            <span class="glyphicon glyphicon-option-vertical navbtns1"></span>
                            </a>
                            <ul class="nav-left-dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/showAllClient/1">客户列表</a></li>
                                <li><a href="${pageContext.request.contextPath}/showAllClientConsumptionRecord/1">消费查询</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="main-right  col-md-10 col-md-offset-2 bodys">
                        <div class="panel-body navs">
                            <ol class="breadcrumb">
                                <li><a href="${pageContext.request.contextPath}/toPage/index/index">首页</a></li>
                                <li><a href="${pageContext.request.contextPath}/showAllUserConsumptionRecord/1">会员客户消费记录</a></li>
                            </ol>
                        </div>            
          	<div class="col-md-12">
                    <div class="panel panel-default tableTitle">
                        <div class="panel-heading">
                          	搜索会员：
                          	<form action="${pageContext.request.contextPath}/showAllUsersIdConsumptionRecord/1" method="post">  
                       		<div class="input-group shouUsers">       
									              
                                    <input type="text" class="form-control shouUsersInp" name="userRealName" placeholder="请输入会员名、账号、身份证号、手机号..." />
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="submit">搜索</button>
                                    </span>
                                    
                                </div>
                                </form> 
                                
                        </div>
                        <div class="panel-body">
                            <table class="table table-bordered tb-hover">
                                <thead>
                                    <tr>
                                    	<td>姓名</td>                                       
                                        <td>身份证号</td>                                        
                                        <td>手机号</td>
                                        <td>消费时间</td>
                                        <td>消费金额</td>
                                        <td>结算方式</td>
                                        <td>操作人</td>
                                        <td class="text-center">操作</td>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:if test="${requestScope.userConsumptionRecords.size() >0}">
                                	<c:forEach items="${requestScope.userConsumptionRecords}" var="userConsumptionRecords">
                                    <tr class="users">                                                                
                                        <td class="userRealName">${userConsumptionRecords.userRealName}</td>
                                        <td class="userVipId">${userConsumptionRecords.userIdCard}</td>
                                        <td class="userIdCard">${userConsumptionRecords.userPhone}</td>                                        
                                        <td class="userPhone">${userConsumptionRecords.userConsumptionTime}</td>
                                        <td class="userPhone">${userConsumptionRecords.userConsumptionMoney}</td>
                                        <c:if test="${userConsumptionRecords.userConsumptionManner == 0}">
                                        	<td class="userGender">现金支付</td>
                                        </c:if>
                                        <c:if test="${userConsumptionRecords.userConsumptionManner == 1}">
                                        	<td class="userGender">扫码支付</td>
                                        </c:if>
                                        <c:if test="${userConsumptionRecords.userConsumptionManner == 2}">
                                        	<td class="userGender">刷卡支付</td>
                                        </c:if>
                                        <td class="userPhone">${userConsumptionRecords.staffName}</td>
                                        <td class=" text-center">                                                                        
                                        &nbsp;&nbsp;<i title="删除记录"  id="${userConsumptionRecords.userConsumptionRecordId}" class="glyphicon glyphicon-remove openDeleteReservation"></i></td>
                                    </tr>
                                    </c:forEach>
                                    </c:if>
                                </tbody>
                            </table>
                        </div>
                        <!-- 分页 -->
                        <div class="panel-body spligs">
                            <nav>
                                <ul class="pagination">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/showAllUserConsumptionRecord/${requestScope.nowPage -1}" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                  <c:forEach begin="${requestScope.beginPage}" end="${requestScope.endPage}" var="showPage"> 
								 <c:if test="${requestScope.nowPage == showPage}">	 
							    <li>				    		                       
							    <a style="background:#e7e7e7" href="/showAllUserConsumptionRecord/${showPage}">${showPage}</a>				    			    
							    </li>
							    </c:if>	
							     <c:if test="${requestScope.nowPage != showPage}">	 
							    <li>				    		                       
							    <a href="/showAllUserConsumptionRecord/${showPage}">${showPage}</a>				    			    
							    </li>
							    </c:if>	
							    </c:forEach>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/showAllUserConsumptionRecord/${requestScope.nowPage +1}" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                
                <!-- 删除记录 -->
                <div class="col-md-6 deleteReservation">
               <div class="panel panel-default ">
                   <div class="panel-heading">系统提示</div>
                   <div class="panel-body">
                           <div class="form-group deleteReservationInp">
                               <label for="exampleInputEmail1">是否删除该消费记录？</label>
                           </div>                       
                           <a  href="#" id="okDeleteReservation" class="btn btn-default">确认</a>
                           <span class="btn btn-default closeDeleteReservation">取消</span>
		                   </div>
		               </div>
		           </div> 
            </div>
         </div>
    </div>
    
</body>
</html>