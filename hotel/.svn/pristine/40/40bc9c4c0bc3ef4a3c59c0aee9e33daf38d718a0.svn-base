<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>收入报表</title>
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
            	$("#okDeleteReservation").attr('href',"/deleteReservation?reservationId="+v_id);
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
                        <li>
                            <a href="${pageContext.request.contextPath}/showIncomeList/1">收入报表</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/view/income/occupancyRate.jsp">入住率分析</a>
                        </li>
                        <li>
                            <a href="${pageContext.request.contextPath}/view/income/incomeAnalysis.jsp">收入分析</a>
                        </li>                                        
                    </ul>
                </div>
            </div>
            <div class="main-right  col-md-10 col-md-offset-2 bodys">
                        <div class="panel-body navs">
                            <ol class="breadcrumb">
                                <li><a href="${pageContext.request.contextPath}/toPage/index/index">首页</a></li>
                                <li><a href="${pageContext.request.contextPath}/showIncomeList/1">收入报表</a></li>
                                <li><a href="${pageContext.request.contextPath}/showIncomeListDate/1">今日收入</a></li>
                            </ol>
                        </div>            
          	<div class="col-md-12">
                    <div class="panel panel-default tableTitle">
                        <div class="panel-heading" style="padding: 3px 0px 3px 0px;">
                          	<div class="input-group" style="float: left;">                          		
                       		<a href="${pageContext.request.contextPath}/showIncomeListDate/1" class="btn btn-default">今日收入</a>
                       		</div>                           
                            <div class="input-group" style="float: left;width: 480px;line-height: 35px;">
                            <form action="${pageContext.request.contextPath}/showIncomeListStartAndStopDates/1">
                            <span style="float: left;">按日期查询：</span>
                            	<span style="float: left;">起：</span><input type="date" name="startDates" class="form-control dates" style="float: left;width: 140px;">
                            	<span style="float: left;">止：</span><input type="date" name="stopDates" class="form-control dates" style="float: left;width: 140px;">
                            	<button style="float: left;" class="btn btn-default okYears" type="submit">查询</button>
                            </form>
                            </div>
                            <div class="input-group" style="float: left;width: 260px;line-height: 35px;">
                            <form action="${pageContext.request.contextPath}/showIncomeListMonth/1">
                            <span style="float: left;">按月份查询</span>
                            <input type="month" name="months" class="form-control yearAndDates" style="float: left;width: 135px;">
                            <button class="btn btn-default okYears" type="submit" style="float: left;">查询</button>
                             </form>
                            </div>
                            <div class="input-group" style="width: 270px;line-height: 35px;">
                            <form action="${pageContext.request.contextPath}/showIncomeListYear/1">
                            <span style="float: left;">按年份查询</span>
                            <input type="text" name="years" class="form-control years"style="width: 145px;" placeholder="请输入查询的年份...">
                           	<button class="btn btn-default okYears" type="submit" style="float: left;">查询</button>
                           	</form>
                            </div>
                        </div>               
                        <div class="panel-body">
                            <table class="table table-bordered tb-hover">
                                <thead>
                                    <tr>
                                    	<td>房间类型</td>
										<td>收入金额</td>
										<td>收入类型</td>
										<td>支付方式</td>
										<td>收入时间</td>
										<td>操作人</td>
                                        <td class="text-center">操作</td>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:if test="${requestScope.incomes.size() >0}">
                                	<c:forEach items="${requestScope.incomes}" var="incomes">
                                    <tr class="users">                                                                
                                        <td class="userRealName">${incomes.roomtypeName}</td>
                                        <td class="userVipId">${incomes.incomeMoney}</td>
                                        <c:if test="${incomes.incomeType == 0}">
                                        <td class="userIdCard">房费收入</td>  
                                        </c:if>
                                        <c:if test="${incomes.incomeType == 1}">
                                        <td class="userIdCard">押金收入</td>  
                                        </c:if>
                                        <c:if test="${incomes.paymentMethod == 0}">
                                        	<td class="userPhone">现金支付</td>  
                                        </c:if> 
                                        <c:if test="${incomes.paymentMethod == 1}">
                                        	<td class="userPhone">扫码支付</td>  
                                        </c:if> 
                                        <c:if test="${incomes.paymentMethod == 2}">
                                        	<td class="userPhone">刷卡支付</td>  
                                        </c:if>                                       
                                        
                                        <td class="userPhone">${incomes.incomeTime}</td>
                                        <td class="userPhone">${incomes.staffName}</td>
                                        <td class=" text-center">
                                      &nbsp;&nbsp;<i title="删除记录"  id="${incomes.incomeId}" class="glyphicon glyphicon-remove openDeleteReservation"></i></td>
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
                                        <a href="${pageContext.request.contextPath}/showIncomeListDate/${requestScope.nowPage -1}" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                  <c:forEach begin="${requestScope.beginPage}" end="${requestScope.endPage}" var="showPage"> 
								 <c:if test="${requestScope.nowPage == showPage}">	 
							    <li>				    		                       
							    <a style="background:#e7e7e7" href="/showIncomeListDate/${showPage}">${showPage}</a>				    			    
							    </li>
							    </c:if>	
							     <c:if test="${requestScope.nowPage != showPage}">	 
							    <li>				    		                       
							    <a href="/showIncomeListDate/${showPage}">${showPage}</a>				    			    
							    </li>
							    </c:if>	
							    </c:forEach>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/showIncomeListDate/${requestScope.nowPage +1}" aria-label="Next">
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
                               <label for="exampleInputEmail1">是否删除该收入记录？</label>
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