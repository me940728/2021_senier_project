<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>imgCheckpage</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:400,700" />
<!-- https://fonts.google.com/specimen/Roboto -->
<link rel="stylesheet" href="/resources/css/fontawesome.min.css" />
<!-- https://fontawesome.com/ -->
<link rel="stylesheet"
	href="/resources/jquery-ui-datepicker/jquery-ui.min.css"
	type="text/css" />
<!-- http://api.jqueryui.com/datepicker/ -->
<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
<!-- https://getbootstrap.com/ -->
<link rel="stylesheet" href="/resources/css/templatemo-style.css">
</head>
<div>
	<!-- 오근태 탑 탑!!-->
	<%@ include file="/WEB-INF/view/mainPage/oTop.jsp"%>
	<!-- 탑 영역 끝-->
</div>
<body id="reportsPage">

	<div>
		<div class="custom-file mt-3 mb-3">
			<input id="fileInput" type="file" style="display: none;" /> <input
				type="button" class="btn btn-primary btn-block mx-auto"
				value="출석 체크 시작"
				onclick="window.open('imgCheckTime.do','출석체크','width=490,height=350,location=no,status=no,scrollbars=yes');" />
		</div>
	</div>


</body>
</html>