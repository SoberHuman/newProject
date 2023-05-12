<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>入住率分析</title>
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
            var nowDate = +years+"-"+monhs+"-"+days;
            urls = "/countCheckinRoomTypeData/"+nowDate;
            frists();
            $(".months").on("change",function(){           	               		
                	if($(this).val() >0){
                		urls = "/countCheckInRoomTtypeMonth/"+$(this).val();           	
                    	frists();
                	}
            	
            })            
            $(".nows").on("change",function(){            	
            	if($(this).val()<4){
            		
            		if($(this).val() == 0){              		
            			urls = "/countCheckinRoomTypeData/"+nowDate;           	                	
                	}
            		if($(this).val() == 1){              		
            			urls = "/countCheckinRoomTypeWeek";           	                	
                	}
            		if($(this).val() == 2){              		       				
        				urls = "/countCheckInRoomTtypeMonth/"+monhs; 
                	}
            		if($(this).val() == 3){
                		
        				urls = "/countCheckinRoomTypeNowYear/"+years;           	                	
                	}
                		frists();
            	}
            })
            $(".dates").on("change",function(){
            	urls = "/countCheckinRoomTypeData/"+$(this).val(); 
            	frists();
            })
            $(".okSASD").on("click",function(){
            	var startDates = $(".startDates").val();
            	var stopDates = $(".stopDates").val();            	
            	urls = "/countCheckInRoomTtypeStartAndStopDates/"+startDates+"&"+stopDates; 
            	frists();
            })
            $(".yearAndDates").on("change",function(){
            	urls = "/countCheckinRoomTypeYearAndDates/"+$(this).val(); 
            	frists();
            })
             $(".okMonths").on("click",function(){
            	var months = $(".months").val();           	
            	urls = "/countCheckinRoomTypeYearAndDates/"+months; 
            	frists();
            })
            $(".okYears").on("click",function(){
            	urls = "/countCheckinRoomTypeYear/"+$(".years").val(); 
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
                tooltip: {
                    trigger: 'axis',
                    position: function (pt) {
                        return [pt[0], '14%'];
                    }
                },

                legend: {
                    data: ['入住率'],
                    x: 'left'
                },

                xAxis: {
                    type: 'category',
                    axisLine: {
                        show: false,
                    },
                    axisTick: {
                        show: false,
                    },
                    boundaryGap: true,

                    data: datas
                },
                yAxis: [{
                    type: 'value',
                    axisLine: {
                        show: false,
                    },
                    axisTick: {
                        show: false,
                    },
                    splitLine: {
                        lineStyle: {
                            type: 'dotted',
                        }
                    },
                    splitArea: {//背景条纹
                        show: true,
                        areaStyle: {
                            color: [
                                'rgba(255,255,255,0)',
                                'rgba(242,243,248,1)'
                            ]
                        }

                    },
                    min: 0,
                    splitNumber: 5,
                }],
                dataZoom: [{
                    type: "slider", /*类型*/
                    xAxisIndex: 0, /*对应的轴*/
                    bottom: "10", /*位置，定位*/
                    start: 0, /*开始*/
                    end: 100, /*结束*/
                    handleIcon: "M0,0 v9.7h5 v-9.7h-5 Z",
                    handleStyle: { /*手柄的样式*/
                        color: "#40bcf9",
                        borderColor: "#1fb2fb"
                    },
                    backgroundColor: "#e2f3ff", /*背景 */
                    dataBackground: { /*数据背景*/
                        lineStyle: {
                            color: "#000000"
                        },
                        areaStyle: {
                            color: "#d4d9dd"
                        }
                    },
                    fillerColor: "rgba(31,178,251,0.2)", /*被start和end遮住的背景*/
                    labelFormatter: function (value, params) { /*拖动时两端的文字提示*/
                        var str = "";
                        if (params.length > 4) {
                            str = params.substring(0, 4) + "…";
                        } else {
                            str = params;
                        }
                        return str;
                    }
                }],
                grid: {
                    left: '1rem',
                    right: '4%',
                    bottom: '18%',
                    top: '16%',
                    containLabel: true,
                    borderWidth: '0'
                },
                series: [
                    {
                        name: "入住率",
                        type: "line",
                        smooth: true,
                        symbol: 'circle',
                        symbolSize: 10,
                        data: datass,
                        itemStyle: {
                            normal: {
                                color: '#5fbdff',
                                lineStyle: {
                                    width: 3
                                }
                            }
                        }

                    },                                    
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
                                <li><a href="${pageContext.request.contextPath}/view/income/occupancyRate.jsp">入住率分析</a></li>
                            </ol>
                        </div>            
          	<div class="col-md-12">
                    <div class="panel panel-default tableTitle">
                        <div class="panel-heading" style="padding: 3px 0px 3px 0px;">
                          	<div class="input-group" style="float: left;">   
                       		<select class="form-control nows" style="width: 94px;padding-left: 0px;">
                       		<option value="0">日入住率</option>
                       		<option value="1">周入住率</option>
                       		<option value="2">月入住率</option>
                       		<option value="3">年入住率</option>
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
                            <div class="input-group" style="width: 251px;line-height: 35px;">
                            <span style="float: left;">按年份查询</span>
                            <input type="text" class="form-control years"style="width: 126px;" placeholder="请输入查询的年份...">
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