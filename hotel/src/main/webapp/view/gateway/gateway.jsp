<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>wrada酒店</title>
<meta name="viewport" content="width=device-width, initial-scale=1">

<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/gateway/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/gateway/font-awesome.min.css" rel="stylesheet">

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
                <ul class="list-inline">
                    <li>
                        <a href="#"><i class="fa fa-phone"></i> (+86) 13707849274</a>
                    </li><!-- comment for inline hack
                     --><li>
                        <a href="#"><i class="fa fa-map-marker"></i> 广西南宁市wrada酒店</a>
                    </li><!-- comment for inline hack
                     --><li>
                        <a href="#"><i class="fa fa-envelope"></i> 761299323@qq.com</a>
                    </li>
                </ul>
            </div><!-- /.pull-left left-infos -->
            <div class="pull-right right-infos link-list">
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
                            <c:otherwise>
                                <ul class="list-inline">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/view/gate/clientLogin.jsp">登录</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/view/gate/clientRegist.jsp">注册</a>
                                    </li>
                                </ul>
                            </c:otherwise>
                        </c:choose>

                    </c:when>



                    <c:when test="${sessionScope.customer != null }">

                        <c:choose>
                            <c:when test="${sessionScope.loginKey == 0}">
                                <ul class="list-inline">
                                    <li>
                                        <a href="#" style="color: gold">vip</a>
                                        <a href="${pageContext.request.contextPath}/view/gateway/personalCenter.jsp">欢迎！${sessionScope.customer.userRealName}</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/userCancellation">安全退出</a>
                                    </li>
                                </ul>
                            </c:when>
                            <c:when test="${sessionScope.loginKey == 1}">

                                <ul class="list-inline">
                                    <li>
                                        <a href="${pageContext.request.contextPath}/view/gateway/personalCenter.jsp">欢迎！${sessionScope.customer.clientName}</a>
                                    </li>
                                    <li>
                                        <a href="${pageContext.request.contextPath}/clientCancellation">安全退出</a>
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
                    <h4 style="font-size:36px;">WARADA</h4>
                </a>
            </div>

            <div class="collapse navbar-collapse" id="main-navigation">
                <ul class="nav navbar-nav ">
                    <li>
                    	<a href="${pageContext.request.contextPath}/gatewayShowAllRoomType/0" class="dropdown-toggle" >首页<span class="glyphicon glyphicon-chevron-down"></span></a>						
					</li>
                    <li>
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">客房<span class="glyphicon glyphicon-chevron-down"></span></a>
						
                    </li>
                    <li>
                    	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">服务<span class="glyphicon glyphicon-chevron-down"></span></a>					
                    </li>
                    <li>
                    	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">优惠 <span class="glyphicon glyphicon-chevron-down"></span></a>					
                    </li>
                    <li>
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">优惠 <span class="glyphicon glyphicon-chevron-down"></span></a>
                    </li>
                    <li>
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">客户评价<span class="glyphicon glyphicon-chevron-down"></span></a>
                    	<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">关于我们<span class="glyphicon glyphicon-chevron-down"></span></a>
                    </li>
                </ul>               
            </div>
        </div>
    </nav>
    
<!-- Header  Slider style-->

