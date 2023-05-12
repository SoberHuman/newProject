<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>收入分析</title>
<link href="${pageContext.request.contextPath}/css/bootstrap.css" rel="stylesheet" />
<link href="${pageContext.request.contextPath}/css/reservation/reservationOp.css" rel="stylesheet" />
<script src="${pageContext.request.contextPath}/js/jquery-3.4.1.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/echarts.min.js"></script>
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
            
            
            var myChart = echarts.init(document.getElementById('echarts'));
            var dates = new Date();
            var years = dates.getFullYear();
            var monhs = dates.getMonth()+1;
            var days = dates.getDate();
            var urls;
            var datas;
            var datass;
            var nowDate = years+"-"+monhs+"-"+days;
            urls = "/countRoomTypeAllIncome/";
            frists();
            $(".months").on("change",function(){           	               		
                	if($(this).val() >0){
                		urls = "/countCheckInRoomTtypeMonth/"+$(this).val();           	
                    	frists();
                	}
            	
            })
            
            $(".nows").on("change",function(){            	
            	if($(this).val()<4){
            		$(".months").val(0);
            		
            		if($(this).val() == 0){              		
            			urls = "/countRoomTypeIncomeData/";           	                	
                	}
            		if($(this).val() == 1){              		
            			urls = "/countRoomTypeIncomeWeek";           	                	
                	}
            		if($(this).val() == 2){              		       				
        				urls = "/countRoomTypeIncomeNowMonths"; 
                	}
            		if($(this).val() == 3){                		
        				urls = "/countRoomTypeIncomeNowYear";           	                	
                	}
                		frists();
            	}
            })
            $(".okSASD").on("click",function(){
            	var startDates = $(".startDates").val();
            	var stopDates = $(".stopDates").val();
            	
            	urls = "/countRoomTypeIncomeStartAndStopDates/"+startDates+"&"+stopDates; 
            	frists();
            })
            $(".okMonths").on("click",function(){
            	var months = $(".months").val();           	
            	urls = "/countRoomTypeIncomeMonth/"+months; 
            	frists();
            })
            
            $(".okYears").on("click",function(){
            	urls = "/countRoomTypeIncomeYear/"+$(".years").val(); 
            	frists();
            })
            
            function frists() {
            	$.post(urls,function(roomTypes){   
            		datas = [];
            		datass = [];
            		for(var i=0 ;i<roomTypes.length;i++){
            			if(i % 2==0){
            				datas.push(roomTypes[i]);
            			}else{
            				datass.push(roomTypes[i]);
            			}            			
			  		}
            		option = {
//            	          title: {
//            	              text: 'ECharts 入门示例'
//            	          },
            	            tooltip: {            	            	
            	            },
            	            grid: {
        				        top: '20%',
        				        left: '1%',
        				        right: '20%',
        				        bottom: '0%',
        				        containLabel: true,
        				    },
            	            xAxis: {
            	                data: datas
            	            },
            	            yAxis: {},
            	            series: [
            	            {
            	                name: datas[0],
            	                type: 'bar',
            	                barGap:'-100%',
            	                 itemStyle: {
            	                 	normal: {
            	                    	color: '#C1232B'
            	                	}
            	            	},
//            	              data: [5, 20, 36, 10, 10, 20]
            					data: [datass[0], 0, 0, 0, 0, 0,0,0]
            	            },
            	            {
            	                name: datas[1],
            	                type: 'bar',
            	                barGap:'-100%',
            	                 itemStyle: {
            	                 	normal: {
            	                    	color: '#B5C334'
            	                	}
            	            	},
//            	              data: [5, 20, 36, 10, 10, 20]
            					data: [0, datass[1], 0, 0, 0, 0,0,0]
            	            },
            	            {
            	                name: datas[2],
            	                type: 'bar',
            	                barGap:'-100%',
            	                 itemStyle: {
            	                 	normal: {
            	                    	color: '#FCCE10'
            	                	}
            	            	},
//            	              data: [5, 20, 36, 10, 10, 20]
            					data: [0, 0, datass[2], 0, 0, 0,0,0]
            	            },
            	            {
            	                name: datas[3],
            	                type: 'bar',
            	                barGap:'-100%',
            	                 itemStyle: {
            	                 	normal: {
            	                    	color: '#E87C25'
            	                	}
            	            	},
//            	              data: [5, 20, 36, 10, 10, 20]
            					data: [0, 0, 0, datass[3], 0, 0,0,0]
            	            },
            	            {
            	                name: datas[4],
            	                type: 'bar',
            	                barGap:'-100%',
            	                 itemStyle: {
            	                 	normal: {
            	                    	color: '#27727B'
            	                	}
            	            	},
//            	              data: [5, 20, 36, 10, 10, 20]
            					data: [0, 0, 0, 0, datass[4], 0,0,0]
            	            },
            	            {
            	                name: datas[5],
            	                type: 'bar',
            	                barGap:'-100%',
            	                 itemStyle: {
            	                 	normal: {
            	                    	color: '#FE8463'
            	                	}
            	            	},
//            	              data: [5, 20, 36, 10, 10, 20]
            					data: [0, 0, 0, 0, 0, datass[5],0,0]
            	            },
            	            {
            	                name: datas[6],
            	                type: 'bar',
            	                barGap:'-100%',
            	                 itemStyle: {
            	                 	normal: {
            	                    	color: '#aa8463'
            	                	}
            	            	},
//            	              data: [5, 20, 36, 10, 10, 20]
            					data: [0, 0, 0, 0, 0, 0,datass[6],0,0]
            	            },
            	            {
            	                name: datas[7],
            	                type: 'bar',
            	                barGap:'-100%',
            	                 itemStyle: {
            	                 	normal: {
            	                    	color: '#FE8888'
            	                	}
            	            	},
//            	              data: [5, 20, 36, 10, 10, 20]
            					data: [0, 0, 0, 0, 0, 0,0,datass[7],0]
            	            },
            	              {
            	            name: '收入占比',
            	            type: 'pie',
            	            radius : '28%',
            	            center: ['85%', '20%'],
//            	          data:['衬衫','羊毛衫','雪纺衫','裤子','高跟鞋','袜子']
//            	          data: [5, 20, 36, 10, 10, 20]

            	            data:[
            	                {value:datass[0], name:datas[0],itemStyle: {color: '#C1232B'}},
            	                {value:datass[1], name:datas[1],itemStyle: {color: '#B5C334'}},
            	                {value:datass[2], name:datas[2],itemStyle: {color: '#FCCE10'}},
            	                {value:datass[3], name:datas[3],itemStyle: {color: '#E87C25'}},
            	                {value:datass[4], name:datas[4],itemStyle: {color: '#27727B'}},
            	                {value:datass[5], name:datas[5],itemStyle: {color: '#FE8463'}},
            	                {value:datass[6], name:datas[6],itemStyle: {color: '#aa8463'}},
            	                {value:datass[7], name:datas[7],itemStyle: {color: '#FE8888'}}
            	            ],
            	            itemStyle: {
            	                emphasis: {
            	                    shadowBlur: 10,
            	                    shadowOffsetX: 0,
            	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
            	                }
            	            }
            	        }
            	            ]
            	        };
            myChart.setOption(option);
            	})
            	 
            }
           
            
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
                                <li><a href="${pageContext.request.contextPath}/view/income/incomeAnalysis.jsp">收入分析</a></li>
                            </ol>
                        </div>            
          	<div class="col-md-12">
                    <div class="panel panel-default tableTitle">
                        <div class="panel-heading" style="padding: 3px 0px 3px 0px;">
                          	<div class="input-group" style="float: left;">   
                       		<select class="form-control nows" style="width: 80px;padding-left: 2px;">
                       		<option value="0">日收入</option>
                       		<option value="1">周收入</option>
                       		<option value="2">月收入</option>
                       		<option value="3">年收入</option>
                       		</select>    									                                    
                                </div>                          
                            <div class="input-group" style="float: left;width: 480px;line-height: 35px;">                            
                            <span style="float: left;">按日期查询：</span>
                            	<span style="float: left;">起：</span><input type="date" class="form-control startDates" style="float: left;width: 140px;">
                            	<span style="float: left;">止：</span><input type="date" class="form-control stopDates" style="float: left;width: 140px;">
                            	<button style="float: left;" class="btn btn-default okSASD" type="button">查询</button>
                            </div>
                            <div class="input-group" style="float: left;width: 265px;line-height: 35px;">
                            <span style="float: left;">按月份查询</span>
                            <input type="month" class="form-control months" style="width: 135px;">
                            <button class="btn btn-default okMonths" type="button" style="float: left;">查询</button>
                            </div>                          
                            <div class="input-group" style="width: 265px;line-height: 35px;">
                            <span style="float: left;">按年份查询</span>
                            <input type="text" class="form-control years"style="width: 140px;" placeholder="请输入查询的年份...">
                           	<button class="btn btn-default okYears" type="button" style="float: left;">查询</button>
                            </div>
                        </div>                                 
                    </div>
                   <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
		    	<div id="echarts" style="width: 1100px;height:430px;"></div>
                </div>
               
            </div>
         </div>
    </div>
    
</body>
</html>