<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>用户登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/users/userRegist.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js" ></script>
		<script type="text/javascript">
			$(function(){
				var time = 60;
				$(".getMessage").click(function(){
					var userPhone = $(".userPhone").val();
					alert(userPhone);
					$.post("${pageContext.request.contextPath}/getMessage/"+userPhone,function(data){
						if(data != "error"){
							alert("发送成功，请注意查看短信");
							if(time==60){//如果不加入该判断，则会出现在倒计时期间不断的点击发生不断的加快（其实就是你点了多少次就重复多少次该函数）的问题，用setTimeout（）方法不加此判断也是一样的
					    		   var time1=setInterval(function(){
					        		   if(time==0){
					            		   $(".getMessage").html("重新发送");
					            		   $(".getMessage").removeAttr("disabled");
					            		   time=60;
					            		   clearInterval(time1);
					            	   }else{
					            		   $(".getMessage").attr("disabled","true");
					            		   $(".getMessage").html("重新发送("+time+")");
					            		   time--;
					            	   }
					        		   }, 1000);
							}
						$(".okMessage").on("input propertychange",function(){
							if($(this).val()==data){
								$(spans[4]).html("验证码正确");
								return true;
							}else{
								$(spans[4]).html("验证码错误");
								return false;
							}
							})
						}else{
							alert("发送失败，请重新发送");
							return false;
						}
					})
				})
				var spans = $("span")
				$("#passwords").click(function(){
					if($("#names").val() == ""){
						$(spans[0]).html("姓名不能为空")
					}
				})
				$("#names").on("input",function(){
					$(spans[0]).html("");
				})
				$("#passwords").on("input",function(){
						$(spans[1]).html("");
					})
				$(".mainButtun").click(function(){
					if($("#names").val() == ""){
						$(spans[0]).html("姓名不能为空")
						return false;
					}
					if($("#passwords").val() == ""){
						$(spans[1]).html("密码不能为空")
						return false;
					}
					if($(".userIdCard").val() == ""){
						$(spans[2]).html("身份证号不能为空")
						return false;
					}
					if($(".okMessage").val() == ""){
						$(spans[4]).html("请输入验证码")
						return false;
					}
				})
				
			})			
		</script>
		<style type="text/css">
		body{
			width: 100%;
			background: url(${pageContext.request.contextPath}/img/LoginBg.jpg) 0 0/100%;
		}
		</style>
</head>
<body>
	<form action="${pageContext.request.contextPath}/userRegist" method="post">
		<div class="main">
			<div class="mainLogo">
			<img src="${pageContext.request.contextPath}/img/logo.png" class="logo"/>
			</div>
			<div class="section">
				<div class="user">
					<img src="${pageContext.request.contextPath}/img/user.png" class="userLogo"/>
					<input type="text" id="names" name="userRealName" autocomplete="off" placeholder="请输入您的姓名"/><span></span>
				</div>
				<div class="passwords">
					<img src="${pageContext.request.contextPath}/img/password.png" class="passwordLogo"/>
					<input type="text" id="passwords" name="userPass" autocomplete="off" placeholder="请输入您的登录密码"/><span></span>
				</div>
				<div class="user">
					<img src="${pageContext.request.contextPath}/img/user.png" class="userLogo"/>
					<input type="text" id="names" class="userIdCard" name="userIdCard" autocomplete="off" placeholder="请输入您的身份证号"/><span></span>
				</div>
				<div class="user">
					<img src="${pageContext.request.contextPath}/img/user.png" class="userLogo"/>
					<input type="text" id="names" class="userPhone" name="userPhone" autocomplete="off" placeholder="请输入您的手机号码"/><span></span>
					<button type="button" class="getMessage">获取验证码</button>
				</div>
				<div class="user">
					<img src="${pageContext.request.contextPath}/img/user.png" class="userLogo"/>
					<input type="text" id="names" class="okMessage"  autocomplete="off" placeholder="请输入验证码"/><span></span>
				</div>
			</div>
			<div class="footer">
				<input type="submit" value="注册" class="mainButtun"/>
			</div>
		</div>
	</form>
</body>
</html>