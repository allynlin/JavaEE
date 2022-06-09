<%--
  Created by IntelliJ IDEA.
  User: Allyn
  Date: 2022/6/1
  Time: 16:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <link href="../../css/white-pink.css" rel="stylesheet" type="text/css">
    <link href="../../css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="../../js/jquery-3.6.0.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-3"></div>
        <div class="col-md-6 col-md-offset-3 white-pink" style="margin-top: 10px">
            <form action="${pageContext.request.contextPath}/login" method="post" id="loginform">
                <h1>管理员登录</h1>
                <label>
                    <span>账号：</span>
                    <input type="text" class="form-control" name="username" id="exampleFormControlInput1"
                           placeholder="请输入账号信息">
                </label>
                <label>
                    <span>密码：</span>
                    <input type="password" class="form-control" name="password" id="exampleFormControlInput2"
                           placeholder="请输入密码">
                </label>
                <label class="text-center">
                    <input class="btn btn-success" type="submit" value="登录">
                </label>
            </form>
        </div>
    </div>
</div>
</body>
</html>