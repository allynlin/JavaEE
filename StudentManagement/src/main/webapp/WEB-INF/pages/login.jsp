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
    <link href="../../css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="../../js/bootstrap.js"></script>
    <script src="../../js/jquery-3.6.0.js"></script>
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
<form action="${pageContext.request.contextPath}/login" method="post" id="loginform">
    <header>
        <div class="d-flex p-4">
            <div class="text-white p-4 w-25 col-md-3">
                <div class="media h-100 bg-warning">
                    <div class="align-self-center mx-auto bg-white text-primary">
                        <h1 class="text-center text-dark">管理员登录</h1>
                        <span>${message}</span>
                        <hr style="color: black">
                        <label for="exampleFormControlInput1" class="form-label text-dark">账号</label>
                        <input type="text" class="form-control" name="username" id="exampleFormControlInput1"
                               placeholder="请输入账号信息">
                        <label for="exampleFormControlInput2" class="form-label text-dark">密码</label>
                        <input type="password" class="form-control" name="password" id="exampleFormControlInput2"
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
    <%--$("#loginform").submit(function () {--%>
    <%--    // alert("获取到了表单提交事件");--%>
    <%--    // 阻止表单默认提交--%>

    <%--    // 如果写了数据就提交给后台，否则不提交，并提示错误--%>
    <%--    if ($("#exampleFormControlInput1").val() == "" || $("#exampleFormControlInput2").val() == "") {--%>
    <%--        $("#toasttext").text("账号或密码不能为空");--%>
    <%--        $("#toast").fadeIn(1000);--%>
    <%--        setTimeout(function () {--%>
    <%--            $("#toast").fadeOut(1000);--%>
    <%--        }, 2000);--%>
    <%--        event.preventDefault();--%>
    <%--    } else {--%>
    <%--        &lt;%&ndash;// 通过Ajax提交表单&ndash;%&gt;--%>
    <%--        &lt;%&ndash;$.ajax({&ndash;%&gt;--%>
    <%--        &lt;%&ndash;    url: "${pageContext.request.contextPath}/login",&ndash;%&gt;--%>
    <%--        &lt;%&ndash;    type: "post",&ndash;%&gt;--%>
    <%--        &lt;%&ndash;    data: $("#loginform").serialize(),&ndash;%&gt;--%>
    <%--        &lt;%&ndash;    success: function (data) {&ndash;%&gt;--%>
    <%--        &lt;%&ndash;        if (data == "success") {&ndash;%&gt;--%>
    <%--        &lt;%&ndash;            window.location.href = "${pageContext.request.contextPath}/pages/main.jsp";&ndash;%&gt;--%>
    <%--        &lt;%&ndash;        } else {&ndash;%&gt;--%>
    <%--        &lt;%&ndash;            $("#toasttext").text(data);&ndash;%&gt;--%>
    <%--        &lt;%&ndash;            $("#toast").fadeIn(1000);&ndash;%&gt;--%>
    <%--        &lt;%&ndash;            setTimeout(function () {&ndash;%&gt;--%>
    <%--        &lt;%&ndash;                $("#toast").fadeOut(1000);&ndash;%&gt;--%>
    <%--        &lt;%&ndash;            }, 2000);&ndash;%&gt;--%>
    <%--        &lt;%&ndash;        }&ndash;%&gt;--%>
    <%--        &lt;%&ndash;    }&ndash;%&gt;--%>
    <%--        &lt;%&ndash;});&ndash;%&gt;--%>
    <%--        // 提交表单--%>
    <%--        event.preventDefault();--%>
    <%--    }--%>
    <%--});--%>
</script>