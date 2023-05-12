<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客房管家</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/room/roomOp.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/room/room.js"></script>  
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
                <div class="collapse navbar-collapse pull-right" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li><a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-bell"><i class="label label-warning label-nav">66</i></i></a>
                            <ul class="dropdown-menu dropdown-menu-right">
                                <li><a href="#">哈哈哈</a></li>
                            </ul>
                        </li>
                        <li><a class="dropdown-toggle" data-toggle="dropdown" href="#"><i class="glyphicon glyphicon-envelope"><i class="label label-success label-nav">6</i></i></a>

                            <ul class="dropdown-menu dropdown-menu-right">
                                <li><a href="#">哈哈哈</a></li>
                            </ul>
                        </li>
                        <li><a class="dropdown-toggle" data-toggle="dropdown" href="#" style="height: 50px">
                            <img class="img-circle pull-left img-responsive nav-user-img" src="${pageContext.request.contextPath}/img/userimg.jpg" /><span class="pull-left nav-username">管理员</span></a>

                            <ul class="dropdown-menu dropdown-menu-right clearfix" style="padding-top: 0px">
                                <li class="user-li-head"><span>
                                    <img class="img-circle nav-user-img-xiala center-block" src="${pageContext.request.contextPath}/img/userimg.jpg" /></span>
                                    <p></p>
                                    <p class="text-center"><span>网络部 - 网络工程师</span></p>
                                    <p class="text-center"><span>远一博</span> </p>
                                    <p class="text-center"><small><span>2015-04-23加入</span></small></p>
                                </li>
                                <li style="padding: 10px 20px; padding-bottom: 20px">

                                    <div class="pull-left">
                                        <a href="#" class="btn btn-default btn-flat no-yj">资料</a>
                                    </div>
                                    <div class="pull-right">
                                        <a href="${pageContext.request.contextPath}/staffCancellation" class="btn btn-default btn-flat no-yj">注销</a>
                                    </div>
                                </li>
                                </ul>
                        </li>
                    </ul>
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
                            	&nbsp&nbsp&nbsp&nbsp房间类型管理
                            	<span class="glyphicon glyphicon-option-horizontal navbtn"></span>
                            	<span class="glyphicon glyphicon-option-vertical navbtns"></span>
                            </a>
                            <ul class="nav-left-dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/showAllRoomType/0">房间类型列表</a></li>
                                <li><a href="${pageContext.request.contextPath}/showAllRoomType/1">编辑房型</a></li>
                            </ul>
                        </li>
                        <li class="nav-left-dropdown">
                            <a href="#" class="openNav1">
                            	&nbsp&nbsp&nbsp&nbsp客房管理
                            <span class="glyphicon glyphicon-option-horizontal navbtn1"></span>
                            <span class="glyphicon glyphicon-option-vertical navbtns1"></span>
                            </a>
                            <ul class="nav-left-dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/showAllUsers/1">编辑客房</a></li>
                                <li><a href="#" class="openNewRoomType">新增客房</a></li>
                            </ul>
                        </li>
                        <li class="nav-left-dropdown">
                            <a href="#" class="openNav1">
                            	&nbsp&nbsp&nbsp&nbsp预订记录管理
                            <span class="glyphicon glyphicon-option-horizontal navbtn1"></span>
                            <span class="glyphicon glyphicon-option-vertical navbtns1"></span>
                            </a>
                            <ul class="nav-left-dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/showAllReservation/1">所有预订记录</a></li>
                                <li><a href="${pageContext.request.contextPath}/showAllCheckInReservation/1">已入住预订记录</a></li>
                                <li><a href="${pageContext.request.contextPath}/showAllNoCheckInReservation/1">预订中记录</a></li>
                                <li><a href="${pageContext.request.contextPath}/showAllUnsubscribeReservation/1">退订记录</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="main-right  col-md-10 col-md-offset-2 bodys">
                        <div class="panel-body navs">
                            <ol class="breadcrumb">
                                <li><a href="${pageContext.request.contextPath}/toPage/index/index">首页</a></li>
                                <li><a href="${pageContext.request.contextPath}/showAllRoomType/0">房间类型列表</a></li>                       		
								<li><a href="#">房间状态</a></li>
								
                            </ol>
                        </div>         
                        		<form action="${pageContext.request.contextPath}/inputShowRoom">     
                                <div class="input-group showRoomInp">                                                             
                                    <input type="text" class="form-control" name="roomNumber" placeholder="请输入房间号..." />
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="submit">搜索房间</button>
                                    </span>                                  
                                </div>  
                                 </form>                       
                        <div class="romTypeList">                                             	
                        	 <c:forEach items="${requestScope.rooms}" var="rooms">
                        	<c:if test="${rooms.roomSanitation == 0 && rooms.roomStatus == 0}">
                        	<div class="romTypeList_a" style="background: #daF0c8">
                        	<p class="roomFunction">
                        	<a href="#" class="openReservation" id="${rooms.roomId}" a="${rooms.roomNumber}">预订</a>
							<a href="#" class="openCheckIn" id="${rooms.roomId}" a="${rooms.roomNumber}" c="${rooms.roomTypeId}">入住</a>
							<a href="#" class="openLogistics" id="${rooms.roomId}" a="${rooms.roomTypeId}" c="${rooms.roomNumber}" b="${rooms.roomSanitation}">后勤</a>
							<a href="#" id="${rooms.roomId}" class="openRoomDetail">明细</a>						
                        	</p>
                        	<b>${rooms.roomNumber}</b>
                        	<span class="struts_logo">空</span>
                        	</div> 
                        	</c:if>      
                        	<c:if test="${rooms.roomSanitation == 0 && rooms.roomStatus == 1}">
                        	<div class="romTypeList_a" style="background: #D9EDF7">
                        	<p class="roomFunction">
                        	<a href="#" class="openUnsubscribe" id="${rooms.roomId}">退订</a>
							<a href="#" class="openCheckIn" id="${rooms.roomId}" a="${rooms.roomNumber}" b="1" c="${rooms.roomTypeId}">入住</a>
							<a href="#" class="openReservationDetail" id="${rooms.roomId}">房客</a>
							<a href="#" id="${rooms.roomId}" class="openRoomDetail">明细</a>						
                        	</p>
                        	<b>${rooms.roomNumber}</b>
                        	<span class="struts_logo">订</span>
                        	</div> 
                        	</c:if>
                        	<c:if test="${rooms.roomSanitation == 0 && rooms.roomStatus == 2}">
                        	<div class="romTypeList_a" style="background: #5ca99e">
                        	<p class="roomFunction">
                        	<a href="#" class="openContinued" id="${rooms.roomId}" c="${rooms.roomTypeId}">续住</a>
							<a href="#" class="openCheckOut" id="${rooms.roomId}" c="${rooms.roomTypeId}">退房</a>
							<a href="#" class="openShowCheckIn" id="${rooms.roomId}">房客</a>
							<a href="#" id="${rooms.roomId}" class="openRoomDetail">明细</a>						
                        	</p>
                        	<b>${rooms.roomNumber}</b>
                        	<span class="struts_logo">客</span>
                        	</div>
                        	</c:if>
                        	<c:if test="${rooms.roomSanitation == 1}">
                        	<div class="romTypeList_a" style="background: #e89279">
                        	<p class="roomFunction">
							<a href="#" class="openLogistics" id="${rooms.roomId}" a="${rooms.roomTypeId}" b="${rooms.roomSanitation}" c="${rooms.roomNumber}">后勤</a>
							<a href="#" id="${rooms.roomId}" class="openRoomDetail">明细</a>						
                        	</p>
                        	<b>${rooms.roomNumber}</b>
                        	<span class="struts_logo">脏</span>
                        	</div> 
                        	</c:if>
                        	<c:if test="${rooms.roomSanitation == 2}">
                        	<div class="romTypeList_a" style="background: #E96060">
                        	<p class="roomFunction">
							<a href="#" class="openLogistics" id="${rooms.roomId}" a="${rooms.roomTypeId}" b="${rooms.roomSanitation}">后勤</a>
							<a href="#" id="${rooms.roomId}" class="openRoomDetail">明细</a>						
                        	</p>
                        	<b>${rooms.roomNumber}</b>
                        	<span class="struts_logo">修</span>
                        	</div>  
                        	</c:if>                	
                        	</c:forEach>                
                        </div>
                        <!-- 新增客房 -->
                        <div class="col-md-6 newRoomType">
                    	<div class="panel panel-default ">
                        <div class="panel-heading " style="text-align: center;">新增客房</div>
                        <div class="panel-body">
                            <form action="${pageContext.request.contextPath}/newRoom" method="post">
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">类型名</label>
									<select name="roomTypeId" class="form-control">
                                    	<option value="${roomType.roomTypeId}">${roomType.roomTypeName}</option>
                                    </select>                              
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">房间号</label>
                                    <input type="text" name="roomNumber" class="form-control" id="exampleInputEmail1" placeholder="请输入房间号..." />
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">客房状态</label>
                                    <select name="roomStatus" class="form-control">
                                    	<option value="0">空闲</option>
                                    	<option value="1">已预订</option>
                                    	<option value="2">已入住</option>
                                    </select>
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">客房情况</label>
                                    <select name="roomSanitation" class="form-control">
                                    	<option value="0">已打扫</option>
                                    	<option value="1">未打扫</option>
                                    	<option value="2">维修中</option>
                                    </select>
                                    
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">楼层</label>
                                    <input type="text" name="roomStorey" class="form-control" id="exampleInputEmail1" placeholder="请输入房间所属楼层..." />
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">窗型</label>
                                    <select name="roomWindow" class="form-control">
                                    	<option value="0">有窗</option>
                                    	<option value="1">无窗</option>
                                    </select>
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">床型</label>
                                    <input type="text" name="roomBed" class="form-control" id="exampleInputEmail1" placeholder="请输入房间床型..." />
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">可入住人数</label>
                                    <select name="roomGuestNumber" class="form-control">                                  	
                                    	<option value="1">1</option>
                                    	<option value="2">2</option>
                                    	<option value="3">3</option>
                                    	<option value="4">4</option>
                                    	<option value="0">不限</option>
                                    </select>
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">房间设施</label>
                                    <textarea name="roomFacility" class="form-control" placeholder="请输入客房设施..." ></textarea>
                                </div>
                                <div class="newRoomTypeFooter">
                                <button type="submit" class="btn btn-default btns">提交</button>
                                <button type="button" class="btn btn-default btns closeNewRoomType">取消</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div> 
                <!-- 房间明细 -->
                 <div class="col-md-6 roomDetail">
                    	<div class="panel panel-default ">
                        <div class="panel-heading " style="text-align: center;">客房详情</div>
                        <div class="panel-body">
                            <form>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">类型名</label>
                                    <input type="text" name="roomNumber" class="form-control roomTypeNameDetail"/>                             
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">房间号</label>
                                    <input type="text" name="roomNumber" class="form-control roomNumberDetail"/>
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">客房状态</label>
                                    <input type="text" name="roomNumber" class="form-control roomStatusDetail"/>
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">客房情况</label>
                                    <input type="text" name="roomNumber" class="form-control roomSanitationDetail"/>
                                    
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">楼层</label>
                                    <input type="text"class="form-control roomStoreyDetail" />
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">窗型</label>
                                    <input type="text" name="roomNumber" class="form-control roomWindowDetail"/>
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">床型</label>
                                    <input type="text" class="form-control roomBedDetail"/>
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">可入住人数</label>
                                    <input type="text" name="roomNumber" class="form-control roomGuestNumberDetail"/>
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">房间设施</label>
                                    <textarea class="form-control roomFacilityDetail"></textarea>
                                </div>
                                <div class="newRoomTypeFooter">
                                <button type="button" class="btn btn-default btns openUpdateRoom">修改</button>
                                <button type="button" class="btn btn-default btns openDeleteRoom">删除</button>
                                <button type="button" class="btn btn-default btns closeRoomDetail">返回</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- 修改客房信息 -->
                        <div class="col-md-6 updateRoom">
                    	<div class="panel panel-default ">
                        <div class="panel-heading " style="text-align: center;">修改客房信息</div>
                        <div class="panel-body">
                            <form action="${pageContext.request.contextPath}/updateRoom" method="post">
                            <input type="hidden" name="roomId" class="updateroomId">
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">类型名</label>
									<select name="roomTypeId" class="form-control updateroomTypeId">
                                    </select>                              
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">房间号</label>
                                    <input type="text" name="roomNumber" class="form-control updateroomNumber" placeholder="请输入房间号..." />
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">客房状态</label>
                                    <select name="roomStatus" class="form-control updateroomStatus">
                                    </select>
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">客房情况</label>
                                    <select name="roomSanitation" class="form-control updateroomSanitation">
                                    </select>                                   
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">楼层</label>
                                    <input type="text" name="roomStorey" class="form-control updateroomStorey" placeholder="请输入房间所属楼层..." />
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">窗型</label>
                                    <select name="roomWindow" class="form-control updateroomWindow">
                                    </select>
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">床型</label>
                                    <input type="text" name="roomBed" class="form-control updateroomBed" placeholder="请输入房间床型..." />
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">可入住人数</label>
                                    <select name="roomGuestNumber" class="form-control updateroomGuestNumber">                                  	
                                    </select>
                                </div>
                                <div class="form-group newRoomTypeInp">
                                    <label for="exampleInputEmail1">房间设施</label>
                                    <textarea name="roomFacility" class="form-control updateroomFacility" placeholder="请输入客房设施..." ></textarea>
                                </div>
                                <div class="newRoomTypeFooter">
                                <button type="submit" class="btn btn-default btns">提交</button>
                                <button type="button" class="btn btn-default btns closeUpdateRoom">取消</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- 删除客房 -->
                <div class="col-md-6 deleteRoom" >
               	<div class="panel panel-default deleteRoomBody">
                   <div class="panel-heading">系统提示</div>
                   <div class="panel-body">
                           <div class="form-group tips">
                               <label for="exampleInputEmail1">是否删除该客房？</label>
                           </div>                       
                           	<div class="deleteRoomFooter">
                           	<a  href="#" id="okDeleteRoom" class="btn btn-default btns">确认</a>
                           <span class="btn btn-default closeDeleteRoom btns">取消</span>
                           </div>
		                   </div>
		               </div>
		           </div>
		           <!-- 后勤管理 -->
		    <div class="col-md-6 logistics" >
                    <div class="panel panel-default ">
                        <div class="panel-heading">后勤管理</div>
                        <div class="panel-body">
                        <div class="btnMain">
							<button type="button" class="btn btn-default btns btns1">清洁登记</button>	
							<button type="button" class="btn btn-default btns btns2">维修登记</button>	
						</div>	
						<!-- 清洁登记 -->						
						<div class="from1">
                            <form action="${pageContext.request.contextPath}/clean" method="post">
                            	<div class="form-group logisticsInp">
                                    <label for="exampleInputEmail1">房间号</label>
                                    <input type="text" name="roomNumber" class="form-control roomNumberRoomSanitationInp" />
                                </div>
                                <div class="form-group logisticsInp">
                                    <label for="exampleInputEmail1">清洁登记</label>
                                    <select name="roomSanitation" class="form-control">
                                    	<option value="0">已打扫</option>
                                    	<option value="1">未打扫</option>
                                    </select>                                  
                                </div>
                                <div class="newRoomTypeFooter">
                                <button type="submit" class="btn btn-default btns okbtn">确认</button>
                                <span  class="btn btn-default btns closeLogistics">取消</span>
                                </div>
                            </form>
                            </div>
                            <!-- 维修登记 -->
                            <div class="from2">
                                <div class="maintainStatus0">
                                <form action="${pageContext.request.contextPath}/updateMaintain/0" method="post">
                            	<input type="hidden" name="roomId" class="roomIdRoomSanitation">
                            	<input type="hidden" name="staffId" value="${sessionScope.staff.staffId}">
                               <div class="form-group logisticsInp">
                                    <label for="exampleInputEmail1">完成维修登记</label>
                                    <select name="maintainStatus" class="form-control maintainStatus">
                                    	<option value="0" class="pdmaintainStatus">维修完成</option>
                                    </select>                                  
                                </div>
                                <div class="form-group logisticsInp">
                                    <label for="exampleInputEmail1">完成维修时间</label>
                                    <input type="text" name="maintainFinishTime" class="form-control maintainFinishTime" />
                                </div>
                                <div class="form-group logisticsInp">
                                    <label for="exampleInputEmail1">维修结果</label>
                                    <textarea name="maintainResult" class="form-control maintainResult"></textarea>
                                </div>
                                <div class="newRoomTypeFooter">
                                <button type="submit" class="btn btn-default btns okbtn">确认</button>
                                <span  class="btn btn-default btns closeLogistics">取消</span>
                                </div>
                                </form> 
                                </div>
                                <div class="maintainStatus2">
                                <form action="${pageContext.request.contextPath}/addMaintain" method="post">
                            	<input type="hidden" name="roomId" class="roomIdRoomSanitation">
                            	<input type="hidden" name="staffId" value="${sessionScope.staff.staffId}">
                               <div class="form-group logisticsInp">
                                    <label for="exampleInputEmail1">开始维修登记</label>
                                    <select name="maintainStatus" class="form-control maintainStatus">
                                    	<option value="2" class="pdmaintainStatus">维修中</option>                                   	
                                    </select>                                  
                                </div>
                                <div class="form-group logisticsInp">
                                    <label for="exampleInputEmail1">开始维修时间</label>
                                    <input type="text" name="maintainStartTime" class="form-control maintainFinishTime" />
                                </div>
                                <div class="form-group logisticsInp">
                                    <label for="exampleInputEmail1">维修原因</label>
                                    <textarea name="maintainCause" class="form-control maintainCause"></textarea>
                                </div>
                                <div class="newRoomTypeFooter">
                                <button type="submit" class="btn btn-default btns okbtn">确认</button>
                                <span  class="btn btn-default btns closeLogistics">取消</span>
                                </div>
                               </form> 
                                </div>
                            
                            </div>
                            
                        </div>
                    </div> 
                    </div>  
                  <!-- 预订登记 -->
               <div class="col-md-6 reservation">
                  	<div class="panel panel-default">
                      <div class="panel-heading " style="text-align: center;">预订登记</div>
                      <div class="panel-body">
                          <form action="${pageContext.request.contextPath}/reservation" method="post">
                          <input type="hidden" name="roomId" class="roomIdInp">
                         	 <input type="hidden" name="staffId" value="${sessionScope.staff.staffId}">
                         	 <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">房间号</label>
                                  <input type="text" name="roomId" class="form-control roomNumberInp"/>                             
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">姓名</label>
                                  <input type="text" name="reservationName" class="form-control roomTypeNameDetail"/>                             
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">身份证号</label>
                                  <input type="text" name="reservationIdCard" class="form-control roomNumberDetail"/>
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">电话号码</label>
                                  <input type="text" name="reservationPhoneNumber" class="form-control roomStatusDetail"/>
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">预订时间</label>
                                  <input type="text" name="reservationTime" class="form-control reservationTime"/>
                                  
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">预计到店时间</label>
                                  <input type="datetime-local" name="expectedTimeOfArrival"  class="form-control roomStoreyDetail" />
                              </div>
                              <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">结算方式</label>
                                <select name="paymentMethod" class="form-control">
                                  	<option value="0" class="pdmaintainStatus">现金支付</option>
                                  	<option value="1" class="pdmaintainStatus">扫码支付</option>
                                  	<option value="2" class="pdmaintainStatus">刷卡支付</option>                                   	
                                  </select>   
                            </div> 
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">入住天数</label>
                                  <input type="text" name="reservationOccupancyDays" class="form-control roomWindowDetail"/>
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">房价</label>
                                  <input type="text" name="roomPrice" class="form-control roomPrice" value="${roomType.individualPrice}"/>
                              </div> 
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">押金</label>
                                  <input type="text" name="reservationForegift" class="form-control"/>
                              </div>                              
                              <div class="newRoomTypeFooter">
                              <button type="submit" class="btn btn-default btns">确认</button>
                              <button type="button" class="btn btn-default btns closeReservation">返回</button>
                              </div>
                          </form>
                      </div>
                  </div>
              </div>
               <!-- 预订详情 -->
               <div class="col-md-6 reservationDetail">
                  	<div class="panel panel-default">
                      <div class="panel-heading " style="text-align: center;">预订详情</div>
                      <div class="panel-body">
                          <form >
                         	 <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">房间号</label>
                                  <input type="text" name="roomId" disabled="disabled" class="form-control roomNumberDetail"/>                             
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">姓名</label>
                                  <input type="text" name="reservationName" disabled="disabled" class="form-control reservationNameDetail"/>                             
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">身份证号</label>
                                  <input type="text" name="reservationIdCard" disabled="disabled" class="form-control reservationIdCardDetail"/>
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">电话号码</label>
                                  <input type="text" name="reservationPhoneNumber" disabled="disabled" class="form-control reservationPhoneNumberDetail"/>
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">预订时间</label>
                                  <input type="text" name="reservationTime" disabled="disabled" class="form-control reservationTimeDetail"/>
                                  
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">预计到店时间</label>
                                  <input type="text" name="expectedTimeOfArrival" disabled="disabled" class="form-control expectedTimeOfArrivalDetail" />
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">预订状态</label>
                                  
                                   <input type="text" name="expectedTimeOfArrival" disabled="disabled" class="form-control reservationStatusDetail" />
                                    	                                  	
                                    
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">入住天数</label>
                                  <input type="text" name="reservationOccupancyDays" disabled="disabled" class="form-control reservationOccupancyDaysDetail"/>
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">押金</label>
                                  <input type="text" name="reservationForegift" disabled="disabled" class="form-control reservationForegiftDetail"/>
                              </div>                              
                              <div class="newRoomTypeFooter">
                              <button type="button" class="btn btn-default btns">退订</button>
                              <button type="button" class="btn btn-default btns closeReservationDetail">返回</button>
                              </div>
                          </form>
                      </div>
                  </div>
              </div>
              <!-- 退订登记 -->
               <div class="col-md-6 unsubscribe">
                  	<div class="panel panel-default">
                      <div class="panel-heading " style="text-align: center;">退订登记</div>
                      <div class="panel-body">
                          <form action="${pageContext.request.contextPath}/updateReservation" method="post">
                          <input type="hidden" name="roomId" class="roomIdUnsubscribeInp">
                          <input type="hidden" name="reservationId" class="reservationIdUnsubscribeInp">
                         	 <input type="hidden" name="staffId" value="${sessionScope.staff.staffId}">
                         	 <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">房间号</label>
                                  <input type="text" disabled="disabled" name="roomId" class="form-control roomNumberUnsubscribeInp"/>                             
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">姓名</label>
                                  <input type="text" name="reservationName" disabled="disabled" class="form-control reservationNameUnsubscribeInp"/>                             
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">身份证号</label>
                                  <input type="text" name="reservationIdCard" disabled="disabled" class="form-control reservationIdCardUnsubscribeInp"/>
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">电话号码</label>
                                  <input type="text" name="reservationPhoneNumber" disabled="disabled" class="form-control reservationPhoneNumberUnsubscribeInp"/>
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">预订时间</label>
                                  <input type="text" name="reservationTime" disabled="disabled" class="form-control reservationTimeUnsubscribeInp"/>
                                  
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">预计到店时间</label>
                                  <input type="text" name="expectedTimeOfArrival" disabled="disabled" class="form-control expectedTimeOfArrivalUnsubscribeInp" />
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">预订状态</label>
                                   <input type="text" name="reservationStatus" disabled="disabled" class="form-control reservationStatusUnsubscribeInp" />                                  
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">入住天数</label>
                                  <input type="text" name="reservationOccupancyDays" disabled="disabled" class="form-control reservationOccupancyDaysUnsubscribeInp"/>
                              </div>
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">押金</label>
                                  <input type="text" name="reservationForegift" disabled="disabled" class="form-control reservationForegiftUnsubscribeInp"/>
                              </div>    
                              <div class="form-group newRoomTypeInp">
                                  <label for="exampleInputEmail1">应退押金</label>
                                  <input type="text" name="unsubscribeForegift"  class="form-control unsubscribeForegiftUnsubscribeInp"/>
                                  <a href="#" class="openDefaultRatio">修改比例</a>
                              </div>                            
                              <div class="newRoomTypeFooter">
                              <button type="submit" class="btn btn-default btns">确认</button>
                              <button type="button" class="btn btn-default btns closeUnsubscribe">返回</button>
                              </div>
                          </form>
                      </div>
                  </div>
              </div>
              <!-- 修改退订押金比例 -->
                <div class="col-md-6 defaultRatio" >
               	<div class="panel panel-default">
                   <div class="panel-heading">修改退订押金比例</div>
                   <div class="panel-body">
                   <form>
                           <div class="form-group tips">
                               <label for="exampleInputEmail1">押金比例</label>
                               <input type="text" name="reservationForegift"  class="form-control updateUnsubscribeForegift"/>
                           </div>                       
                           	<div class="deleteRoomFooter">
                           	<a  href="#" class="btn btn-default btns okDefaultRatio">确认</a>
                           <span class="btn btn-default closeDefaultRatio btns">取消</span>
                           </div>
		                   </div>
		                   </form>
		               </div>
		           </div>
		          <!-- 入住登记 -->
               <div class="col-md-6 checkIn">
                	<div class="panel panel-default">
                    <div class="panel-heading " style="text-align: center;">入住登记</div>
                    <div class="panel-body">
                    <div class="checkInBtn">
							<button type="button" class="btn btn-default btns direct">直接入住</button>	
							<button type="button" class="btn btn-default btns temporary">临时入住</button>	
						</div>
                        <form action="${pageContext.request.contextPath}/checkIn" method="post">
                        <input type="hidden" name="roomId" class="roomIdCheckInInp">
                        <input type="hidden" name="reservationId" class="reservationIdInp" value="0">
                       	 <input type="hidden" name="staffId" value="${sessionScope.staff.staffId}">
                       	 <div class="form-group checkInInp">
                                <label for="exampleInputEmail1">房间号</label>
                                <input type="text" class="form-control roomNumberCheckInInp"/>                             
                            </div>
                            <div class="form-group checkInInp">
                                <label for="exampleInputEmail1">姓名</label>
                                <input type="text" name="checkinName" class="form-control checkInNameInp"/>                             
                            </div>
                            <div class="form-group checkInInp">
                                <label for="exampleInputEmail1">身份证号</label>
                                <input type="text" name="checkinIdCard" class="form-control checkInIdCardInp"/>
                            </div>
                            <div class="form-group checkInInp">
                                <label for="exampleInputEmail1">电话号码</label>
                                <input type="text" name="checkinPhone" class="form-control checkInPhoneInp"/>
                            </div>
                            <div class="form-group checkInInp">
                                <label for="exampleInputEmail1">客户类型</label>
                                <select name="customerType" class="form-control customerType">                          	
                                  </select>   
                            </div>
                            <div class="form-group checkInInp">
                                <label for="exampleInputEmail1">入住时间</label>
                                <input type="text" name="checkinTime" class="form-control checkinTime"/>
                                
                            </div>
                            <div class="form-group checkInInp">
                                <label for="exampleInputEmail1">预离时间<span class="departureTimes" style="color: red"></span></label>
                                <input type="date" name="DepartureTime"  class="form-control departureTime" />
                            </div>
                            <div class="form-group checkInInp">
                                <label for="exampleInputEmail1">入住天数</label>
                                <input type="text" name="checkinDay" class="form-control checkinDay"/>
                            </div>
                            <div class="form-group checkInInp">
                                <label for="exampleInputEmail1">房价</label>
                                <input type="text"  class="form-control checkInRoomPrice"/>
                            </div>
                            <div class="form-group checkInInp">
                                <label for="exampleInputEmail1">应收房款</label>
                                <input type="text" name="checkinForegift" class="form-control checkInForegift"/>
                            </div>
                            <div class="form-group checkInInp">
                                <label for="exampleInputEmail1">结算方式</label>
                                <select name="paymentMethod" class="form-control">
                                  	<option value="0" class="pdmaintainStatus">现金支付</option>
                                  	<option value="1" class="pdmaintainStatus">扫码支付</option>
                                  	<option value="2" class="pdmaintainStatus">刷卡支付</option>                                   	
                                  </select>   
                            </div>                                                         
                            <div class="newRoomTypeFooter">
                            <button type="submit" class="btn btn-default btns">确认</button>
                            <button type="button" class="btn btn-default btns closeCheckIn">返回</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
             <!-- 入住详情 -->
               <div class="col-md-6 showCheckIn">
                	<div class="panel panel-default">
                    <div class="panel-heading " style="text-align: center;">入住详情</div>
                    <div class="panel-body">
                        <form>
                       	 <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">房间号</label>
                                <input type="text" disabled="disabled" class="form-control roomNumberShowCheckIn"/>                             
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">姓名</label>
                                <input type="text" name="checkinName" disabled="disabled" class="form-control checkInNameShowCheckIn"/>                             
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">身份证号</label>
                                <input type="text" name="checkinIdCard" disabled="disabled" class="form-control checkInIdCardShowCheckIn"/>
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">电话号码</label>
                                <input type="text" name="checkinPhone" disabled="disabled" class="form-control checkInPhoneShowCheckIn"/>
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">客户类型</label>
                                <select name="customerType" disabled="disabled" class="form-control customerType"> 
                                	                          	
                                  </select>   
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">入住时间</label>
                                <input type="text" name="checkinTime" disabled="disabled" class="form-control checkinTimeShowCheckIn"/>
                                
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">预离时间</label>
                                <input type="text" name="DepartureTime" disabled="disabled"  class="form-control departureTimeShowCheckIn" />
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">入住天数</label>
                                <input type="text" name="checkinDay" disabled="disabled" class="form-control checkinDayShowCheckIn"/>
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">押金</label>
                                <input type="text" name="checkinForegift" disabled="disabled" class="form-control checkinForegiftShowCheckIn"/>
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">结算方式</label>
                                <select name="paymentMethod" class="form-control">
                                  	<option value="0" class="pdmaintainStatus">现金支付</option>
                                  	<option value="1" class="pdmaintainStatus">扫码支付</option>
                                  	<option value="2" class="pdmaintainStatus">刷卡支付</option>                                   	
                                  </select>   
                            </div>                                                         
                            <div class="newRoomTypeFooter">
                            <button type="submit" class="btn btn-default btns">续住</button>
                            <button type="button" class="btn btn-default btns">退房</button>
                            <button type="button" class="btn btn-default btns closeShowCheckIn">返回</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
             <!-- 续住登记 -->
               <div class="col-md-6 continued">
                	<div class="panel panel-default">
                    <div class="panel-heading " style="text-align: center;">续住登记</div>
                    <div class="panel-body">
                        <form action="${pageContext.request.contextPath}/continued" method="post">
                        <input type="hidden" name="roomId" class="roomIdContinuedInp">
                       	 <input type="hidden" name="staffId" value="${sessionScope.staff.staffId}">
                       	 <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">房间号</label>
                                <input type="text" disabled="disabled" class="form-control roomNumberShowCheckIn"/>                             
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">姓名</label>
                                <input type="text" name="checkinName" disabled="disabled" class="form-control checkInNameShowCheckIn"/>                             
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">身份证号</label>
                                <input type="text" name="checkinIdCard" disabled="disabled" class="form-control checkInNameShowCheckIn"/>
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">电话号码</label>
                                <input type="text" name="checkinPhone" disabled="disabled" class="form-control checkInNameShowCheckIn"/>
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">客户类型</label>
                                <select name="customerType" disabled="disabled" class="form-control customerType">                      	                          	
                                  </select>   
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">入住时间</label>
                                <input type="text" name="checkinTime" disabled="disabled" class="form-control checkinTimes"/>
                                
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">预离时间</label>
                                <input type="date" name="departureTime"   class="form-control departureTimec" />
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">入住天数</label>
                                <input type="text" name="checkinDay"  class="form-control continuedDays"/>
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">房价</label>
                                <input type="text"   class="form-control price"/>
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">已交房费</label>
                                <input type="text"   class="form-control checkinForegiftShowCheckIn"/>
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">补交房费</label>
                                <input type="text" name="checkinForegift"  class="form-control continuedForegift"/>
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">结算方式</label>
                                <select name="paymentMethod" class="form-control">
                                  	<option value="0" class="pdmaintainStatus">现金支付</option>
                                  	<option value="1" class="pdmaintainStatus">扫码支付</option>
                                  	<option value="2" class="pdmaintainStatus">刷卡支付</option>                                   	
                                  </select>   
                            </div>                                                         
                            <div class="newRoomTypeFooter">
                            <button type="submit" class="btn btn-default btns">确认</button>
                            <button type="button" class="btn btn-default btns closeContinued">返回</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
             <!-- 退房登记 -->
               <div class="col-md-6 checkOut">
                	<div class="panel panel-default">
                    <div class="panel-heading " style="text-align: center;">退房登记</div>
                    <div class="panel-body">
                        <form action="${pageContext.request.contextPath}/newCheckOut" class="checkOutForm" method="post">
                        <input type="hidden" name="roomId" class="roomIdCheckOutInp">
                       	 <input type="hidden" name="staffId" value="${sessionScope.staff.staffId}">
                       	 <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">房间号</label>
                                <input type="text"  class="form-control roomNumberCheckOutInp"/>                             
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">姓名</label>
                                <input type="text" name="checkinName" class="form-control checkOutNameInp"/>                             
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">身份证号</label>
                                <input type="text" name="checkinIdCard" class="form-control checkOutIdCardInp"/>
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">电话号码</label>
                                <input type="text" name="checkinPhone" class="form-control checkOutPhoneInp"/>
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">客户类型</label>
                                <select name="customerType" class="form-control customerType">                          	
                                  </select>   
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">入住时间</label>
                                <input type="text" name="checkinTime" class="form-control checkInTimeInps"/>
                                
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">退房时间</label>
                                <input type="text" name="checkOutTime"  class="form-control checkOutTimeInps" />
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">入住天数</label>
                                <input type="text" name="checkinDay" class="form-control checkInDayss"/>
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">房价</label>
                                <input type="text" name="roomPrice" class="form-control roomPrice"/>
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">已收房款</label>
                                <input type="text" name="checkinForegift" class="form-control checkinForegifts"/>
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">应收房款</label>
                                <input type="text" name="amountReceived" class="form-control amountReceiveds"/>
                            </div>
                            <div class="form-group newRoomTypeInp">
                                <label for="exampleInputEmail1">结算方式</label>
                                <select name="paymentMethod" class="form-control">
                                  	<option value="0" class="pdmaintainStatus">现金支付</option>
                                  	<option value="1" class="pdmaintainStatus">扫码支付</option>
                                  	<option value="2" class="pdmaintainStatus">刷卡支付</option>                                   	
                                  </select>   
                            </div>                                                         
                            <div class="newRoomTypeFooter">
                            <button type="submit" class="btn btn-default btns">确认</button>
                            <button type="button" class="btn btn-default btns closeCheckOut">返回</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
                 <div class="footer"> 
               
				 <a href="${pageContext.request.contextPath}/showAllRoom/${requestScope.roomTypeId}" class="countRoom" id="${requestScope.countRoomType}">全部<br/>(${requestScope.countRoomType})</a>
				<a href="${pageContext.request.contextPath}/showRoomStruts/0/0"/><p style="color: #000" class="span2">预订<br/>(${requestScope.countReservationRoomType})</p></a>
				<a href="${pageContext.request.contextPath}/showRoomStruts/1/0"/><p class="countCheckin" id="${requestScope.countCheckinRoomType}">在住<br/>(${requestScope.countCheckinRoomType})</p></a>
				<a href="${pageContext.request.contextPath}/showRoomStruts/2/0"/><p class="span4">空闲<br/>(${requestScope.countFreeRoomType})</p></a>
				<a href="${pageContext.request.contextPath}/showRoomStruts/3/0"/><p class="span5">脏房<br/>(${requestScope.countNotCleanedRoomType})</p></a>
				<a href="${pageContext.request.contextPath}/showRoomStruts/4/0"/><p class="span6">维修<br/>(${requestScope.countRepairRoomType})</p></a>
				<p class="span1"></p>
			</div>
            </div>
         </div>
    </div>
    
</body>
</html>