<div id="minimal-bootstrap-carousel" class="carousel default-home-slider slide carousel-fade shop-slider PageJump" data-ride="carousel">
    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
        <div class="item active slide-1" style="background-image: url(${pageContext.request.contextPath}/img/gateway/10.jpg);backgroudn-position: center right;">
            
            <div class="carousel-caption nhs-caption nhs-caption6">
	      		<div class="thm-container">
	      			<div class="box valign-middle">
	      				<div class="content text-center">
							<h2 data-animation="animated fadeInUp" class="this-title">度过梦想中的假期</h2>
							<p data-animation="animated fadeInDown">立即在我们的酒店预订房间，即可享受30％的折扣。水果篮，饮料和宽敞舒适的床都在等您。我们将竭尽所能使您有宾至如归的感觉。</p>
							<a data-animation="animated fadeInLeft" href="${pageContext.request.contextPath}/gatewayShowAllRoomType/1" class="nhs-btn3">立即预订</a>
							
	      				</div>
	      			</div>
	      		</div>
	    	</div>                
        </div>
        <div class="item  slide-2" style="background-image: url(${pageContext.request.contextPath}/img/gateway/11.jpg);backgroudn-position: center right;">
            
            <div class="carousel-caption nhs-caption nhs-caption7">
	      		<div class="thm-container">
	      			<div class="box valign-middle">
	      				<div class="content text-left pull-left">
							<h2 data-animation="animated fadeInUp" class="this-title">最佳休闲场所</h2>
							<p data-animation="animated fadeInDown">立即在我们的度假村预订房间，即可享受30％的折扣。水果篮，饮料和宽敞舒适的床都在等您。我们将竭尽所能使您有宾至如归的感觉。</p>
							<a data-animation="animated fadeInLeft" href="${pageContext.request.contextPath}/gatewayShowAllRoomType/1" class="nhs-btn3">立即预订</a>
	      				</div>
	      			</div>
	      		</div>
	    	</div>                
        </div>
        <div class="item  slide-2" style="background-image: url(${pageContext.request.contextPath}/img/gateway/12.jpg);backgroudn-position: center right;">
            
            <div class="carousel-caption nhs-caption nhs-caption8">
	      		<div class="thm-container">
	      			<div class="box valign-middle">
	      				<div class="content text-center">
							<h2 data-animation="animated fadeInUp" class="this-title">我们为您提供最好的</h2>
							<h2 data-animation="animated fadeInUp" class="this-title">历史悠久的豪华酒店</h2>
	      				</div>
	      			</div>
	      		</div>
	    	</div>            
        </div>
    </div>
    <!-- Controls -->
    <a class="left carousel-control" href="#minimal-bootstrap-carousel" role="button" data-slide="prev">
        <i class="fa fa-angle-left"></i>
        <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#minimal-bootstrap-carousel" role="button" data-slide="next">
        <i class="fa fa-angle-right"></i>
        <span class="sr-only">Next</span>
    </a>
</div>
<!-- Header  Slider style-->        
       
        
<!-- Rooms And Suits style--> 
<section class="container clearfix common-pad nasir-style PageJump">
 <div class="sec-header sec-header-pad">
 <h2>我们的客房</h2>
     <h3>选择一个最适合您的房间</h3>
 </div>
 <div class="room-slider">
   <div class="roomsuite-slider-two">  
   <c:if test="${requestScope.roomTypes.size() > 0}">
       <c:if test="${requestScope.roomTypes != null}">
           <c:forEach items="${requestScope.roomTypes}" var="roomTypes" varStatus="status">
               <div class="room-suite room-suite-htwo">
                 <div class="item">
                     <div class="ro-img" style="height: 262.95px">
                         <img src="${pageContext.request.contextPath}/img/RType/${roomTypes.roomTypeImage}" style="width:100%;height: 262.95px" class="img-responsive" alt="">
                     </div>
                     <div class="ro-txt">

                        <h2>${roomTypes.roomTypeName}</h2>
                         <div class="ro-text-two">
                             <div class="left-p-two pull-left">
                                 <c:if test="${map[roomTypes.roomTypeName].size()>0}">
                                        <a href="${pageContext.request.contextPath}/gatewayShowAllRoomType/${roomTypes.roomTypeId}" class="res-btn">预订</a>
                                </c:if>
                                <c:if test="${map[roomTypes.roomTypeName].size()<=0}">
                                    <a href="#" class="res-btn" style="background: #c0c0c0">预订</a>
                                </c:if>
                             </div>
                             <div class="right-p-two pull-right"><p>$${roomTypes.listPrice}<span>每晚</span></p></div>
                         </div>
                     </div>
                 </div>
               </div>
           </c:forEach>
       </c:if>
   </c:if>
  </div>
 </div>
