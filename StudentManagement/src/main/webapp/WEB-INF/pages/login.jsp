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
    <meta name="viewport"
          content="width=device-width,initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
    <link href="../../css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="../../js/jquery-3.6.0.js"></script>
    <script src="../../js/bootstrap.js"></script>
    <title>登录</title>
    <style>
        #toast {
            display: none;
            /*    悬浮在屏幕顶端*/
            position: fixed;
            top: 10px;
            left: 0;
            width: 100%;
            height: 100%;
            margin: 0 auto;
            z-index: 1200;
        }
    </style>
</head>
<body>
<nav class="navbar navbar-light bg-light fixed-top">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="../../icon/person-fill.svg" alt="" width="30" height="24" class="d-inline-block align-text-top">
            学生管理系统
        </a>
    </div>
</nav>
<div class="container" style="margin-top: 80px">
    <div class="row" style="margin-top: 20px">
        <div class="col-12">
            <form action="${pageContext.request.contextPath}/login" method="post" id="loginform">
                <div class="form-floating mb-3">
                    <input class="form-control" name="username" id="exampleFormControlInput1"
                           placeholder="请输入你的用户名">
                    <label for="exampleFormControlInput1">Account Address</label>
                </div>
                <div class="form-floating">
                    <input type="password" class="form-control" name="password" id="exampleFormControlInput2"
                           placeholder="请输入密码">
                    <label for="exampleFormControlInput2">Password</label>
                </div>
                <div class="d-grid gap-2 col-6 mx-auto" style="margin-top: 10px">
                    <button type="submit" class="btn btn-outline-success">Submit</button>
                    <button type="reset" class="btn btn-outline-secondary">reset</button>
                </div>
            </form>
        </div>
    </div>
    <div id="toast">
        <div class="container">
            <div class="row justify-content-md-center">
                <div class="col-md-auto align-content-center">
                    <div class="alert alert-success" role="alert" id="toasttext">

                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>