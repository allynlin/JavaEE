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
            <form method="post" id="ph" enctype="multipart/form-data"
                  action="">
                <!--            用于显示上传图片的预览图-->
                <div id="photo" style="text-align: center;margin-bottom: 10px">
                    <img alt="" id="showImg" src="" style="border-radius: 6px;" width="100%">
                </div>
                <label id="userphoto">
                    <span>头像：</span>
                    <input id="pimage" name="pimage" onchange="previewFile()" type="file">
                </label>
                <label class="text-center" style="display: none">
                    <input class="btn btn-success" type="submit" value="添加">
                </label>
            </form>
        </div>
        <div class="col-md-4 white-pink" style="margin-top: 20px">
            <h1>修改学生信息</h1>
            <form method="post" id="updateStu" action="">
                <label style="display:none;">
                    <span>文件名：</span>
                    <input type="text" name="filename" id="filename">
                </label>
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
                    <input class="btn btn-warning" type="submit" is="search" value="修改">
                </label>
            </form>
            <div class="text-center">
                <button class="btn btn-outline-secondary" onclick="toStudentController()" type="button">返回学生查询页面
                </button>
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
    $(function () {
        // 读取localStorage中的filename值，并显示在页面上
        let filename = localStorage.getItem("filename");
        if (filename == null) {
        } else {
            $("#showImg").attr("src", "../../images/" + filename);
            // 将filename赋值到表单中
            $("#filename").val(filename);
        }
    })

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
                        userclass: $("#userclass").val(),
                        filename: $("#filename").val()
                    },
                    success: function (data) {
                        // console.log(data);
                        if (data > 0) {
                            $("#toasttext").text("修改成功");
                            $("#toast").fadeIn(1000);
                            setTimeout(function () {
                                $("#toast").fadeOut(1000);
                            }, 2000);
                            // 清空localStorage
                            localStorage.removeItem("id");
                            localStorage.removeItem("username");
                            localStorage.removeItem("age");
                            localStorage.removeItem("userclass");
                            localStorage.removeItem("filename");
                            setTimeout(function () {
                                window.location.href = "${pageContext.request.contextPath}/studentControl";
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

    function toMain() {
        window.location.href = "${pageContext.request.contextPath}/toMainPage";
    }

    function toStudentController() {
        window.location.href = "${pageContext.request.contextPath}/studentControl";
    }
</script>