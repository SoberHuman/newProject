<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客户管理</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/logistics/maintain.css" rel="stylesheet" />
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
            $(".openNewUsers").click(function(){
            	$(".newUsers").css("display","block");
            })
            $(".closeNewUsers").click(function(){
            	$(".newUsers").css("display","none");
            })
            $(".openUpdateUsers").click(function(e){
            	var v_id =e.target.id;
            	var a =$(this).attr("a");
            	$(".userRealNameInp").val($(this).parent().parent().parent(".users").find(".userRealName").html());
            	$(".userVipIdInp").html($(this).parent().parent().parent(".users").find(".userVipId").html());
            	$(".userIdCardInp").html($(this).parent().parent().parent(".users").find(".userIdCard").html());
            	$(".userPassInp").val(a);
            	$(".userPhoneInp").val($(this).parent().parent().parent(".users").find(".userPhone").html());
            	$(".userGenderInp").html($(this).parent().parent().parent(".users").find(".userGender").html());
            	$(".usersIdInp").val(v_id)
            	$(".updateUsers").css("display","block");
            })
            $(".closeUpdateUsers").click(function(){
            	$(".updateUsers").css("display","none");
            })
            $(".openDeleteRoomType").click(function(){
            	var v_id = $(this).attr("id");
            	$("#okDeleteRoomType").attr("href","/deleteMaintain/"+v_id);
            	$(".deleteRoomType").css("display","block");
            })
            $(".closeDeleteRoomType").click(function(){
            	$(".deleteRoomType").css("display","none");
            }) 
            $(".openClean").click(function(){
            	$(".clean").css("display","block");
            })
            $(".closeClean").click(function(){
            	$(".clean").css("display","none");
            }) 
            $(".openRepair").click(function(){
            	setInterval(function(){
					var dates = new Date();
					var years = dates.getFullYear();
					var monhs = dates.getMonth()+1;
					var days = dates.getDate();
					var h = dates.getHours();
					var m = dates.getMinutes();
					var s = dates.getSeconds();
					$(".maintainStartTime").val(years+"-"+monhs+"-"+days+" "+h+":"+m+":"+s);
				},1000)
            	$(".repair").css("display","block");
            })
            $(".closeRepair").click(function(){
            	$(".repair").css("display","none");
            }) 
            $(".openCompleteRepair").click(function(){
            	$(".roomIdInp").val($(this).attr("id"))
            	$(".roomNumberInp").val($(this).parent().parent().parent(".users").find(".roomNumber").html());
            	setInterval(function(){
					var dates = new Date();
					var years = dates.getFullYear();
					var monhs = dates.getMonth()+1;
					var days = dates.getDate();
					var h = dates.getHours();
					var m = dates.getMinutes();
					var s = dates.getSeconds();
					$(".maintainFinishTime").val(years+"-"+monhs+"-"+days+" "+h+":"+m+":"+s);
				},1000)
            	$(".completeRepair").css("display","block");
            })
            $(".closeCompleteRepair").click(function(){
            	$(".completeRepair").css("display","none");
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
                            <a href="#" class="openClean">清洁登记</a>
                        </li> 
                        <li>
                            <a href="#" class="openRepair">维修登记</a>
                        </li>                     
                    </ul>
                </div>
            </div>
            <div class="main-right  col-md-10 col-md-offset-2 bodys">
                        <div class="panel-body navs">
                            <ol class="breadcrumb">
                                <li><a href="${pageContext.request.contextPath}/toPage/index/index">首页</a></li>
                                <li><a href="${pageContext.request.contextPath}/showAllMaintain/1">维修记录</a></li>
                            </ol>
                        </div>            
          	<div class="col-md-12">
                    <div class="panel panel-default tableTitle">
                        <div class="panel-heading">
                          	搜索房间记录：
                          	<form action="${pageContext.request.contextPath}/showInputAllMaintain/1" method="post">  
                       		<div class="input-group shouUsers">       									              
                                    <input type="text" class="form-control shouUsersInp" name="roomNumber" placeholder="请输入房间号..." />
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
                                    	<td>房间号</td>
                                        <td>开始维修时间</td>
                                        <td>维修原因</td>
                                        <td>维修状态</td>
                                        <td>完成时间</td>
                                        <td>维修结果</td>
                                        <td>登记人</td>
                                        <td class="text-center">操作</td>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:if test="${requestScope.maintains.size() >0}">
                                	<c:forEach items="${requestScope.maintains}" var="maintains">
                                    <tr class="users">                                                                
                                        <td class="roomNumber">${maintains.roomNumber}</td>
                                        <td class="userVipId">${maintains.maintainStartTime}</td>
                                        <td class="userIdCard">${maintains.maintainCause}</td>                                        
                                        <c:if test="${maintains.maintainStatus == 0}">
                                        	<td class="userGender">维修完成</td>
                                        </c:if>
                                        <c:if test="${maintains.maintainStatus == 2}">
                                        	<td class="userGender">维修中</td>
                                        </c:if>
                                        <td class="userPhone">${maintains.maintainFinishTime}</td>
                                        <td class="userPhone">${maintains.maintainResult}</td>
                                        <td class="userPhone">${maintains.staffName}</td>
                                        <td class=" text-center">
                                        <c:if test="${maintains.maintainStatus  == 0}">
                                        <a href="#" style="display: none"><i title="修改记录" id="${maintains.roomId}" class="glyphicon glyphicon-edit openCompleteRepair"></i></a>
                                        </c:if>
                                        <c:if test="${maintains.maintainStatus  == 2}">
                                        <a href="#"><i title="修改记录" id="${maintains.roomId}" class="glyphicon glyphicon-edit openCompleteRepair"></i></a>
                                        </c:if>
                                        &nbsp;&nbsp;<i title="删除记录"  id="${maintains.maintainId}" class="glyphicon glyphicon-remove openDeleteRoomType"></i></td>
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
                                        <a href="${pageContext.request.contextPath}/showAllMaintain/${requestScope.nowPage -1}" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                  <c:forEach begin="${requestScope.beginPage}" end="${requestScope.endPage}" var="showPage"> 
								 <c:if test="${requestScope.nowPage == showPage}">	 
							    <li>				    		                       
							    <a style="background:#e7e7e7" href="/showAllMaintain/${showPage}">${showPage}</a>				    			    
							    </li>
							    </c:if>	
							     <c:if test="${requestScope.nowPage != showPage}">	 
							    <li>				    		                       
							    <a href="/showAllMaintain/${showPage}">${showPage}</a>				    			    
							    </li>
							    </c:if>	
							    </c:forEach>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/showAllMaintain/${requestScope.nowPage +1}" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
               <!-- 清洁登记 -->
                <div class="col-md-6 clean" >
               	<div class="panel panel-default cleanBody">
                   <div class="panel-heading">清洁登记</div>
                   <div class="panel-body">
                        <form action="${pageContext.request.contextPath}/clean" method="post">
                              <div class="form-group logisticsInp">
                                    <label for="exampleInputEmail1">房间号</label>
                                    <input type="text" name="roomNumber" class="form-control" placeholder="请输入房间号..." />
                                </div>
                             <div class="form-group logisticsInp">
                                 <label for="exampleInputEmail1">清洁登记</label>
                                 <select name="roomSanitation" class="form-control">
                                 	<option value="0">已打扫</option>
                                 	<option value="1">未打扫</option>
                                 </select>                                  
                             </div>
                             <div class="cleanFooter">
                             <button type="submit" class="btn btn-default btns okbtn">确认</button>
                             <span  class="btn btn-default btns closeClean">取消</span>
                             </div>
                         </form>                      
                  </div>
              </div>
          </div>
          <!-- 开始维修登记 -->
              <div class="col-md-6 repair">                
                  <div class="panel panel-default repairBody">
                  <div class="panel-heading">维修登记</div>
                  <div class="panel-body">
                  <form action="${pageContext.request.contextPath}/logisticsAddMaintain" method="post">
              	<input type="hidden" name="staffId" value="${sessionScope.staff.staffId}">
                 <div class="form-group logisticsInp">
                	 <div class="form-group logisticsInp">
                      	<label for="exampleInputEmail1">房间号</label>
                      	<input type="text" name="roomNumber" class="form-control" />
                 	 </div>
                      <label for="exampleInputEmail1">开始维修登记</label>
                      <select name="maintainStatus" class="form-control maintainStatus">
                      	<option value="2" class="pdmaintainStatus">维修中</option>                                   	
                      </select>                                  
                  </div>
                  <div class="form-group logisticsInp">
                      <label for="exampleInputEmail1">开始维修时间</label>
                      <input type="text" name="maintainStartTime" class="form-control maintainStartTime" />
                  </div>
                  <div class="form-group logisticsInp">
                      <label for="exampleInputEmail1">维修原因</label>
                      <textarea name="maintainCause" class="form-control maintainCause" placeholder="请输入维修原因..."></textarea>
                  </div>
                  <div class="repairFooter">
                  <button type="submit" class="btn btn-default btns okbtn">确认</button>
                  <span  class="btn btn-default btns closeRepair">取消</span>
                  </div>
                 </form> 
                 </div>
                  </div>              
              </div>
              <!-- 完成维修登记 -->
              <div class="col-md-6 completeRepair">                
                  <div class="panel panel-default completeRepairBody">
                  <div class="panel-heading">维修登记</div>
                  <div class="panel-body">
              <form action="${pageContext.request.contextPath}/updateMaintain/1" method="post">
              	    <input type="hidden" name="roomId" class="roomIdRoomSanitation roomIdInp">
                  	<input type="hidden" name="staffId" value="${sessionScope.staff.staffId}">
                     <div class="form-group logisticsInp">
	                      <div class="form-group logisticsInp">
	                      	<label for="exampleInputEmail1">房间号</label>
	                      	<input type="text" name="roomNumber" class="form-control roomNumberInp" />
	                 	 </div>
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
                      <div class="completeRepairFooter">
                      <button type="submit" class="btn btn-default btns okbtn">确认</button>
                      <span  class="btn btn-default btns closeCompleteRepair">取消</span>
                      </div>
                  </form> 
                  </div>
                  </div>              
              </div>
                <!-- 删除记录 -->
                <div class="col-md-6 deleteRoomType" >
               	<div class="panel panel-default deleteRoomTypeBody">
                   <div class="panel-heading">系统提示</div>
                   <div class="panel-body">
                           <div class="form-group tips">
                               <label for="exampleInputEmail1">是否删除该维修记录？</label>
                           </div>                       
                           	<div class="deleteRoomTypeFooter">
                           	<a  href="#" id="okDeleteRoomType" class="btn btn-default btns">确认</a>
                           <span class="btn btn-default closeDeleteRoomType btns">取消</span>
                           </div>
		                   </div>
		               </div>
		           </div>
            </div>
         </div>
    </div>
    
</body>
</html>