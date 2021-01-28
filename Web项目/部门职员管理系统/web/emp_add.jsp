<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/20 0020
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        String emp_add = (String) request.getAttribute("emp_add");
    %>
</head>
<body>
<center>
    <font style="color:red;font-size:40px"><%=emp_add%></font>

</center>

</body>
</html>
