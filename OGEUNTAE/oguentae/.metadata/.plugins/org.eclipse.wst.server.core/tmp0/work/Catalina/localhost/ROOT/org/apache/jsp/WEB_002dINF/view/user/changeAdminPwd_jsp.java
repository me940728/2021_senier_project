/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.61
 * Generated at: 2021-06-09 07:00:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.view.user;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class changeAdminPwd_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("    ");

    
    String sessionEmail = (String) session.getAttribute("sessionEmail");
    
    
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <meta charset=\"UTF-8\" />\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n");
      out.write("    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />\n");
      out.write("    <title>CHANGE_ADMIN_PWD_PAGE</title>\n");
      out.write("    <link\n");
      out.write("      rel=\"stylesheet\"\n");
      out.write("      href=\"https://fonts.googleapis.com/css?family=Roboto:400,700\"\n");
      out.write("    />\n");
      out.write("    <!-- https://fonts.google.com/specimen/Open+Sans -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/css/fontawesome.min.css\" />\n");
      out.write("    <!-- https://fontawesome.com/ -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/css/bootstrap.min.css\" />\n");
      out.write("    <!-- https://getbootstrap.com/ -->\n");
      out.write("    <link rel=\"stylesheet\" href=\"/resources/css/templatemo-style.css\">\n");
      out.write("    <!--\n");
      out.write("\tProduct Admin CSS Template\n");
      out.write("\thttps://templatemo.com/tm-524-product-admin\n");
      out.write("\t-->\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write(" <nav class=\"navbar navbar-expand-xl\">\n");
      out.write("  <div class=\"container h-100\">\n");
      out.write("                <a class=\"navbar-brand\" href=\"/user/login.do\"> <!-- / 슬레쉬 배주면 경로 뒤에 더해서 넘어가서 에러 뜸 -->\n");
      out.write("                    <h1 class=\"tm-site-title mb-0\">O-GeunTae</h1>\n");
      out.write("                </a>\n");
      out.write("                <button class=\"navbar-toggler ml-auto mr-0\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarSupportedContent\"\n");
      out.write("                    aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n");
      out.write("              <i class=\"fas fa-bars tm-nav-icon\"></i>\n");
      out.write("                </button>\n");
      out.write("   </div>\n");
      out.write(" </nav>\n");
      out.write("\n");
      out.write("    <div class=\"container tm-mt-big tm-mb-big\">\n");
      out.write("      <div class=\"row\">\n");
      out.write("        <div class=\"col-12 mx-auto tm-login-col\">\n");
      out.write("          <div class=\"tm-bg-primary-dark tm-block tm-block-h-auto\">\n");
      out.write("            <div class=\"row\">\n");
      out.write("              <div class=\"col-12 text-center\">\n");
      out.write("                <h2 class=\"tm-block-title mb-4\">\"");
      out.print(sessionEmail );
      out.write("\" 님 의 정보 변경</h2>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("            <div class=\"row mt-2\">\n");
      out.write("              <div class=\"col-12\">\n");
      out.write("              <!-- 로그인을 위한 데이터를 넘기기 위한 form 액션 -->\n");
      out.write("                <form name=\"f\" action=\"/user/changeAdminPwdProc.do\" method=\"post\" class=\"tm-login-form\" onsubmit=\"return doChangeUserCheck(this);\">\n");
      out.write("                  <div class=\"form-group\">\n");
      out.write("                  \n");
      out.write("                    <label for=\"aEmail\">바꿀 비밀번호</label> \n");
      out.write("                    <input\n");
      out.write("                      name=\"password\"\n");
      out.write("                      type=\"password\"\n");
      out.write("                      class=\"form-control validate\"\n");
      out.write("                      id=\"password\"\n");
      out.write("                      value=\"\"\n");
      out.write("                      required\n");
      out.write("                    />\n");
      out.write("                  </div>\n");
      out.write("                   <div class=\"form-group\">\n");
      out.write("                  \n");
      out.write("                    <label for=\"aEmail\">비밀번호 확인</label> \n");
      out.write("                    <input\n");
      out.write("                      name=\"passwordCheck\"\n");
      out.write("                      type=\"password\"\n");
      out.write("                      class=\"form-control validate\"\n");
      out.write("                      id=\"passwordCheck\"\n");
      out.write("                      value=\"\"\n");
      out.write("                      required\n");
      out.write("                    />\n");
      out.write("                  </div>\n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("                  \n");
      out.write("                  <div class=\"form-group mt-4\">\n");
      out.write("                    <button\n");
      out.write("                      type=\"submit\"\n");
      out.write("                      class=\"btn btn-primary btn-block text-uppercase\"\n");
      out.write("                    >\n");
      out.write("                      확인\n");
      out.write("                    </button>\n");
      out.write("                  </div>\n");
      out.write("                </form>\n");
      out.write("              </div>\n");
      out.write("            </div>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("      </div>\n");
      out.write("    </div>\n");
      out.write("    <footer class=\"tm-footer row tm-mt-small\">\n");
      out.write("      <div class=\"col-12 font-weight-light\">\n");
      out.write("<!--         <p class=\"text-center text-white mb-0 px-4 small\">\n");
      out.write("          Copyright &copy; <b>2018</b> All rights reserved. \n");
      out.write("          \n");
      out.write("          Design: <a rel=\"nofollow noopener\" href=\"https://templatemo.com\" class=\"tm-footer-link\">Template Mo</a>\n");
      out.write("        </p> -->\n");
      out.write("      </div>\n");
      out.write("    </footer>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("function doChangeUserCheck(f) {\n");
      out.write("\n");
      out.write("\tif (password.value != passwordCheck.value) {\n");
      out.write("\t\talert(\"비밀번호가 서로 다릅니다.\");\n");
      out.write("\t\tf.password.focus();\n");
      out.write("\t\treturn false;\n");
      out.write("\t}\n");
      out.write("\n");
      out.write("}\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("    <script src=\"/resources/js/jquery-3.3.1.min.js\"></script>\n");
      out.write("    <!-- https://jquery.com/download/ -->\n");
      out.write("    <script src=\"/resources/js/bootstrap.min.js\"></script>\n");
      out.write("    <!-- https://getbootstrap.com/ -->\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