</section> 
 <!-- Activities of Resort style-->    
  <div class="resot-activities clearfix PageJump">
    
    <div class="container clearfix common-pad">
      <div class="row">
        
        <div class="col-lg-6 col-md-6 activities-cont">
          
          <div class="sec-header3">
             <h2>我们的服务</h2>
                 <h3>我们致力于为客户提供优质的服务</h3>
             </div>
           <p>我们拥有专业的服务人员，随时等候着为您服务。在酒店的任何地方，您都可以寻找服务员来为您提供服务，当您在房间内需要服务时，也可以拨打电话让我们提供客房服务</p>
            <p>我们拥有丰富多样的设施，在你享受旅程的同时，为您提供更丰富的活动</p>
          
            <a href="aboutus.html" class="res-btn">About us<i class="fa fa-arrow-right"></i></a>
            
          </div>
          <div class="col-lg-6 col-md-6 col-xs-12">
			<div class="row nasir-welboxes">
		  	
			  	<div class="single_wel_cont col-sm-6">  
					<a class="wel-box" href="#">
						<div class="icon-box"><img src="${pageContext.request.contextPath}/img/gateway/icon-3.png" alt="" /></div>
						<h4>SPA</h4>
						<div class="overlay transition3s">
							<div class="icon_position_table">
								<div class="icon_container border_round">
									<h2>SPA</h2>
									<p>在SPA天地里，你可美化容颜、健美体形、修心养生，感受花草雨露的滋润和美疗师温柔手法的呵护。</p>
								</div>
							</div>
						</div>
					</a>
				</div>
				<div class="single_wel_cont col-sm-6">  
					<a class="wel-box" href="#">
						<div class="icon-box"><img src="${pageContext.request.contextPath}/img/gateway/icon-1.png" alt="" /></div>
						<h4>内部餐厅</h4>
						<div class="overlay transition3s">
							<div class="icon_position_table">
								<div class="icon_container border_round">
									<h2>内部餐厅</h2>
									<p>我们设立了环境优雅的餐厅，让您能够舒适的享受美食</p>
								</div>
							</div>
						</div>
					</a>
				</div>
				<div class="single_wel_cont col-sm-6">  
					<a class="wel-box" href="#">
						<div class="icon-box"><img src="${pageContext.request.contextPath}/img/gateway/icon-2.png" alt="" /></div>
						<h4>健身馆</h4>
						<div class="overlay transition3s">
							<div class="icon_position_table">
								<div class="icon_container border_round">
									<h2>健身馆</h2>
									<p>在这里，您能够体验到专业健身馆所拥有的服务</p>
								</div>
							</div>
						</div>
					</a>
				</div>
				<div class="single_wel_cont col-sm-6">  
					<a class="wel-box" href="#">
						<div class="icon-box"><img src="${pageContext.request.contextPath}/img/gateway/icon-3.png" alt="" /></div>
						<h4>自然美景</h4>
						<div class="overlay transition3s">
							<div class="icon_position_table">
								<div class="icon_container border_round">
									<h2>自然美景</h2>
									<p>环境是一个酒店的重要象征之一，我们拥有着独特的自然美景，让您享受舒适的旅程</p>
								</div>
							</div>
						</div>
					</a>
				</div>
				
			</div>
         
          </div>
        
        </div>
      </div>
    </div>
<!-- Our Offer style-->
 <section class="our-offer-htwo clearfix PageJump">
    
    <div class="container clearfix common-pad">
     
          <div class="row">
        
        <div class="col-md-4 our-offer-left">
              <div class="sec-header3">
             <h2>我们的优惠</h2>
             <h3>优质的服务，独到的优惠，我们以让客户满意为宗旨</h3>
             </div>
              <p>为了更好的服务客户，我们长期推出丰富的优惠活动。我们会为不同的人群推出不同的折扣。在每一个节日，我们都会推出不同的优惠。</p>
            <p>成为我们的会员，我们会为会员永久的提供丰厚的折扣以及更优质的服务。</p>  
            
              </div>
        <div class="col-md-8 offer-right">
              
             <div class="offer-img-box1">
            <div class="spa-offer">
                <div class="img_holder">
                  <img src="${pageContext.request.contextPath}/img/gateway/our1.jpg" class="img-responsive" alt="">
                  <div class="overlay">
                     <div class="room-ad-cont">
                          <h2>25% <span>的折扣</span></h2>
                          <h3>周末水疗优惠</h3><br/><br/>
                          <p>享受一个豪华的SPA周末，致力于帮助您放松身心。</p>
                          
                          </div>              
                      </div>
                      </div>
                 </div>
            </div>
              
            <div class="offer-img-box2">
            <div class="box1">
               <div class="img_holder">
                   <a href="booking.html">
                   	<img src="${pageContext.request.contextPath}/img/gateway/our2.jpg" class="img-responsive" alt="">
                   <div class="overlay">
                   <div class="text1">* 条件适用</div>
                   <div class="offertext1">
                       <p>15% <span class="off-txt">的折扣</span> <span class="winter-txt">在出游的<br>季节</span></p>
                       </div>
                   
                   </div>
                   </a>
                </div>
                </div>
            
            <div class="box2">
                
                <div class="img_holder">
                   <a href="booking.html">
                   	<img src="${pageContext.request.contextPath}/img/gateway/our3.jpg" class="img-responsive" alt="">
                    <div class="overlay">
                        <p>情侣 <span>优惠</span></p>
                        <h2>25% <span>的折扣</span></h2>
                        <h6>* 条件适用</h6>
                    </div>
                   </a>
                </div>
                </div>
            </div>
              </div>
        </div>
     </div>
    </section>   
    
