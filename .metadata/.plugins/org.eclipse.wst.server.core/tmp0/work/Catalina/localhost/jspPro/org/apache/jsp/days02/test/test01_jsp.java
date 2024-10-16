/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.93
 * Generated at: 2024-10-16 10:22:40 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.days02.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Date;
import java.util.Iterator;
import com.util.DBConn;
import java.util.ArrayList;
import org.doit.domain.DeptVO;
import org.doit.domain.EmpVO;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class test01_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(4);
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(12);
    _jspx_imports_classes.add("org.doit.domain.DeptVO");
    _jspx_imports_classes.add("java.sql.Connection");
    _jspx_imports_classes.add("java.util.Iterator");
    _jspx_imports_classes.add("java.util.Date");
    _jspx_imports_classes.add("org.doit.domain.EmpVO");
    _jspx_imports_classes.add("java.sql.ResultSet");
    _jspx_imports_classes.add("com.util.DBConn");
    _jspx_imports_classes.add("java.sql.PreparedStatement");
    _jspx_imports_classes.add("java.util.ArrayList");
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

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    ArrayList<DeptVO> deptList = new ArrayList<>();
    ArrayList<EmpVO> empList = new ArrayList<>();

    // 부서 정보 가져오기
    String deptSql = "SELECT * FROM dept";
    try {
        conn = DBConn.getConnection();
        pstmt = conn.prepareStatement(deptSql);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            DeptVO vo = new DeptVO().builder()
                .deptno(rs.getInt("deptno"))
                .dname(rs.getString("dname"))
                .loc(rs.getString("loc"))
                .build();
            deptList.add(vo);
        }
    } catch(Exception e) {
        e.printStackTrace();
    } finally {
        rs.close();
        pstmt.close();
    }

    // 선택된 부서의 직원 정보 가져오기
    String pDeptno = request.getParameter("deptno");
    int deptno = 0; // 기본값을 0으로 설정 (선택되지 않은 상태)
    try {
        if (pDeptno != null && !pDeptno.isEmpty()) {
            deptno = Integer.parseInt(pDeptno);
        }
    } catch (NumberFormatException e) {
        // 파싱 실패 시 기본값 유지
    }

    if (deptno != 0) {
        String empSql = "SELECT empno, ename, job, mgr, TO_CHAR(hiredate,'yyyy-MM-dd') hiredate, sal, comm, deptno " +
                        "FROM emp WHERE deptno = ?";
        try {
            pstmt = conn.prepareStatement(empSql);
            pstmt.setInt(1, deptno);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                EmpVO vo = new EmpVO().builder()
                    .empno(rs.getInt("empno"))
                    .ename(rs.getString("ename"))
                    .job(rs.getString("job"))
                    .mgr(rs.getInt("mgr"))
                    .hiredate(rs.getDate("hiredate"))
                    .sal(rs.getDouble("sal"))
                    .comm(rs.getDouble("comm"))
                    .deptno(rs.getInt("deptno"))
                    .build();
                empList.add(vo);
            }
        } catch(Exception e) {
            e.printStackTrace();
        } finally {
            rs.close();
            pstmt.close();
            DBConn.close();
        }
    }

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>부서 및 직원 정보</title>\r\n");
      out.write("<link rel=\"shortcut icon\" type=\"image/x-icon\" href=\"http://localhost/jspPro/images/SiSt.ico\">\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("<link rel=\"stylesheet\" href=\"http://localhost/jspPro/resources/cdn-main/example.css\">\r\n");
      out.write("<style>\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("<header>\r\n");
      out.write("    <h1 class=\"main\">부서 및 직원 정보</h1>\r\n");
      out.write("</header>\r\n");
      out.write("<div>\r\n");
      out.write(" <h2>부서 선택</h2>\r\n");
      out.write("<select name=\"deptno\" onchange=\"location.href='?deptno=' + this.value\">\r\n");
      out.write("    <option value=\"\">부서를 선택하세요.</option>\r\n");
      out.write("    ");
 for(int i = 0; i < deptList.size(); i++) {
        DeptVO dept = deptList.get(i); 
      out.write("\r\n");
      out.write("        <option value=\"");
      out.print( dept.getDeptno() );
      out.write('"');
      out.write(' ');
      out.print( (dept.getDeptno() == deptno) ? "selected" : "" );
      out.write(">\r\n");
      out.write("            ");
      out.print( dept.getDname() );
      out.write("\r\n");
      out.write("        </option>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("</select>\r\n");
      out.write("\r\n");
      out.write("<h2>직원 목록</h2>\r\n");
 if (deptno == 0) { 
      out.write("\r\n");
      out.write("    <p>부서를 선택하세요.</p>\r\n");
 } else { 
      out.write("\r\n");
      out.write("    <table>\r\n");
      out.write("        <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th><input type=\"checkbox\" id=\"checkAll\" onclick=\"toggleCheckboxes(this)\"></th>\r\n");
      out.write("                <th>empno</th>\r\n");
      out.write("                <th>ename</th>\r\n");
      out.write("                <th>job</th>\r\n");
      out.write("                <th>mgr</th>\r\n");
      out.write("                <th>hiredate</th>\r\n");
      out.write("                <th>sal</th>\r\n");
      out.write("                <th>comm</th>\r\n");
      out.write("                <th>deptno</th>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("        <tbody>\r\n");
      out.write("        ");
 if(empList.isEmpty()) { 
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td colspan=\"9\">해당 부서에 사원이 존재하지 않습니다.</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        ");
 } else {
            for(int i = 0; i < empList.size(); i++) {
                EmpVO emp = empList.get(i); 
      out.write("\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td><input type=\"checkbox\" name=\"empCheck\" value=\"");
      out.print( emp.getEmpno() );
      out.write("\" onclick=\"checkAllSelected()\"></td>\r\n");
      out.write("                <td>");
      out.print( emp.getEmpno() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( emp.getEname() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( emp.getJob() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( emp.getMgr() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( emp.getHiredate() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( emp.getSal() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( emp.getComm() );
      out.write("</td>\r\n");
      out.write("                <td>");
      out.print( emp.getDeptno() );
      out.write("</td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        ");
  }
           } 
      out.write("\r\n");
      out.write("        </tbody>\r\n");
      out.write("        <tfoot>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td colspan=\"9\">\r\n");
      out.write("                    <span class=\"badge left red\">");
      out.print( empList.size() );
      out.write("</span>명의 사원이 있습니다.\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <td colspan=\"9\">\r\n");
      out.write("                    <button onclick=\"submitCheckedEmployees()\">확인</button>\r\n");
      out.write("                </td>\r\n");
      out.write("            </tr>\r\n");
      out.write("        </tfoot>\r\n");
      out.write("    </table>\r\n");
 } 
      out.write("\r\n");
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<div id=\"output\">\r\n");
      out.write("    <!-- 선택된 직원번호가 여기 출력됩니다 -->\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("// 전체 선택 체크박스 동작\r\n");
      out.write("function toggleCheckboxes(source) {\r\n");
      out.write("    const checkboxes = document.getElementsByName('empCheck');\r\n");
      out.write("    for (let i = 0; i < checkboxes.length; i++) {\r\n");
      out.write("        checkboxes[i].checked = source.checked;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// 체크박스가 하나씩 선택될 때 전체 선택 체크박스 상태 업데이트\r\n");
      out.write("function checkAllSelected() {\r\n");
      out.write("    const checkboxes = document.getElementsByName('empCheck');\r\n");
      out.write("    const checkAll = document.getElementById('checkAll');\r\n");
      out.write("    \r\n");
      out.write("    let allChecked = true;\r\n");
      out.write("    for (let i = 0; i < checkboxes.length; i++) {\r\n");
      out.write("        if (!checkboxes[i].checked) {\r\n");
      out.write("            allChecked = false;\r\n");
      out.write("            break;\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    \r\n");
      out.write("    checkAll.checked = allChecked; // 모든 체크박스가 체크되면 전체 선택도 체크\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("// 선택된 직원 번호 출력하는 함수\r\n");
      out.write("function submitCheckedEmployees() {\r\n");
      out.write("    const checkboxes = document.getElementsByName('empCheck');\r\n");
      out.write("    const selectedEmployees = [];\r\n");
      out.write("\r\n");
      out.write("    for (let i = 0; i < checkboxes.length; i++) {\r\n");
      out.write("        if (checkboxes[i].checked) {\r\n");
      out.write("            selectedEmployees.push(checkboxes[i].value);\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("\r\n");
      out.write("    if (selectedEmployees.length > 0) {\r\n");
      out.write("        // 선택된 직원 번호들을 화면에 출력\r\n");
      out.write("        const outputDiv = document.getElementById('output');\r\n");
      out.write("        outputDiv.innerHTML = selectedEmployees.join('<br>');\r\n");
      out.write("    } else {\r\n");
      out.write("        alert('선택된 직원이 없습니다.');\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
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
