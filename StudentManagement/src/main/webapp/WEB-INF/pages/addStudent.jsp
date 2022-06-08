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
    <title>查询所有学生信息</title>
    <link href="../../css/white-pink.css" rel="stylesheet" type="text/css">
    <link href="../../css/bootstrap.css" rel="stylesheet" type="text/css">
    <script src="../../js/bootstrap.js"></script>
    <script src="../../js/jquery-3.6.0.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 white-pink" style="margin-top: 20px">
            <h1>添加学生信息</h1>
            <form method="post" action="${pageContext.request.contextPath}/student/addStudent">
                <label id="userphoto">
                    <span>头像：</span>
                    <input id="chkFile" name="userphoto" onchange="previewFile()" type="file">
                </label>
                <!--            用于显示上传图片的预览图-->
                <div id="photo" style="text-align: center">
                    <img alt="" id="showImg" src="" style="border-radius: 6px;" width="100%">
                </div>
                <label style="margin-top: 10px">
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
                    <input class="btn btn-success" type="submit" value="添加">
                </label>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<script>
    function previewFile() {
        //获取显示图片对象
        let preview = document.getElementById("showImg");   // 通过元素节点查找： document.querySelector('img');
        //获取选中图片对象（包含文件的名称、大小、类型等，如file.size）
        let file = document.getElementById("chkFile").files[0];   //document.querySelector('input[type=file]').files[0];
        //声明js的文件流
        let reader = new FileReader();
        if (file) {
            //通过文件流将文件转换成Base64字符串
            reader.readAsDataURL(file);
            //转换成功后
            reader.onloadend = function () {
                //将转换结果赋值给img标签
                preview.src = reader.result;
                //输出结果
                // console.log(reader.result);
                //输出结果在多行文本框中
                // document.getElementById("showText").value = reader.result;
            }
        }
    }

    // 通过Ajax将base64字符串发送到服务器
    function upload() {
        //获取文件对象
        let file = document.getElementById("chkFile").files[0];
        //声明js的文件流
        let reader = new FileReader();
        if (file) {
            //通过文件流将文件转换成Base64字符串
            reader.readAsDataURL(file);
            //转换成功后
            reader.onloadend = function () {
                //将转换结果赋值给img标签
                let base64 = reader.result;
                // console.log(base64);
                //输出结果在多行文本框中
                // document.getElementById("showText").value = reader.result;
                // 发送base64字符串到服务器
                $.ajax({
                    url: "${pageContext.request.contextPath}/student/addStudent",
                    type: "post",
                    data: {
                        "base64": base64
                    },
                    success: function (data) {
                        console.log(data);
                    }
                });
            }
        }
    }

</script>