<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="poly.dto.EmpDTO"%>
<%@page import="static poly.util.CmmUtil.nvl"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
    
    <%
    List<EmpDTO> rList = (List<EmpDTO>)request.getAttribute("rList");
    String aemail= (String)session.getAttribute("aemail");
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
<title>MailPage</title>
<link
      rel="stylesheet"
      href="https://fonts.googleapis.com/css?family=Roboto:400,700"
    />
    <!-- https://fonts.google.com/specimen/Roboto -->
    <link rel="stylesheet" href="/resources/css/fontawesome.min.css" />
    <!-- https://fontawesome.com/ -->
    <link rel="stylesheet" href="/resources/css/bootstrap.min.css" />
    <!-- https://getbootstrap.com/ -->
    <link rel="stylesheet" href="/resources/css/templatemo-style.css">
    <!--
	Product Admin CSS Template
	https://templatemo.com/tm-524-product-admin
	-->
</head>
       <div>
		<!-- 오근태 탑 탑!!-->
		<%@ include file="/WEB-INF/view/mainPage/oTop.jsp"%>
		<!-- 탑 영역 끝-->
	   </div>
<body id="reportsPage">
    <div class="" id="home">

	   
      <div class="container mt-5">
        <div class="row tm-content-row">
          <div class="col-12 tm-block-col">
            <div class="tm-bg-primary-dark tm-block tm-block-h-auto">
              <h2 class="tm-block-title">메일 발송</h2>
              <p class="text-white">받는 사람</p>
              
           <form action="/sendMailProc.do" class="tm-signup-form row" method="post">
           
              <select class="custom-select" name="eemail">
                <option value="0">받을 사람을 선택해주세요.</option>
                <% 
                	for(EmpDTO e : rList) {
                %>
                <option value="<%=e.getEemail()%>"><%=nvl(e.getEname()) %>(<%=nvl(e.getEemail()) %>)</option>
				<%
                	}
				%>
              </select>
            </div>
          </div>
        </div>
        <!-- row -->
        <div class="row tm-content-row">

          <div class="form-group col-lg-12">
            <div class="tm-bg-primary-dark tm-block tm-block-settings">
              <h2 class="tm-block-title">메일 작성</h2>
              
    <!-- 폼 테그!!!!!!!!!!!!! -->
    
       
                <div class="form-group col-lg-12 p-0">
                  <label for="name">제목</label>
                  <input
                    id="title"
                    name="title"
                    type="text"
                    class="form-control validate"
                  />
                </div>

               <div class="form-group mb-3">
                    <label
                      for="description"
                      >내용</label
                    >
                    <textarea
                      class="form-control validate"
                      rows="3"
                      required
                      name="contents"
                    ></textarea>
                  </div>
               
                <div class="form-group col-lg-12">
                  <label class="tm-hide-sm">&nbsp;</label>
                </div>
                <div class="col-12">
                  <button
                    type="submit"
                    class="btn btn-primary btn-block text-uppercase">
                    메일 발송
                  </button>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
      <footer class="tm-footer row tm-mt-small">
        <div class="col-12 font-weight-light">
          <p class="text-center text-white mb-0 px-4 small">
            Copyright &copy; <b>2018</b> All rights reserved. 
            
            Design: <a rel="nofollow noopener" href="https://templatemo.com" class="tm-footer-link">Template Mo</a>
          </p>
        </div>
      </footer>
    </div>

    <script src="/resources/js/jquery-3.3.1.min.js"></script>
    <!-- https://jquery.com/download/ -->
    <script src="/resources/js/bootstrap.min.js"></script>
    <!-- https://getbootstrap.com/ -->
</body>
</html>