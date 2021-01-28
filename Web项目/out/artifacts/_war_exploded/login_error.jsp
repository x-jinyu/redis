<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<center>
    <font style="color:red;font-size:40px">登录信息不存在，请重新登录</font>
    <form action="/myWeb/login" method="post">
        <table border="2">
            <tr>
                <td>用户名</td>
                <td><input type="text" name="ename"></td>
            </tr>
            <tr>
                <td>密码</td>
                <td><input type="text" name="empNo"></td>
            </tr>
            <tr>

                <td><input type="checkbox" name="ck"></td>
                <td>十天之内免登陆</td>
            </tr>
            <tr>
                <td><input type="submit" value="登录"></td>
                <td><input type="reset" ></td>
            </tr>
        </table>

    </form>

</center>
</body>
</html>