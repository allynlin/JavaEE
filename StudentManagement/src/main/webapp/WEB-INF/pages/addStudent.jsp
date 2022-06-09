<%--
  Created by IntelliJ IDEA.
  User: Allyn
  Date: 2022/6/8
  Time: 12:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>添加学生</title>
    <link href="../../css/white-pink.css" rel="stylesheet" type="text/css">
    <link href="../../css/bootstrap.css" rel="stylesheet" type="text/css">
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
            <h1>添加学生信息</h1>
            <form method="post" id="ph" enctype="multipart/form-data"
                  action="">
                <label id="userphoto">
                    <span>头像：</span>
                    <input id="pimage" name="pimage" onchange="previewFile()" type="file">
                </label>
                <!--            用于显示上传图片的预览图-->
                <div id="photo" style="text-align: center;margin-bottom: 10px;display: none">
                    <img alt="" id="showImg" src="" style="border-radius: 6px;" width="100%">
                </div>
                <label class="text-center" style="display: none">
                    <input class="btn btn-success" type="submit" value="添加">
                </label>
            </form>
            <form id="myform" method="post" action="">
                <label style="display:none;">
                    <span>文件名：</span>
                    <input type="text" name="filename" id="filename">
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
                    <input class="btn btn-danger" id="adSt" type="submit" value="添加">
                </label>
            </form>
            <div class="text-center">
                <button class="btn btn-outline-warning" onclick="toStudentController()" type="button">返回学生查询页面</button>
                <button class="btn btn-outline-success" onclick="toMain()" type="button">返回首页</button>
            </div>
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
    function previewFile() {
        // 获取显示图片对象
        let preview = document.getElementById("showImg");   // 通过元素节点查找： document.querySelector('img');
        // 获取选中图片对象（包含文件的名称、大小、类型等，如file.size）
        let file = document.getElementById("pimage").files[0];   //document.querySelector('input[type=file]').files[0];
        let reader = new FileReader();
        if (file) {
            // 通过文件流将文件转换成Base64字符串
            reader.readAsDataURL(file);
            // 转换成功后
            reader.onloadend = function () {
                // 将转换结果赋值给img标签
                preview.src = reader.result;
                // 输出结果
                // console.log(reader.result);
                // 输出结果在多行文本框中
                // document.getElementById("showText").value = reader.result;
            }
            // 将photo标签的display属性设置为block，显示图片
            document.getElementById("photo").style.display = "block";
        }
        // $("#ph").submit();
        // 使用Ajax上传图片
        $.ajax({
            url: "${pageContext.request.contextPath}/student/addPhoto",
            type: "POST",
            data: new FormData($("#ph")[0]),
            contentType: false,
            processData: false,
            success: function (data) {
                // console.log(data);
                // 将data赋值给fileName
                $("#filename").val(data);
                if (data) {
                    $("#toasttext").text("图片上传成功");
                    $("#toast").fadeIn();
                    setTimeout(function () {
                        $("#toast").fadeOut();
                    }, 2000);
                } else {
                    $("#toasttext").text("图片上传失败");
                    $("#toast").fadeIn();
                    setTimeout(function () {
                        $("#toast").fadeOut();
                    }, 2000);
                    // 清空文件名
                    $("#filename").val("");
                    // 清空图片预览
                    $("#showImg").attr("src", "");
                    document.getElementById("photo").style.display = "none";
                    // 清空文件选择框
                    $("#pimage").val("");
                }
            }
        });
    }

    // 使用Ajax提交adSt表单
    $("#myform").submit(function () {
        event.preventDefault();
        $.ajax({
            url: "${pageContext.request.contextPath}/student/addStudent",
            type: "POST",
            data: {
                filename: $("#filename").val(),
                username: $("#username").val(),
                age: $("#age").val(),
                userclass: $("#userclass").val()
            },
            success: function (data) {
                // console.log(data);
                if (data == "1") {
                    $("#toasttext").text("添加成功");
                    $("#toast").fadeIn();
                    setTimeout(function () {
                        $("#toast").fadeOut();
                    }, 2000);
                    // 清空文件名
                    $("#filename").val("");
                    // 清空图片预览
                    $("#showImg").attr("src", "");
                    document.getElementById("photo").style.display = "none";
                    // 清空文件选择框
                    $("#pimage").val("");
                    // 清空表单
                    $("#myform").trigger("reset");
                } else {
                    $("#toasttext").text("添加失败");
                    $("#toast").fadeIn();
                    setTimeout(function () {
                        $("#toast").fadeOut();
                    }, 2000);
                }
            }
        });
    });

    function toMain() {
        window.location.href = "${pageContext.request.contextPath}/toMainPage";
    }

    function toStudentController() {
        window.location.href = "${pageContext.request.contextPath}/studentControl";
    }
</script>