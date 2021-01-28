<%--
  Created by IntelliJ IDEA.
  User: NING MEI
  Date: 2020/11/20
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%
        String info=(String) request.getAttribute("info");
    %>
</head>
<body>
<center>
    <font style="color:red;font-size:40px"><%=info%></font>

</center>
</body>
</html>
