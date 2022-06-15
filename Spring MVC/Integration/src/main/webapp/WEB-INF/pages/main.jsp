<%@ page import="com.cshbxy.pojo.Student" %><%--
  Created by IntelliJ IDEA.
  User: Allyn
  Date: 2022/6/1
  Time: 19:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>首页</title>
    <link href="../../css/white-pink.css" rel="stylesheet" type="text/css">
    <link href="../../css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="../../js/jquery-3.6.0.js"></script>
    <style>
        .nav-zd {
            width: 100%;
            background-color: #4CAF50;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12 nav-zd text-center white-pink" style="margin-top: 10px">
            <h1>欢迎来到首页</h1>
            <button class="btn btn-danger" onclick="logOut()" type="button">登出</button>
        </div>
        <div class="col-md-12 white-pink" style="margin-top: 10px">
            <div class="text-center">
                <button class="btn btn-outline-warning" onclick="toStudentController()" type="button">学生查询</button>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script>
    function toStudentController() {
        window.location.href = "${pageContext.request.contextPath}/studentControl";
    }

    function logOut() {
        window.location.href = "${pageContext.request.contextPath}/logout";
    }
</script>