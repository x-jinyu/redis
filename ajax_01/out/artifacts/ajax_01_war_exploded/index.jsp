<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/27 0027
  Time: 10:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="js/jquery-3.4.1.js"></script>
    <script type="text/javascript">
      function fun() {
        var name = $("#name").val();
        var weight = $("#weight").val();
        var height = $("#height").val();
        $.ajax({
          url:"${pageContext.request.contextPath}/bmi",
          type:"post",
          data:{"name":name,"weight":weight,"height":height},
          dataType:"text",
          success:function (data) {
            $("#showMsg").html(data);
          }
        });
      }
    </script>

  </head>
  <body>
  <form >
    <p>姓名:<input type="text" name="name" id="name"> </p>
    <p>体重:<input type="text" name="weight" id="weight"> </p>
    <p>身高:<input type="text" name="height" id="height"> </p>
    <input type="button" value="计算" onclick="fun()"><br><br>
    <div id="showMsg"></div>
  </form>
  </body>
</html>
