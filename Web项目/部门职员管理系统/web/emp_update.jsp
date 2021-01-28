<%@ page import="entity.Emp" %><%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2020/11/20
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        Emp emp=(Emp) request.getAttribute("key");
    %>
</head>
<body>
<center>
    <form action="/myWeb/emp/update">
        <table border="2">
            <tr>
                <td>职员编号</td>
                <td><input type="text" name="empNo" value="<%=emp.getEmpNo()%>"></td>
            </tr>
            <tr>
                <td>职员职位</td>
                <td><input type="text" name="job" value="<%=emp.getJob()%>"></td>
            </tr>
            <tr>
                <td>职员姓名</td>
                <td><input type="text" name="ename" value="<%=emp.getEname()%>"></td>
            </tr>
            <tr>
                <td>职员工资</td>
                <td><input type="text" name="sal" value="<%=emp.getSal()%>"></td>
            </tr>
            <tr>
                <td>职员补助</td>
                <td><input type="text" name="comm" value="<%=emp.getComm()%>"></td>
            </tr>
            <tr>
                <td>职员上司</td>
                <td><input type="text" name="mgr" value="<%=emp.getMgr()%>"></td>
            </tr>
            <tr>
                <td>入职日期</td>
                <td><input type="text" name="hireDate" value="<%=emp.getHireDate()%>"></td>
            </tr>
            <tr>
                <td>所在部门</td>
                <td><input type="text" name="deptNo" value="<%=emp.getDeptNo()%>"></td>
            </tr>
            <tr>
                <td><input type="submit" value="更新"></td>
                <td><input type="reset"></td>
            </tr>

        </table>


    </form>
</center>
</body>
</html>
