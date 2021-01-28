<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/27 0027
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <script src="${pageContext.request.contextPath}/js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
        function fun1() {
            $.ajax({
                url: "${pageContext.request.contextPath}/one",
                type: "post",
                dataType: "json",
                success: function (data) {
                    $("#showOne").html("姓名:" + data.name + "-----年龄:" + data.age);
                }
            });
        }

        function fun2() {
            $.ajax({
                url: "${pageContext.request.contextPath}/list",
                type: "post",
                dataType: "json",
                success: function (data) {
                    var tou = "<table border=\"1\">\n" +
                        "<tr>\n" +
                        "<th>姓名</th>\n" +
                        "<th>性别</th>\n" +
                        "</tr>\n";
                    var middle = "";
                    for (var i = 0; i < data.length; i++) {
                        var stu = data[i];
                        middle += "<tr>\n" +
                            "<td>" + stu.name + "</td>\n" +
                            "<td>" + stu.age + "</td>\n" +
                            "</tr>\n";
                    }
                    var wei = "</table>";
                    $("#showList").html(tou + middle + wei);
                }
            });
        }

        function fun3(){
            $.ajax({
                url:"${pageContext.request.contextPath}/you",
                success:function () {
                    $("#showList").load("http://localhost:8080/index.jsp #showList");
                }
            });
        }
    </script>

</head>
<body>
<a href="javascript:fun1()">返回一个学生</a><br><br>
<a href="javascript:fun2()">返回学生表格</a><br><br>
<a href="javascript:fun3()">返回学生表格优化</a><br><br>
<div id="showOne"></div>
<div id="showList">
    <table border="1">
        <tr>
            <th>姓名</th>
            <th>年龄</th>
        </tr>
        <c:forEach items="${list}" var="stu">
        <tr>
            <td>${stu.name}</td>
            <td>${stu.age}</td>
        </tr>
        </c:forEach>
    </table>

</div>
</body>
</html>
