<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>客户管理</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/users/users.css" rel="stylesheet" />
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
            	$(".userVipIdInp").val($(this).parent().parent().parent(".users").find(".userVipId").html());
            	$(".userIdCardInp").val($(this).parent().parent().parent(".users").find(".userIdCard").html());
            	$(".userPassInp").val(a);
            	$(".userPhoneInp").val($(this).parent().parent().parent(".users").find(".userPhone").html());
            	$(".userIntegralInp").val($(this).parent().parent().parent(".users").find(".userIntegral").html());
            	$(".usersIdInp").val(v_id);
            	$(".updateUsers").css("display","block");
            })
            $(".closeUpdateUsers").click(function(){
            	$(".updateUsers").css("display","none");
            })
            $(".openDeleteUsers").click(function(e){
            	$(".deleteUsers").css("display","block");
            	var v_id =e.target.id;
            	$("#okDeleteUsers").attr('href',"/deleteUsers?usersId="+v_id);
            })
            $(".closeDeleteUsers").click(function(){
            	$(".deleteUsers").css("display","none");
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
                                <li><a href="#" class="openNewUsers">新增会员</a></li>
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
                                <li><a href="${pageContext.request.contextPath}/showAllUsers/1">会员列表</a></li>
                            </ol>
                        </div>            
          	<div class="col-md-12">
                    <div class="panel panel-default tableTitle">
                        <div class="panel-heading">
                          	搜索会员：
                          	<form action="${pageContext.request.contextPath}/showInputUsers/1" method="post">  
                       		<div class="input-group shouUsers">       
									              
                                    <input type="text" class="form-control shouUsersInp" name="userRealName" placeholder="请输入会员名、账号、手机号、身份证号" />
                                    <span class="input-group-btn">
                                        <button class="btn btn-default" type="submit">搜索</button>
                                    </span>
                                    
                                </div>
                                </form> 
                                <span title="新增公告" class="glyphicon glyphicon-plus openNewUsers openNewUserss">新增</span>
                        </div>
                        <div class="panel-body">
                            <table class="table table-bordered tb-hover">
                                <thead>
                                    <tr>
                                    	<td>姓名</td>
                                        <td>账号</td>
                                        <td>身份证号</td>
                                        <td>手机号</td>
                                        <td>积分</td>
                                        <td class="text-center">操作</td>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:if test="${requestScope.users.size() >0}">
                                	<c:forEach items="${requestScope.users}" var="users">
                                    <tr class="users">                                                                
                                        <td class="userRealName">${users.userRealName}</td>
                                        <td class="userVipId">${users.userVipId}</td>
                                        <td class="userIdCard">${users.userIdCard}</td>
                                        <td class="userPhone">${users.userPhone}</td>
                                        <td class="userIntegral">${users.userIntegral}</td>
                                        <td class=" text-center">
                                        <a href="${pageContext.request.contextPath}/showUsersIdConsumptionRecord/1&${users.usersId}"><i title="查询消费记录" id="${users.usersId}" class="glyphicon glyphicon-search openShowAnnouncement"></i>
                                        </a>&nbsp;&nbsp;<a href="#"><i title="修改信息" id="${users.usersId}" a="${users.userPass}" class="glyphicon glyphicon-edit openUpdateUsers"></i></a>
                                        &nbsp;&nbsp;<i title="删除会员"  id="${users.usersId}" class="glyphicon glyphicon-remove openDeleteUsers"></i></td>
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
                                        <a href="${pageContext.request.contextPath}/showAllUsers/${requestScope.nowPage -1}" aria-label="Previous">
                                            <span aria-hidden="true">&laquo;</span>
                                        </a>
                                    </li>
                                  <c:forEach begin="${requestScope.beginPage}" end="${requestScope.endPage}" var="showPage"> 
								 <c:if test="${requestScope.nowPage == showPage}">	 
							    <li>				    		                       
							    <a style="background:#e7e7e7" href="/showAllUsers/${showPage}">${showPage}</a>				    			    
							    </li>
							    </c:if>	
							     <c:if test="${requestScope.nowPage != showPage}">	 
							    <li>				    		                       
							    <a href="/showAllUsers/${showPage}">${showPage}</a>				    			    
							    </li>
							    </c:if>	
							    </c:forEach>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/showAllUsers/${requestScope.nowPage +1}" aria-label="Next">
                                            <span aria-hidden="true">&raquo;</span>
                                        </a>
                                    </li>
                                </ul>
                            </nav>
                        </div>
                    </div>
                </div>
                <!-- 新增会员 -->
                <div class="col-md-6 newUsers">
                    <div class="panel panel-default ">
                        <div class="panel-heading" style="text-align: center;">新增会员</div>
                        <div class="panel-body">
                            <form action="${pageContext.request.contextPath}/newUsers" method="post">
                                <div class="form-group newUsersInput">
                                    <label for="exampleInputEmail1">姓名</label>
                                    <input type="text" name="userRealName" class="form-control" id="exampleInputEmail1" placeholder="请输入用户姓名..." />
                                </div>
                                <div class="form-group newUsersInput">
                                    <label for="exampleInputEmail1">账号</label>
                                    <input type="text" name="userVipId" class="form-control" id="exampleInputEmail1" placeholder="请输入用户账号..." />
                                </div>
                                <div class="form-group newUsersInput">
                                    <label for="exampleInputEmail1">身份证号</label>
                                    <input type="text" name="userIdCard" class="form-control" id="exampleInputEmail1" placeholder="请输入用户身份证号..." />
                                </div>
                                <div class="form-group newUsersInput">
                                    <label for="exampleInputEmail1">密码</label>
                                    <input type="text" name="userPass" class="form-control" id="exampleInputEmail1" placeholder="请输入用户账号..." />
                                </div>
                                <div class="form-group newUsersInput">
                                    <label for="exampleInputEmail1">手机号</label>
                                    <input type="text" name="userPhone" class="form-control" id="exampleInputEmail1" placeholder="请输入用户手机号..." />
                                </div>                            
                                <div class="btns newUsersFooter">
                                <button type="submit" class="btn btn-default">提交</button>
                                <span class="btn btn-default closeNewUsers">取消</span>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- 修改会员信息 -->
                <div class="col-md-6 updateUsers">
                    <div class="panel panel-default ">
                        <div class="panel-heading">修改会员信息</div>
                        <div class="panel-body">
                            <form action="${pageContext.request.contextPath}/updateUsers" method="post">
                            <input type="hidden" name="usersId" class="usersIdInp">
                                <div class="form-group newUsersInput" >
                                    <label for="exampleInputEmail1">姓名</label>
                                    <input type="text" name="userRealName" class="form-control userRealNameInp" id="exampleInputEmail1" placeholder="请输入用户姓名..." />
                                </div>
                                <div class="form-group newUsersInput">
                                    <label for="exampleInputEmail1">账号</label>
                                    <input type="text" disabled="disabled" class="form-control userVipIdInp" id="exampleInputEmail1"/>                                    
                                </div>
                                <div class="form-group newUsersInput">
                                    <label for="exampleInputEmail1">身份证号</label>
                                    <input type="text" disabled="disabled" class="form-control userIdCardInp" id="exampleInputEmail1"/>
                                   </div>
                                <div class="form-group newUsersInput">
                                    <label for="exampleInputEmail1">密码</label>
                                    <input type="text" name="userPass" class="form-control userPassInp" id="exampleInputEmail1" placeholder="请输入用户账号..." />
                                </div>
                                <div class="form-group newUsersInput">
                                    <label for="exampleInputEmail1">手机号</label>
                                    <input type="text" name="userPhone" class="form-control userPhoneInp" id="exampleInputEmail1" placeholder="请输入用户手机号..." />
                                </div>     
                                <div class="form-group newUsersInput">
                                    <label for="exampleInputEmail1">积分</label>
                                    <input type="text" name="userIntegral" class="form-control userIntegralInp" id="exampleInputEmail1" />
                                </div>                       
                                <div class="btns newUsersFooter">
                                <button type="submit" class="btn btn-default">提交</button>
                                <span class="btn btn-default closeUpdateUsers">取消</span>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
                <!-- 删除会员 -->
                <div class="col-md-6 deleteUsers">
               <div class="panel panel-default ">
                   <div class="panel-heading">删除会员</div>
                   <div class="panel-body">
                           <div class="form-group deleteUsersok">
                               <label for="exampleInputEmail1">是否删除该会员？</label>
                           </div>                       
                           <a  href="#" id="okDeleteUsers" class="btn btn-default">确认</a>
                           <span class="btn btn-default closeDeleteUsers">取消</span>
		                   </div>
		               </div>
		           </div> 
            </div>
         </div>
    </div>
    
</body>
</html>