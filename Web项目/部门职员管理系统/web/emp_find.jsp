<%@ page import="entity.Emp" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2020/11/20
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<%
    List<Emp> empList =    (List) request.getAttribute("key");
%>
<script type="text/javascript" src="/myWeb/js/common.js"></script>
<body>
<center>
    <form action="/myWeb/emp/deleteBatch">
        <table border="2">
            <tr align="center">
                <td><input type="checkbox">全选/全不选
                    <input type="submit" value="批处理删除" id="delete" disabled/>
                </td>
                <td>职员编号</td>
                <td>职员姓名</td>
                <td>职员职位</td>
                <td>职员工资</td>
                <td colspan="2">操作</td>
            </tr>

            <%
                for(Emp emp:empList){
            %>
            <tr>
                <td><input type="checkbox" name="empNo" value="<%=emp.getEmpNo()%>"></td>
                <td><%=emp.getEmpNo()%></td>
                <td><%=emp.getEname()%></td>
                <td><%=emp.getJob()%></td>
                <td><%=emp.getSal()%></td>
                <td><a href="/myWeb/emp/delete?empNo=<%=emp.getEmpNo()%>">职员删除</a></td>
                <td><a href="/myWeb/emp/findById?empNo=<%=emp.getEmpNo()%>">详细信息</a></td>
            </tr>
            <%
                }
            %>
        </table>
    </form>
</center>
</body>
</html>
