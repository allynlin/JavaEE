<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Allyn
  Date: 2022/6/2
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="UTF-8">
    <title>查询所有学生信息</title>
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
        tr{
            text-align: center;
            width: auto;
            height: auto;
        }
        td{
            text-align: center;
            width: 100px;
            height: 20px;
            line-height: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4" style="margin-top: 20px">
            <div class="col-md-12">
                <form id="findStu" method="post" class="white-pink"
                      action="${pageContext.request.contextPath}/student/findStudentsByName">
                    <h1 class="text-center">查询学生信息</h1>
                    <label>
                        <span>姓名：</span>
                        <input type="text" name="username" id="username">
                    </label>
                    <label class="text-center">
                        <input id="search" class="btn btn-success" type="submit" value="查询">
                        <button class="btn btn-outline-warning"
                                onclick="toAdd()">添加学生
                        </button>
                        <button class="btn btn-outline-success" onclick="toMain()" type="button">返回首页</button>
                    </label>
                </form>
            </div>
        </div>
        <div class="col-md-7 table-responsive" id="tab" style="margin-top: 20px">
            <table class="table table-striped table-hover" id="dataList">
            </table>
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
<script src="${pageContext.request.contextPath}/js/jquery-3.6.0.js"></script>
<script>
    $("#findStu").submit(function () {
        // 阻止表单默认提交
        event.preventDefault();
        $.ajax({
            url: "${pageContext.request.contextPath}/student/findStudentsByName",
            type: "post",
            data: {
                username: $("#username").val()
            },
            dataType: "json",
            success: function (data) {
                // 先清空表格
                $("#tab").empty();
                // 添加CSS样式white-pink
                $("#tab").addClass("white-pink");
                // 创建表格
                let str = '<table class="table table-striped table-hover" id="Stu">';
                // 再添加表头
                str += '<thead><tr><th>id</th><th>姓名</th><th>头像</th><th>年龄</th><th>班级</th><th>操作</th></tr></thead>';
                // 再添加表格内容
                str += '<tbody>';
                for (var i = 0; i < data.length; i++) {
                    str += '<tr><td>' + data[i].id + '</td><td>' + data[i].username + '</td><td><img width="100%" style="border-radius: 6px;" src="../../images/' + data[i].filename + '"</td><td>' + data[i].age + '</td><td>' + data[i].userclass + '</td><td><button class="btn btn-danger" id="del">删除</button></td><td><button class="btn btn-warning" id="up">修改</button></td></tr>';
                }
                str += '</tbody>';
                str += '</table>';
                $("#tab").append(str);
                $("#tab").trigger("create");
            }
        })
    });
    $(function () {
        // 获取删除的按钮
        $("#tab").on("click", "#del", function () {
            // 弹窗提示
            if (confirm("确定删除吗？")) {
                // 获取当前行的id
                let id = $(this).parent().parent().children().eq(0).text();
                // 获取id在表格中的位置
                let index = $(this).parent().parent().index();
                // 发送ajax请求
                $.ajax({
                    url: "${pageContext.request.contextPath}/student/deleteStudent",
                    type: "post",
                    data: {
                        id: id
                    },
                    dataType: "json",
                    success: function (data) {
                        if (data > 0) {
                            // 删除成功
                            $("#toasttext").text("删除成功");
                            $("#toast").fadeIn();
                            setTimeout(function () {
                                $("#toast").fadeOut();
                            }, 2000);
                            // 获取到id这一行
                            index += 1;
                            console.log(index);
                            $("#tab").find("tr").eq(index).remove();
                        } else {
                            // 删除失败
                            $("#toasttext").text("删除失败");
                            $("#toast").fadeIn(1000);
                            setTimeout(function () {
                                $("#toast").fadeOut(1000);
                            }, 2000);
                        }
                    }
                })
            }
        })
        // 获取修改的按钮
        $("#tab").on("click", "#up", function () {
            // 获取当前行的id
            let id = $(this).parent().parent().children().eq(0).text();
            // 获取当前行的姓名
            let username = $(this).parent().parent().children().eq(1).text();
            // 获取当前行的中的图片的src
            let filename = $(this).parent().parent().children().eq(2).children().attr("src");
            //修改filename的值，去掉../../images/
            filename = filename.substring(filename.indexOf("../../images/") + 13);
            // 获取当前行的年龄
            let age = $(this).parent().parent().children().eq(3).text();
            // 获取当前行的班级
            let userclass = $(this).parent().parent().children().eq(4).text();
            // 储存数据到localStorage
            localStorage.setItem("id", id);
            localStorage.setItem("username", username);
            localStorage.setItem("filename", filename);
            localStorage.setItem("age", age);
            localStorage.setItem("userclass", userclass);
            // 跳转到修改页面
            window.location.href = "${pageContext.request.contextPath}/upStu";
        })
    })

    function toAdd() {
        window.location.href = "${pageContext.request.contextPath}/adStu";
    }

    function toMain() {
        window.location.href = "${pageContext.request.contextPath}/toMainPage";
    }
</script>