<!-- Our Gallery style-->
 <section class="our-galler-htwo clearfix common-pad PageJump" style="background-image: url(${pageContext.request.contextPath}/img/gateway/gallbg.jpg);">
    
    <div class="container clearfix">
      
         <div class="sec-header sec-w-header">
            <h2>我们的环境</h2>
         	<h3>优美的环境，优质的服务，致力于为您带来更愉悦的体验</h3>
         </div>
     </div>
     
     <div class="fullwidth-silder">
        
        <div class="fullwidth-slider">
			<div class="item">
				<img src="${pageContext.request.contextPath}/img/gateway/gall1.jpg" alt="">
				<div class="this-overlay">
					<div class="this-texts">
						<a href="images/gallery-two/1.jpg" class="fancybox" rel="help"><i class="icon icon-Search"></i></a>
						<h4 class="this-title">我们的员工</h4>
					</div>
				</div>
			</div>
			<div class="item">
				<img src="${pageContext.request.contextPath}/img/gateway/gall2.jpg" alt="">
				<div class="this-overlay">
					<div class="this-texts">
						<a href="images/gallery-two/2.jpg" class="fancybox" rel="help"><i class="icon icon-Search"></i></a>
						<h4 class="this-title">酒店外景</h4>
					</div>
				</div>
			</div>
			<div class="item">
				<img src="${pageContext.request.contextPath}/img/gateway/gall3.jpg" alt="">
				<div class="this-overlay">
					<div class="this-texts">
						<a href="images/gallery-two/3.jpg" class="fancybox" rel="help"><i class="icon icon-Search"></i></a>
						<h4 class="this-title">卧室</h4>
					</div>
				</div>
			</div>
			<div class="item">
				<img src="${pageContext.request.contextPath}/img/gateway/gall4.jpg" alt="">
				<div class="this-overlay">
					<div class="this-texts">
						<a href="images/gallery-two/4.jpg" class="fancybox" rel="help"><i class="icon icon-Search"></i></a>
						<h4 class="this-title">游泳池</h4>
					</div>
				</div>
			</div>
			<div class="item">
				<img src="${pageContext.request.contextPath}/img/gateway/gall5.jpg" alt="">
				<div class="this-overlay">
					<div class="this-texts">
						<a href="images/gallery-two/5.jpg" class="fancybox" rel="help"><i class="icon icon-Search"></i></a>
						<h4 class="this-title">我们的餐厅</h4>
					</div>
				</div>
			</div>
         </div>
        </div>
    </section>     

