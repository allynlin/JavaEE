<%--
  Created by IntelliJ IDEA.
  User: Allyn
  Date: 2022/6/8
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>修改学生信息</title>
    <link href="../../css/white-pink.css" rel="stylesheet" type="text/css">
    <link href="../../css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="../../js/bootstrap.js"></script>
    <script src="../../js/jquery-3.6.0.js"></script>
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
            z-index: 100;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 white-pink" style="margin-top: 20px">
            <h1>修改学生信息</h1>
            <span>${msg}</span>
            <form method="post" id="updateStu" action="${pageContext.request.contextPath}/student/updateStudent">
                <label>
                    <span>ID：</span>
                    <input type="number" name="id" id="id">
                </label>
                <label>
                    <span>姓名：</span>
                    <input type="text" name="username" id="username">
                </label>
                <label>
                    <span>年龄：</span>
                    <input type="number" name="age" id="age">
                </label>
                <label>
                    <span>班级：</span>
                    <input type="text" name="userclass" id="userclass">
                </label>
                <label class="text-center">
                    <input class="btn btn-success" type="submit" is="search" value="修改">
                </label>
            </form>
        </div>
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
</body>
</html>
<script>
    $(function () {
        // 读取localStorage
        var id = localStorage.getItem("id");
        var username = localStorage.getItem("username");
        var age = localStorage.getItem("age");
        var userclass = localStorage.getItem("userclass");
        // console.log(id);
        // 赋值给input
        $("#id").val(id);
        $("#username").val(username);
        $("#age").val(age);
        $("#userclass").val(userclass);
        $("#updateStu").submit(function () {
            // alert("获取到了点击事件");
            // 阻止默认行为
            event.preventDefault();
            // 确认修改
            var isUpdate = confirm("确定修改吗？");
            if (isUpdate) {
                // 发送ajax请求
                $.ajax({
                    url: "${pageContext.request.contextPath}/student/updateStudent",
                    type: "post",
                    data: {
                        id: $("#id").val(),
                        username: $("#username").val(),
                        age: $("#age").val(),
                        userclass: $("#userclass").val()
                    },
                    success: function (data) {
                        // console.log(data);
                        if (data>0) {
                            $("#toasttext").text("修改成功");
                            $("#toast").fadeIn(1000);
                            setTimeout(function () {
                                $("#toast").fadeOut(1000);
                            }, 2000);
                            setTimeout(function () {
                                window.location.href="${pageContext.request.contextPath}/studentControl";
                            }, 3000);
                        } else {
                            $("#toasttext").text("修改失败");
                            $("#toast").fadeIn(1000);
                            setTimeout(function () {
                                $("#toast").fadeOut(1000);
                            }, 2000);
                        }
                    }
                });
            }
        });
    })
</script>