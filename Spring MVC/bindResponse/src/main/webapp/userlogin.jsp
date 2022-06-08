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
    <title>首页</title>
    <link href="../css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="../js/bootstrap.js"></script>
    <script src="../js/jquery-3.6.0.js"></script>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        header {
            width: 100%;
            height: 400px;
            /*background-color: #00bfff;*/
        }

        .col-md-3 {
            margin: 0 auto;
            border: 1px solid #ccc;
            background-color: #fff;
        }

        .alert-danger {
            display: none;
        }

        .alert-success {
            display: none;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post" id="loginform">
    <header>
        <div class="d-flex p-4">
            <div class="text-white p-4 w-25 col-md-3">
                <div class="media h-100 bg-warning">
                    <div class="align-self-center mx-auto bg-white text-primary">
                        <h1 class="text-center text-dark">管理员登录</h1>
                        <hr style="color: black">
                        <span>${msg}</span>
                        <label for="exampleFormControlInput1" class="form-label text-dark">账号</label>
                        <input type="text" class="form-control" id="exampleFormControlInput1"
                               placeholder="请输入账号信息">
                        <label for="exampleFormControlInput2" class="form-label text-dark">密码</label>
                        <input type="password" class="form-control" id="exampleFormControlInput2"
                               placeholder="请输入密码">
                        <div class="d-grid gap-2 col-6 mx-auto" style="margin-top: 10px">
                            <input class="btn btn-success" type="submit" value="登录">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </header>
</form>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-md-auto align-content-center">
            <div class="alert alert-danger" role="alert">
                用户名或密码错误！
            </div>
        </div>
    </div>
</div>
<div class="container">
    <div class="row justify-content-md-center">
        <div class="col-md-auto align-content-center">
            <div class="alert alert-success" role="alert">
                登录成功！
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script>
    /**
     * 登录验证
     * 如果收到后台返回的登录成功信息，则显示登录成功的提示信息
     * 如果收到后台返回的登录失败信息，则显示登录失败的提示信息
     */
</script>