<!-- Testimonials & Our Events style-->    
 <div class="container clearfix common-pad PageJump">
      <div class="row">
          <div class="col-lg-6 col-md-6">
          <div class="sec-header-two">
              <h2>客户评价</h2>
              </div>
          <div class="testimonials-wrapper">
            <div class="testimonial-sliders-two">
              <div class="item">
                  <div class="test-cont"><p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur.</p></div>
                     <div class="test-bot">
                     <div class="tst-img"><img src="${pageContext.request.contextPath}/img/gateway/test1.png" alt="" class="img-responsive"></div>
                     <div class="client_name">
                         <h5><a href="testimonials.html">Mark John - <span>Nescom Technology- Director</span></a></h5>
                         <ul>
                                            <li><a href="#"><i class="fa fa-star"></i></a></li>
                                            <li><a href="#"><i class="fa fa-star"></i></a></li>
                                            <li><a href="#"><i class="fa fa-star"></i></a></li>
                                            <li><a href="#"><i class="fa fa-star"></i></a></li>
                                            <li><a href="#"><i class="fa fa-star"></i></a></li>
                                        </ul>
                 </div>

     </div>
  </div> 

   <div class="item">         
     <div class="test-cont"><p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur.</p></div>             
     <div class="test-bot">
     <div class="tst-img"><img src="${pageContext.request.contextPath}/img/gateway/test2.png" alt="" class="img-responsive"></div>
     <div class="client_name">
       <h5><a href="testimonials.html">Mark John - <span>Nescom Technology- Director</span></a></h5>  
         <ul>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                            </ul>
         </div>             
     </div>        
 </div> 
  <div class="item">
  <div class="test-cont"><p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur.</p></div>             
     <div class="test-bot">
     <div class="tst-img"><img src="${pageContext.request.contextPath}/img/gateway/test3.png" alt="" class="img-responsive"></div>
     <div class="client_name">
       <h5><a href="testimonials.html">Mark John - <span>Nescom Technology- Director</span></a></h5>  
         <ul>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                            </ul>
         </div>

     </div>
  </div> 

   <div class="item">         
     <div class="test-cont"><p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur.</p></div>             
     <div class="test-bot">
     <div class="tst-img"><img src="${pageContext.request.contextPath}/img/gateway/test4.png" alt="" class="img-responsive"></div>
     <div class="client_name">
       <h5><a href="testimonials.html">Mark John - <span>Nescom Technology- Director</span></a></h5>  
           <ul>
             <li><a href="#"><i class="fa fa-star"></i></a></li>
             <li><a href="#"><i class="fa fa-star"></i></a></li>
             <li><a href="#"><i class="fa fa-star"></i></a></li>
             <li><a href="#"><i class="fa fa-star"></i></a></li>
              <li><a href="#"><i class="fa fa-star"></i></a></li>
            </ul>
         </div>             
     </div>        
 </div> 
  <div class="item">         
     <div class="test-cont"><p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur.</p></div>             
     <div class="test-bot">
     <div class="tst-img"><img src="${pageContext.request.contextPath}/img/gateway/test5.png" alt="" class="img-responsive"></div>
     <div class="client_name">
       <h5><a href="testimonials.html">Mark John - <span>Nescom Technology- Director</span></a></h5>
         <ul>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                                <li><a href="#"><i class="fa fa-star"></i></a></li>
                            </ul>
         </div>             
     </div>        
 </div>
</div>

</div>
          
          
          </div>
          
          
          <div class="col-lg-6 col-md-6 event-wrapper">
          
              <div class="sec-header-two">
              <h2>我们的活动</h2>
              </div>
          
              <div class="our-event-t-wrapper" style="height: 400px;overflow: auto;">
                  <c:if test="${requestScope.announcements.size()>0}">
                  <c:if test="${requestScope.announcements != null}">
                  <c:forEach items="${requestScope.announcements}" var="announcements">
                  <c:if test="${announcements.announcementType == 1 && announcements.announcementState == 1}">                 
                  <div class="media" >
                  <div class="media-left">
                      <div class="date-box">
                                <div class="date-inner">
                                    <div class="date-c-inner">
                                <p style="font-size: 20px">${announcements.activityTime}</p>
                                </div>
                                </div>
                                </div>
                                </div>
                  <div class="media-body">
                      <h2>${announcements.announcementTitle}</h2>
                      <p>${announcements.announcementContent}</p>
                      </div>
                  </div> 
                  </c:if>
                  </c:forEach>
                  </c:if>                             
                  </c:if> 
              
              </div>                 
          </div>
        </div>
     </div> 
 <!-- Get in Touch & Drop a Message style   -->   
  <div class="resot-activities clearfix">
    
    


<!-- Welcome banner  style-->

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
<!-- jQuery appear -->
<script src="${pageContext.request.contextPath}/js/gateway/jquery.appear.js"></script>    
<!-- jQuery countTo -->
<script src="${pageContext.request.contextPath}/js/gateway/jquery.countTo.js"></script>
<script src="${pageContext.request.contextPath}/js/gateway/jquery.form.js"></script>
<script src="${pageContext.request.contextPath}/js/gateway/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/js/gateway/contact.js"></script>
<script src="${pageContext.request.contextPath}/js/gateway/jquery.mixitup.min.js"></script>
<script src="${pageContext.request.contextPath}/js/gateway/jquery.fancybox.pack.js"></script>    
 <script src="${pageContext.request.contextPath}/js/gateway/jquery-ui.min.js"></script>   
<script src="${pageContext.request.contextPath}/js/gateway/custom.js"></script>


      <script type="text/javascript">
          $(function () {
              var PageJump = document.querySelectorAll(".PageJump");
              var nav_li = document.querySelectorAll(".nav.navbar-nav>li");
                console.log($(window).height);

                $(nav_li).click(function () {
                    var LiIndex = $(this).index();
                    for (var i = 0;i<nav_li.length;i++) {
                        if ($(PageJump).index()==LiIndex) {
                            // console.log($(PageJump[i]).index())
                        }
                    }

                })
          })

      </script>

</body>
</html>