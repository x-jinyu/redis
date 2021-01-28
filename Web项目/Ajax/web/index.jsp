<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020/11/27 0027
  Time: 09:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript">
      function sendAsyncRequest() {
        //1.创建异步对象
        var xmlHttp = new XMLHttpRequest();
        //2.绑定回调事件,服务器返回的数据在这里去处理
        xmlHttp.onreadystatechange = function () {
          alert("readyState:"+xmlHttp.readyState+",status:"+xmlHttp.status);
        }
        //3.初始化异步对象
        xmlHttp.open("get","${pageContext.request.contextPath}/ajax");
        //4.发送请求
        xmlHttp.send();
      }

    </script>
  </head>
  <body>
  <input type="button" value="发送异步请求" onclick="sendAsyncRequest()">
  </body>
</html>
