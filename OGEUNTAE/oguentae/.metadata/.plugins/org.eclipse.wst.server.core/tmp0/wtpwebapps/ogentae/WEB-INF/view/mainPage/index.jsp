<%@page import="poly.util.CmmUtil" %>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="poly.dto.AttAnalysDTO"%>
<%@page import="poly.dto.AttMonthAnaDTO"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String aname = CmmUtil.nvl((String)session.getAttribute("aname"));
    	String aemail= (String)session.getAttribute("aemail");
    	String toDay = CmmUtil.nvl((String) request.getAttribute("toDay"));
        List<AttAnalysDTO> rList = (List<AttAnalysDTO>) request.getAttribute("rList");
        String empCount = (String) request.getAttribute("empCount");
        int empAttCount = (Integer) request.getAttribute("empAttCount");
    %>    
    <%
    if(aemail == null){
    	response.sendRedirect("/user/sessioCheck.do");	
    }
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>OGENTAE_MAINPAGE</title>
<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
	<!-- 차트 링크 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
    <!-- https://fonts.google.com/specimen/Roboto -->
    <link rel="stylesheet" href="./resources/css/fontawesome.min.css">
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="./resources/css/bootstrap.min.css">
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="./resources/css/templatemo-style.css">
    <!-- 제이쿼리 플러그인 CDN -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    <!--라이브 차트 JS 시작-->
    <script src="./resources/js/liveChart.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
	<script src="http://code.highcharts.com/highcharts.js"></script>
	<script src="http://code.highcharts.com/highcharts-more.js"></script>
	<script src="http://code.highcharts.com/modules/exporting.js"></script>
	<!-- Latest compiled and minified JavaScript -->
	<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<!-- 라이브차트 js 끝 -->
</head>
<!--div 테이블 CSS-->
<style>
        .divTable{
        display: table; width: 100%;
        text-align: center;
        color : white;
        }
        .divTableRow {
        display: table-row;
        }
        .divTableHeading {
        background-color: #EEE; display: table-header-group;
        }
        /*./divTableHead 랑 .divTableCell 의 스타일이 같아야 안깨짐 */
        .divTableHead{
        border: 1px solid #999999; display: table-cell; padding: 3px 10px; background-color: black;
        } 
        .divTableCell{
        border: 1px solid #999999; display: table-cell; padding: 3px 10px;
        }
        /*./divTableHead 랑 .divTableCell 의 스타일이 같아야 안깨짐 */
        .divTableHeading {
        background-color: #EEE; display: table-header-group; font-weight: bold;
        }
        .divTableFoot { background-color: #EEE; display: table-footer-group; font-weight: bold;
        }
        .divTableBody {
        display: table-row-group
        }

</style>
<body>
       <div>
		<!-- 오근태 탑 탑!!-->
		<%@ include file="/WEB-INF/view/mainPage/oTop.jsp"%>
		<!-- 탑 영역 끝-->
	   </div>
	   
<body id="reportsPage">

    <div class="" id="home">
<!--####################################################  로그인 유저 정보#################################-->
        <div class="container">
            <div class="row">
                <div class="col">
                    <p class="text-white mt-5 mb-5">환영합니다. <b><%=aname %>님</b></p>
                </div>
            </div>
<!--################################################## 지각자 분석 차트 #################################-->
            <div class="row tm-content-row">
                <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block">
                        <h2 class="tm-block-title">2021년 지각자 분석</h2>
                        <div class = "container"></div>
                        <canvas id="myChart"></canvas>
                    </div>
                </div>
<!--#############################################시스템 성능  ###########################################-->                
                <div class="col-sm-12 col-md-12 col-lg-6 col-xl-6 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block">
<!--################################ 성능 확인용 통신 끊기면 생성 안되고 과부하면 그래프 높이 뜀########################-->
						<!-- 성능 차트 -->
						<div class="container-fluid" id="data-container"></div>
<!--################################################### 차트 ############################################-->
                    </div>
                </div>       
<!--############################################ 출근자 뛰우는 창#############################################-->                           
                <div class="col-12 tm-block-col">
                    <div class="tm-bg-primary-dark tm-block tm-block-taller tm-block-scroll">
                        <h2 class="tm-block-title">[ <%=toDay %> ] 출근리스트 
                        	<br>( 총원 / 출근인원수 : <%=empCount %>명 / <%=empAttCount %> 명 )</h2>
                        	<div> 
                        	<!--<a>CSV 만들기</a>  --> 
                        	</div>
<!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  테이블 영역@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
								<div class="divTable" style="">
								    <!-- 테이블 머리 -->
								    <div class="divTableHead">사원번호</div>
									<div class="divTableHead">이름</div>
									<div class="divTableHead">성별</div>
									<div class="divTableHead">주소</div>
									<div class="divTableHead">생년월일</div>
									<div class="divTableHead">출근시간</div>
									<div class="divTableHead">비고</div>
								<!--테이블 바디-->	
							    <div class="divTableBody">					
												<%
												 for(AttAnalysDTO e : rList){
													 String bgColor ="";
													 if(e.getLate_Check().equals("지각")){
														  bgColor = "#FF0000";
													 } else{bgColor = "#0000FF";}
												%>   
										<!-- 테이블 로우 -->		
										 <div class="divTableRow" id="rowBgColor" style="background-color: <%=bgColor %>">     
										       <div class="divTableCell" class="empno"><%=e.getEmpno() %></div>
										       <div class="divTableCell" class="ename"><%=e.getEname() %></div>
										       <div class="divTableCell" class="sex"><%=e.getSex() %></div>
										       <div class="divTableCell" class="addrs"><%=e.getAddrs() %></div>
										       <div class="divTableCell" class="bday"><%=e.getBday() %></div>
										       <div class="divTableCell" class="attdate"><%=e.getAtt_date() %></div>
										       <div class="divTableCell" class="latecheck"><%=e.getLate_Check() %></div>							
								           </div>
										        <%
												  }
												%>  	
								    </div>
								</div>
<!--@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@  테이블 영역@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@-->
                 </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="tm-footer row tm-mt-small">
            <div class="col-12 font-weight-light">
                <p class="text-center text-white mb-0 px-4 small">
<!--                     Copyright &copy; <b>2018</b> All rights reserved. 
                    
                    Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
                </p> -->
            </div>
        </footer>
    </div>

 <!-- 지각자 분석 차트-->
<script th:inline="javascript">
var ctx = document.getElementById('myChart').getContext('2d');
var utilityChart = new Chart(ctx, {
    // The type of chart we want to create
    type: 'bar',
 
    // The data for our dataset
    data: {
        labels: ['1월', '2월', '3월', '4월', '5월', '6월', '7월','8월','9월','10월','11월','12월'],
        datasets: [{
            label: '월 별 지각자 현황',
            backgroundColor: 'rgb(245, 166, 35)',
            borderColor: 'rgb(255, 255, 255)',
            data: ["${jan}", "${feb}", "${mar}", "${apr}", "${may}", "${jun}", "${jul}", "${aug}", "${sep}", "${oct}", "${nov}", "${dec}"]
        }]
    },
 
    // Configuration options
    options: {
        legend: {
             labels: {
                  fontColor: 'white' // label color
                 }
              },
        scales: {
            // y축
            yAxes: [{
                ticks: {
                    beginAtZero:false,
                    fontColor:'white' // y축 폰트 color
                }
             }],
             // x축
             xAxes: [{
                ticks: {
                    beginAtZero:false,
                    fontColor:'white' // x축 폰트 color
                }
             }]
        }
    }
});
</script>
</body>
</html>